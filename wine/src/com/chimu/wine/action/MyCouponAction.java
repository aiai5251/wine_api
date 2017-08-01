package com.chimu.wine.action;

import com.chimu.utils.BaseAction;
import com.chimu.utils.tools.CMString;
import com.chimu.wine.bean.CouponBean;
import com.chimu.wine.bean.MyCouponBean;
import com.chimu.wine.service.CouponService;
import com.chimu.wine.service.MyCouponService;
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
public class MyCouponAction extends BaseAction {
    @Autowired()
    private MyCouponService myCouponService;
    @Autowired()
    private CouponService couponService;

    // 领取优惠券
    @RequestMapping(value = "/my_coupon_add")
    @ResponseBody
    public Map<String, Object> myCouponAddAction(HttpServletRequest request, HttpServletResponse response) {
        super.configResponse(response);
        Map<String, Object> map = new HashMap<>();
        Integer coupon_id = Integer.parseInt(request.getParameter("id"));
        Integer uid = Integer.parseInt(request.getParameter("uid"));
        MyCouponBean myCouponBean = myCouponService.getMyCouponByUidWithCouponId(uid, coupon_id);
        if (myCouponBean != null) {
            // 该用户已经领取
            return super.configResponseMap(map,0);
        } else {
            // 该用户没有领取
            CouponBean couponBean1 = couponService.getCouponById(coupon_id);
            if (couponBean1 == null) {
                // 没有这张优惠券
                return super.configResponseMap(map,0);
            }
            // 创建一个，领取
            MyCouponBean myCouponBean1 = new MyCouponBean();
            myCouponBean1.setUid(uid);
            myCouponBean1.setCoupon_id(coupon_id);
            myCouponBean1.setStatus(0);
            myCouponService.addMyCoupon(myCouponBean1);
        }

        return super.configResponseMap(map, 1);
    }


    @RequestMapping(value = "my_coupon")
    @ResponseBody
    public Map<String, Object> myCouponAction(HttpServletRequest request, HttpServletResponse response) {
        super.configResponse(response);
        String uid = request.getParameter("uid");
        String status = request.getParameter("status");
        Map<String, Object> map = new HashMap<>();
        if (CMString.isValid(status)) {
            List<MyCouponBean> myCouponList = myCouponService.getMyCouponByUidWithStatus(Integer.parseInt(uid), Integer.parseInt(status));
            map.put("data", myCouponList);
        } else {
            List<MyCouponBean> myCouponList = myCouponService.getMyCouponByUid(Integer.parseInt(uid));
            map.put("data", myCouponList);
        }
        return super.configResponseMap(map,1);
    }

}
