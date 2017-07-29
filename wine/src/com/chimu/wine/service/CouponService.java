package com.chimu.wine.service;

import com.chimu.wine.bean.CouponBean;
import com.chimu.wine.bean.MyCouponBean;
import com.chimu.wine.dao.CouponDao;
import com.chimu.wine.dao.MyCouponDao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CouponService {
    private CouponDao couponDao;
    private MyCouponDao myCouponDao;
    public CouponService(CouponDao couponDao, MyCouponDao myCouponDao) {
        this.couponDao = couponDao;
        this.myCouponDao = myCouponDao;
    }

    public void addCoupon(CouponBean couponBean) {
        couponDao.addCoupon(couponBean);
    }

    public void modifyCouponById(CouponBean couponBean) {
        couponDao.modifyCouponById(couponBean);
    }

    public CouponBean getCouponById(Integer id) {
        return couponDao.getCouponById(id);
    }

    public void deleteCouponById(Integer id) {
        CouponBean couponBean = couponDao.getCouponById(id);
        couponBean.setIs_delete(1);
        couponDao.modifyCouponById(couponBean);
    }

    public List<CouponBean> getCouponByPidWithUid(Integer pid, Integer uid) {
        List<CouponBean> couponList = couponDao.getCouponByPid(pid);
        List<CouponBean> coupons = new ArrayList<>();
        for (CouponBean couponBean : couponList) {
            couponBean.setTitle("满" + couponBean.getMax_price() + "减" + couponBean.getPrice());
            // 获取用户的使用情况
            MyCouponBean myCouponBean = myCouponDao.getMyCouponByUidWithCouponId(uid, couponBean.getId());
            if (myCouponBean != null) {
                // 是否已领取
                couponBean.setStatus(1);
            } else {
                couponBean.setStatus(0);
            }
            coupons.add(couponBean);
        }
        return coupons;
    }


    public List<CouponBean> getCouponByPid(Integer pid) {
        List<CouponBean> couponList = couponDao.getCouponByPid(pid);
        List<CouponBean> coupons = new ArrayList<>();
        for (CouponBean couponBean : couponList) {
            couponBean.setTitle("满" + couponBean.getMax_price() + "减" + couponBean.getPrice());
            coupons.add(couponBean);
        }
        return coupons;
    }

    public List<CouponBean> getCouponList() {
        return couponDao.getCouponList();
    }

    public MyCouponDao getMyCouponDao() {
        return myCouponDao;
    }

    public void setMyCouponDao(MyCouponDao myCouponDao) {
        this.myCouponDao = myCouponDao;
    }
}
