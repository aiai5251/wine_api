package com.chimu.wine.dao;

import com.chimu.wine.bean.CouponBean;

import java.util.List;

public interface CouponDao {
    CouponBean getCouponById(Integer id);
    List<CouponBean> getCouponByPid(Integer pid);
    List<CouponBean> getCouponByUid(Integer uid);
    Integer numberOfCouponByUid(Integer uid);
}
