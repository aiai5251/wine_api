package com.chimu.wine.dao;

import com.chimu.wine.bean.CouponBean;

import java.util.List;

public interface CouponDao {
    void addCoupon(CouponBean couponBean);
    void modifyCouponById(CouponBean couponBean);
    CouponBean getCouponById(Integer id);
    void  deleteCouponById(Integer id);

    // 通过商品id查看
    List<CouponBean> getCouponByPid(Integer pid);
    // 我的优惠券
    List<CouponBean> getCouponByUid(Integer uid);
    Integer numberOfCouponByUid(Integer uid);

    // 查看未使用的优惠券
    List<CouponBean> getCouponByUidWithStatus(Integer uid);

    // 全部优惠券
    List<CouponBean> getCouponList();
}
