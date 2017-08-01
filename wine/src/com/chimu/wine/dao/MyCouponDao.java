package com.chimu.wine.dao;


import com.chimu.wine.bean.MyCouponBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MyCouponDao {
    void addMyCoupon(MyCouponBean myCouponBean);
    void modifyMyCoupon(MyCouponBean myCouponBean);

    MyCouponBean getMyCouponByUidWithCouponId(@Param("uid")Integer uid, @Param("coupon_id")Integer coupon_id);

    List<MyCouponBean> getMyCouponList();
    MyCouponBean getMyCouponByCouponId(Integer coupon_id);
    // 获取我的优惠券
    List<MyCouponBean> getMyCouponByUid(Integer uid);
    // 获取我的可用优惠券
    List<MyCouponBean> getMyCouponByUidWithStatus(@Param("uid")Integer uid, @Param("status")Integer status);

    Integer numberOfCouponByUid(Integer uid);
}
