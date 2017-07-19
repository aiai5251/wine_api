package com.chimu.wine.action;

import com.chimu.utils.BaseAction;
import com.chimu.utils.tools.CMString;
import com.chimu.wine.bean.OrderBean;
import com.chimu.wine.bean.OrderDetailBean;
import com.chimu.wine.bean.ProductBean;
import com.chimu.wine.service.CartService;
import com.chimu.wine.service.OrderDetailService;
import com.chimu.wine.service.OrderService;
import com.chimu.wine.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
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
    private CartService cartService;

    @RequestMapping(value = "/order_add", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addOrderAction(HttpServletRequest request, HttpServletResponse response) {
        super.configResponse(response);
        String uid = request.getParameter("uid");
        String pids = request.getParameter("pids");
        String counts = request.getParameter("counts");
        String amounts = request.getParameter("amounts");

        Map<String, Object> map = new HashMap<>();

        if (CMString.isValid(pids) && CMString.isValid(counts)) {
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
                    productService.modifyProduct(productBean);
                }
            }

            OrderBean orderBean = new OrderBean();
            orderBean.setUid(Integer.parseInt(uid));
            orderBean.setOrder_num(orderBean.MadeOrderNo());
            orderBean.setStatus(0);
            orderBean.setCount(orderCount);
            orderBean.setAmount(orderPrice);
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
                    cartService.deleteCartByPidWithUid(pid, Integer.parseInt(uid));
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
        OrderBean orderBean = orderService.getOrderById(Integer.parseInt(id));
        if (orderBean != null) {
            map.put("data", orderBean);
            return super.configResponseMap(map, 1);
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
            orderBean.setModify_time(new Date());
            orderService.modifyOrder(orderBean);
            return super.configResponseMap(map, 1);
        }
        return super.configResponseMap(map, 0);
    }

}
