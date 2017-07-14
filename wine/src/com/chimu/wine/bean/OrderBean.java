package com.chimu.wine.bean;

public class OrderBean {

    private Integer id;
    private Integer uid;
    private String orderNum;
    private Integer orderStatus;
    private String remark;
    private String orderTime;
    private Float orderSumprice;
    private Float actualpay;
    private Integer addressId;
    private Integer isStatus;
    private Integer pid;
    private Integer count;

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

    public String getOrderNum() {
        return this.orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getOrderStatus() {
        return this.orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOrderTime() {
        return this.orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public Float getOrderSumprice() {
        return this.orderSumprice;
    }

    public void setOrderSumprice(Float orderSumprice) {
        this.orderSumprice = orderSumprice;
    }

    public Float getActualpay() {
        return this.actualpay;
    }

    public void setActualpay(Float actualpay) {
        this.actualpay = actualpay;
    }

    public Integer getAddressId() {
        return this.addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getIsStatus() {
        return this.isStatus;
    }

    public void setIsStatus(Integer isStatus) {
        this.isStatus = isStatus;
    }

    public Integer getPid() {
        return this.pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getCount() {
        return this.count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}