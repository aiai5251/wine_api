package com.chimu.wine.service;

import com.chimu.wine.bean.CouponBean;
import com.chimu.wine.bean.MyCouponBean;
import com.chimu.wine.dao.CouponDao;
import com.chimu.wine.dao.MyCouponDao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyCouponService {
    private MyCouponDao myCouponDao;
    private CouponDao couponDao;

    public MyCouponService(MyCouponDao myCouponDao, CouponDao couponDao) {
        this.myCouponDao = myCouponDao;
        this.couponDao = couponDao;
    }

    public void addMyCoupon(MyCouponBean myCouponBean) {
        myCouponDao.addMyCoupon(myCouponBean);
    }
    public void modifyMyCoupon(MyCouponBean myCouponBean) {
        myCouponDao.modifyMyCoupon(myCouponBean);
    }

    public List<MyCouponBean> getMyCouponList() {
        List<MyCouponBean> myCouponList = myCouponDao.getMyCouponList();
        List<MyCouponBean> myCoupons = new ArrayList<>();
        for (MyCouponBean mycouponBean : myCouponList) {
            mycouponBean.setCouponInfo(getCouponDetail(mycouponBean.getCoupon_id()));
            myCoupons.add(mycouponBean);
        }
        return myCoupons;
    }

    public List<MyCouponBean> getMyCouponByUid(Integer uid) {
        List<MyCouponBean> myCouponList = myCouponDao.getMyCouponByUid(uid);
        List<MyCouponBean> myCoupons = new ArrayList<>();
        for (MyCouponBean mycouponBean : myCouponList) {
            mycouponBean.setCouponInfo(getCouponDetail(mycouponBean.getCoupon_id()));
            myCoupons.add(mycouponBean);
        }
        return myCoupons;
    }

    public MyCouponBean getMyCouponByUidWithCouponId(Integer uid, Integer coupon_id) {
        return myCouponDao.getMyCouponByUidWithCouponId(uid, coupon_id);
    }

    public List<MyCouponBean> getMyCouponByUidWithStatus(Integer uid, Integer status) {
        List<MyCouponBean> myCouponList = myCouponDao.getMyCouponByUidWithStatus(uid, status);
        List<MyCouponBean> myCoupons = new ArrayList<>();
        for (MyCouponBean mycouponBean : myCouponList) {
            mycouponBean.setCouponInfo(getCouponDetail(mycouponBean.getCoupon_id()));
            myCoupons.add(mycouponBean);
        }
        return myCoupons;
    }

    private CouponBean getCouponDetail(Integer id) {
        return couponDao.getCouponById(id);
    }

}
