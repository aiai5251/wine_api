package com.chimu.wine.service;

import com.chimu.wine.bean.CouponBean;
import com.chimu.wine.dao.CouponDao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CouponService {
    private CouponDao couponDao;
    public CouponService(CouponDao couponDao) {
        this.couponDao = couponDao;
    }

    public List<CouponBean> getCouponByPid(Integer pid) {
        List<CouponBean> couponList = couponDao.getCouponByPid(pid);
        List<CouponBean> coupons = new ArrayList<>();
        for (int i = 0; i < couponList.size(); i++) {
            CouponBean couponBean = couponList.get(i);
            couponBean.setTitle("满" + couponBean.getMax_price() + "减" + couponBean.getPrice());
            coupons.add(couponBean);
        }
        return coupons;
    }

    public List<CouponBean> getCouponByUid(Integer uid) {
        return couponDao.getCouponByUid(uid);
    }

}
