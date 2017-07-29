package com.chimu.wine.bean;

public class MyCouponBean {
    private Integer id;
    private Integer uid;
    private Integer coupon_id;
    private Integer status;
    private CouponBean couponInfo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getCoupon_id() {
        return coupon_id;
    }

    public void setCoupon_id(Integer coupon_id) {
        this.coupon_id = coupon_id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public CouponBean getCouponInfo() {
        return couponInfo;
    }

    public void setCouponInfo(CouponBean couponInfo) {
        this.couponInfo = couponInfo;
    }
}
