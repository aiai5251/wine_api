package com.chimu.wine.action;

import com.chimu.utils.BaseAction;
import com.chimu.utils.tools.CMString;
import com.chimu.wine.bean.CouponBean;
import com.chimu.wine.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        String id = request.getParameter("id");
        String pid = request.getParameter("pid");
        String uid = request.getParameter("uid");
        Map<String, Object> map = new HashMap<>();
        if (CMString.isValid(id)) {
            CouponBean couponBean = couponService.getCouponById(Integer.parseInt(id));
            map.put("data", couponBean);
        } else if (CMString.isValid(pid) && CMString.isValid(uid)) {
            List<CouponBean> couponList = couponService.getCouponByPidWithUid(Integer.parseInt(pid), Integer.parseInt(uid));
            map.put("data", couponList);
        } else {
            List<CouponBean> couponList = couponService.getCouponList();
            map.put("data", couponList);
        }
        return super.configResponseMap(map, 1);
    }

    @RequestMapping(value = "/coupon_add")
    @ResponseBody
    public Map<String, Object> addCouponAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
        super.configResponse(response);
        Map<String, Object> map = new HashMap<>();
        CouponBean couponBean = getCouponWithData(request, true);
        couponService.addCoupon(couponBean);
        map.put("data", couponBean);
        return super.configResponseMap(map,1);
    }

    @RequestMapping(value = "/coupon_modify")
    @ResponseBody
    public Map<String, Object> modifyCouponAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
        super.configResponse(response);
        Map<String, Object> map = new HashMap<>();
        CouponBean couponBean = getCouponWithData(request, false);
        couponService.modifyCouponById(couponBean);
        map.put("data", couponBean);
        return super.configResponseMap(map,1);
    }

    private CouponBean getCouponWithData(HttpServletRequest request, Boolean isAdd) throws Exception  {
        String price = request.getParameter("price");
        String max_price = request.getParameter("max_price");
        String pid = request.getParameter("pid");
        String id = request.getParameter("id");
        CouponBean couponBean;
        if (isAdd) {
            couponBean = new CouponBean();
            couponBean.setIs_delete(0);
            // 优惠券日期添加起算，修改不修改时间
            Long day = Long.parseLong(request.getParameter("day"));
            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            couponBean.setBuild_time(sdf.format(d));
            couponBean.setEnd_time(sdf.format(new Date(d.getTime() + day * 24 * 60 * 60 * 1000)));
        } else {
            couponBean = couponService.getCouponById(Integer.parseInt(id));
        }

        if (CMString.isValid(price))
            couponBean.setPrice(Integer.parseInt(price));
        if (CMString.isValid(max_price))
            couponBean.setMax_price(Integer.parseInt(max_price));
        if (CMString.isValid(pid))
            couponBean.setPid(Integer.parseInt(pid));

        return couponBean;
    }

    @RequestMapping(value = "/coupon_delete")
    @ResponseBody
    public Map<String, Object> deleteCouponAction(HttpServletRequest request, HttpServletResponse response) {
        super.configResponse(response);
        Map<String, Object> map = new HashMap<>();
        String id = request.getParameter("id");
        couponService.deleteCouponById(Integer.parseInt(id));
        return super.configResponseMap(map, 1);
    }

}
