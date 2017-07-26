package com.chimu.wine.action;

import com.chimu.utils.BaseAction;
import com.chimu.utils.tools.CMString;
import com.chimu.wine.bean.CouponBean;
import com.chimu.wine.bean.OrderBean;
import com.chimu.wine.bean.UserBean;
import com.chimu.wine.service.CouponService;
import com.chimu.wine.service.OrderService;
import com.chimu.wine.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping(value = "/wine")
public class MyCenterAction extends BaseAction {
    @Autowired()
    private UserService userService;
    @Autowired()
    private OrderService orderService;
    @Autowired()
    private CouponService couponService;

    @RequestMapping(value = "/my")
    @ResponseBody
    public Map<String, Object> myAction(HttpServletRequest request, HttpServletResponse response) {
        super.configResponse(response);
        Map<String, Object> map = new HashMap<>();
        Integer id = Integer.parseInt(request.getParameter("id"));
        UserBean userBean = userService.getUserById(id);
        map.put("data", userBean);
        return super.configResponseMap(map, 1);
    }

    @RequestMapping(value = "/my_order")
    @ResponseBody
    public Map<String, Object> myOrderAction(HttpServletRequest request, HttpServletResponse response) {
        super.configResponse(response);
        Map<String, Object> map = new HashMap<>();
        String uid = request.getParameter("uid");
        String status = request.getParameter("status");
        if (CMString.isValid(status)) {
            List<OrderBean> orderList = orderService.getOrderByUidWithStatus(Integer.parseInt(uid), Integer.parseInt(status));
            map.put("data", orderList);
        } else {
            List<OrderBean> orderList = orderService.getOrderByUid(Integer.parseInt(uid));
            map.put("data", orderList);
        }
        return super.configResponseMap(map, 1);
    }

    // 领取优惠券
    @RequestMapping(value = "/my_coupon_add")
    @ResponseBody
    public Map<String, Object> myCouponAddAction(HttpServletRequest request, HttpServletResponse response) {
        super.configResponse(response);
        Map<String, Object> map = new HashMap<>();
        Integer id = Integer.parseInt(request.getParameter("id"));
        Integer uid = Integer.parseInt(request.getParameter("uid"));
        CouponBean couponBean = couponService.getCouponById(id);
        if (Objects.equals(couponBean.getUid(), uid)) {
            return super.configResponseMap(map,0);
        } else {
            couponBean.setUid(uid);
            couponService.modifyCouponById(couponBean);
        }

        return super.configResponseMap(map, 1);
    }

}
