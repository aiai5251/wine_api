package com.chimu.wine.dao;

import com.chimu.wine.bean.CouponBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CouponDao {
    void addCoupon(CouponBean couponBean);
    void modifyCouponById(CouponBean couponBean);
    CouponBean getCouponById(Integer id);

    // 通过商品id查看
    List<CouponBean> getCouponByPid(Integer pid);

    // 全部优惠券
    List<CouponBean> getCouponList();
}
