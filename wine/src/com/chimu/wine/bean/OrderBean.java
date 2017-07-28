package com.chimu.wine.bean;

import java.util.Date;
import java.util.List;
import java.util.Random;

public class OrderBean {

    private Integer id;
    private Integer uid;
    private String order_num;
    private Integer status;
    private Integer count;
    private String memo;
    private Integer address_id;
    private Integer coupon_id;
    private Double amount;
    private Double pay;
    private Integer point;
    private Date create_time;
    private Date modify_time;
    private Random random = new Random();

    private List<OrderDetailBean> orderDetails;
    private AddressBean addressInfo;
    private CouponBean couponInfo;

    public String MadeOrderNo(){
        return String.valueOf(new Date().getTime() + random.nextInt(1000000) + uid);
    }
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return this.uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getCount() {
        return this.count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getOrder_num() {
        return order_num;
    }

    public void setOrder_num(String order_num) {
        this.order_num = order_num;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Integer getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Integer address_id) {
        this.address_id = address_id;
    }

    public Integer getCoupon_id() {
        return coupon_id;
    }

    public void setCoupon_id(Integer coupon_id) {
        this.coupon_id = coupon_id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getModify_time() {
        return modify_time;
    }

    public void setModify_time(Date modify_time) {
        this.modify_time = modify_time;
    }

    public List<OrderDetailBean> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetailBean> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Double getPay() {
        return pay;
    }

    public void setPay(Double pay) {
        this.pay = pay;
    }

    public AddressBean getAddressInfo() {
        return addressInfo;
    }

    public void setAddressInfo(AddressBean addressInfo) {
        this.addressInfo = addressInfo;
    }

    public CouponBean getCouponInfo() {
        return couponInfo;
    }

    public void setCouponInfo(CouponBean couponInfo) {
        this.couponInfo = couponInfo;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }
}