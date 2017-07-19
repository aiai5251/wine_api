package com.chimu.wine.bean;

public class UserBean {
    private Integer id;
    private String avatar;
    private String name;
    private Integer isVip;
    private Integer point;
    private Integer award;
    private Integer extend_man;
    private Integer extend_moneyman;
    private Integer coupon_count;
    private Integer is_spoke;
    private String openid;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIsVip() {
        return this.isVip;
    }

    public void setIsVip(Integer isVip) {
        this.isVip = isVip;
    }

    public Integer getPoint() {
        return this.point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public Integer getAward() {
        return this.award;
    }

    public void setAward(Integer award) {
        this.award = award;
    }

    public String getOpenid() {
        return this.openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Integer getExtend_man() {
        return extend_man;
    }

    public void setExtend_man(Integer extend_man) {
        this.extend_man = extend_man;
    }

    public Integer getCoupon_count() {
        return coupon_count;
    }

    public void setCoupon_count(Integer coupon_count) {
        this.coupon_count = coupon_count;
    }

    public Integer getExtend_moneyman() {
        return extend_moneyman;
    }

    public void setExtend_moneyman(Integer extend_moneyman) {
        this.extend_moneyman = extend_moneyman;
    }

    public Integer getIs_spoke() {
        return is_spoke;
    }

    public void setIs_spoke(Integer is_spoke) {
        this.is_spoke = is_spoke;
    }
}