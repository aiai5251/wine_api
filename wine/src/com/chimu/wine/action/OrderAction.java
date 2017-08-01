package com.chimu.wine.action;

import com.chimu.utils.BaseAction;
import com.chimu.utils.Constant;
import com.chimu.utils.tools.CMString;
import com.chimu.utils.tools.FileGlobal;
import com.chimu.utils.tools.WeChatGlobal;
import com.chimu.wine.bean.*;
import com.chimu.wine.service.*;
import org.apache.commons.io.IOUtils;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/wine")
public class OrderAction extends BaseAction {
    @Autowired()
    private OrderService orderService;
    @Autowired()
    private ProductService productService;
    @Autowired()
    private OrderDetailService orderDetailService;
    @Autowired()
    private WechatService wechatService;
    @Autowired()
    private CartService cartService;
    @Autowired()
    private UserService userService;

    @RequestMapping(value = "/order_add", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addOrderAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
        super.configResponse(response);
        String uid = request.getParameter("uid");
        String pids = request.getParameter("pids");
        String counts = request.getParameter("counts");
        String amounts = request.getParameter("amounts");

        Map<String, Object> map = new HashMap<>();

        if (CMString.isValid(pids) && CMString.isValid(counts) && CMString.isValid(amounts)) {
            String[] detail_pids = pids.split(",");
            String[] detail_counts = counts.split(",");
            String[] detail_amounts = amounts.split(",");

            // 先去判断是否每一个商品的库存都足够
            Boolean enough = false;
            for (int i = 0; i < detail_pids.length; i++) {
                Integer pid = Integer.parseInt(detail_pids[i]);
                Integer count = Integer.parseInt(detail_counts[i]);
                if (pid > 0 && count > 0) {
                    ProductBean productBean = productService.getProductWithId(pid);
                    // 购买数量超过库存，库存为0
                    if (productBean.getCount() >= count) {
                        enough = true;
                    } else {
                        map.put("message", "库存不足");
                        return super.configResponseMap(map, 0);
                    }
                }
            }

            Integer orderCount = 0;
            Double orderPrice = 0.0;
            if (enough) { //如果库存足够
                for (int i = 0; i < detail_pids.length; i++) {
                    ProductBean productBean = productService.getProductWithId(Integer.parseInt(detail_pids[i]));
                    Integer count = Integer.parseInt(detail_counts[i]);
                    orderCount += count;
                    Double price = Double.parseDouble(detail_amounts[i]);
                    orderPrice += price;
                    productBean.setCount(productBean.getCount() - count);
                    productBean.setSales(productBean.getSales() + count);
                    productService.modifyProduct(productBean, null, null);
                }
            }

            OrderBean orderBean = new OrderBean();
            orderBean.setUid(Integer.parseInt(uid));
            orderBean.setOrder_num(orderBean.MadeOrderNo());
            orderBean.setStatus(0);
            orderBean.setCount(orderCount);
            orderBean.setAmount(orderPrice);
            // 四舍五入
            orderBean.setPoint(0);
            orderBean.setCreate_time(new Date());
            orderService.addOrder(orderBean);

            for(int i = 0; i < detail_pids.length; i++) {
                Integer pid = Integer.parseInt(detail_pids[i]);
                Integer count = Integer.parseInt(detail_counts[i]);
                Float price = Float.parseFloat(detail_amounts[i]);
                if (pid > 0 && count > 0) {
                    OrderDetailBean orderDetailBean = new OrderDetailBean();
                    orderDetailBean.setOid(orderBean.getId());
                    orderDetailBean.setCount(count);
                    orderDetailBean.setPid(pid);
                    orderDetailBean.setPrice(price);
                    orderDetailService.addOrderDetail(orderDetailBean);
                }
            }
            map.put("data", orderBean);
            return super.configResponseMap(map, 1);
        }
        return super.configResponseMap(map, 0);
    }

    @RequestMapping(value = "/order")
    @ResponseBody
    public Map<String, Object> orderAction(HttpServletRequest request, HttpServletResponse response) {
        super.configResponse(response);
        Map<String, Object> map = new HashMap<>();
        String id = request.getParameter("id");
        String uid = request.getParameter("uid");
        String order_num =request.getParameter("order_num");
        if (CMString.isValid(id)) {
            OrderBean orderBean = orderService.getOrderById(Integer.parseInt(id));
            if (orderBean != null) {
                // 只为了展示当前订单送多少积分
                orderBean.setPoint((int)Math.round((orderBean.getAmount() / 10.0)));
                map.put("data", orderBean);
                return super.configResponseMap(map, 1);
            }
        } else if (CMString.isValid(uid)) {
            List<OrderBean> orderList = orderService.getOrderByUid(Integer.parseInt(uid));
            map.put("data", orderList);
            return super.configResponseMap(map, 1);
        } else if (CMString.isValid(order_num)) {
            OrderBean orderBean = orderService.getOrderByOrderNum(order_num);
            if (orderBean != null) {
                map.put("data", orderBean);
                return super.configResponseMap(map, 1);
            }
        } else {
            List<OrderBean> orderList = orderService.getOrderList();
            map.put("data", orderList);
        }
        return super.configResponseMap(map, 0);
    }

    @RequestMapping(value = "/order_modify")
    @ResponseBody
    public Map<String, Object> modifyOrderAction(HttpServletRequest request, HttpServletResponse response) {
        super.configResponse(response);
        String id = request.getParameter("id");
        String address_id = request.getParameter("address_id");
        String coupon_id = request.getParameter("coupon_id");
        String status = request.getParameter("status");
        String memo = request.getParameter("memo");
        String pay = request.getParameter("pay");
        String point = request.getParameter("point");

        Map<String, Object> map = new HashMap<>();
        OrderBean orderBean = orderService.getOrderById(Integer.parseInt(id));
        if (orderBean != null) {
            if (CMString.isValid(address_id)) {
                orderBean.setAddress_id(Integer.parseInt(address_id));
            }
            if (CMString.isValid(coupon_id)) {
                orderBean.setCoupon_id(Integer.parseInt(coupon_id));
            }
            if (CMString.isValid(status)) {
                orderBean.setStatus(Integer.parseInt(status));
            }
            if (CMString.isValid(memo)) {
                orderBean.setMemo(memo);
            }
            if (CMString.isValid(pay)) {
                orderBean.setPay(Double.parseDouble(pay));
            }
            if (CMString.isValid(point)) {
                orderBean.setPoint(Integer.parseInt(point));
            }
            orderBean.setModify_time(new Date());
            orderService.modifyOrder(orderBean);

            return super.configResponseMap(map, 1);
        }
        return super.configResponseMap(map, 0);
    }

    @RequestMapping(value = "wechat_pay")
    @ResponseBody
    public Map<String, Object> wechatPayAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
        super.configResponse(response);
        Map<String, Object> map = new HashMap<>();
        String order_num = request.getParameter("order_num");
        String openid = request.getParameter("openid");
        String amount = request.getParameter("amount");

        String perPay = wechatService.getPerPayId(order_num, openid, amount);
        System.out.print("------------+++++++++++++ " + perPay + ".....");
        String url = "\"http://www.main-zha.com/wine/my.html\"";
        try {
            response.sendRedirect("http://www.main-zha.com/WxPay.jsp?data=" + perPay + "&url=" + url);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return super.configResponseMap(map, 0);
    }

    @RequestMapping(value = "/wechat_notify")
    @ResponseBody
    public Map<String, Object> weChatNotifyAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
        super.configResponse(response);
        String xml = IOUtils.toString(request.getInputStream());
        FileGlobal.AddWeChatFile(xml, "C:/Notify/");
        String order_num = WeChatGlobal.getOrderNumWithXML(xml, "out_trade_no");

        System.out.print("订单order_num：" + order_num);
        if (CMString.isValid(order_num)) {
            // 支付完成 更改状态
            OrderBean orderBean = orderService.getOrderByOrderNum(order_num);
            if (orderBean != null && orderBean.getStatus() == 0) {
                orderBean.setStatus(1);
                orderService.modifyOrder(orderBean);

                // 删除购物车中的商品
                List<OrderDetailBean> orderDetails = orderBean.getOrderDetails();
                for (OrderDetailBean orderDetailBean : orderDetails) {
                    cartService.deleteCartByPidWithUid(orderDetailBean.getPid(), orderBean.getUid());
                }

            }

            response.getWriter().print(WeChatGlobal.getSucceedXML("SUCCESS", "OK"));
        }
        return null;
    }

    @RequestMapping(value = "/wechat_send")
    @ResponseBody
    public Map<String, Object> sendWechatAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
        super.configResponse(response);
        String wcid = request.getParameter("wcid");
        String message = request.getParameter("message");
        response.getWriter().print(String.format("%s", wechatService.sendWechat(wcid, message)));
        return null;
    }

}
