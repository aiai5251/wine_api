package com.chimu.wine.action;

import com.chimu.utils.BaseAction;
import com.chimu.wine.bean.CouponBean;
import com.chimu.wine.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/wine")
public class CouponAction extends BaseAction {
    @Autowired()
    private CouponService couponService;

    @RequestMapping(value = "/coupon")
    @ResponseBody
    public Map<String, Object> coupon(HttpServletRequest request, HttpServletResponse response) {
        super.configResponse(response);
        String pid = request.getParameter("pid");
        String uid = request.getParameter("uid");
        Map<String, Object> map = new HashMap<>();
        if (pid != null) {
            List<CouponBean> couponList = couponService.getCouponByPid(Integer.parseInt(pid));
            map.put("data", couponList);
        } else if (uid != null) {
            List<CouponBean> couponList = couponService.getCouponByUid(Integer.parseInt(uid));
            map.put("data", couponList);
        } else {
            return super.configResponseMap(map, 0);
        }
        return super.configResponseMap(map, 1);
    }
}
