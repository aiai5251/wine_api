package com.chimu.wine.bean;/*
 * Welcome to use the TableGo Tools.
 * 
 * http://vipbooks.iteye.com
 * http://blog.csdn.net/vipbooks
 * http://www.cnblogs.com/vipbooks
 * 
 * Author:bianj
 * Email:edinsker@163.com
 * Version:5.0.0
 */

/**
 * MAIN_ORDER
 * 
 * @author bianj
 * @version 1.0.0 2017-07-14
 */
public class OrderBean {
    /** 版本号 */
    private static final long serialVersionUID = 298734314944518548L;

    /** ?? id */
    private Integer id;

    /** ?? id */
    private Integer uid;

    /** ??? */
    private String orderNum;

    /** ???? */
    private Integer orderStatus;

    /** ?? */
    private String remark;

    /** ???? */
    private String orderTime;

    /** ???? */
    private Float orderSumprice;

    /** ??? */
    private Float actualpay;

    /** ???? id */
    private Integer addressId;

    /** 0???1???2???3??? */
    private Integer isStatus;

    /** ??id */
    private Integer pid;

    /** ???? */
    private Integer count;

    /**
     * 获取?? id
     * 
     * @return ?? id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * 设置?? id
     * 
     * @param id
     *          ?? id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取?? id
     * 
     * @return ?? id
     */
    public Integer getUid() {
        return this.uid;
    }

    /**
     * 设置?? id
     * 
     * @param uid
     *          ?? id
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * 获取???
     * 
     * @return ???
     */
    public String getOrderNum() {
        return this.orderNum;
    }

    /**
     * 设置???
     * 
     * @param orderNum
     *          ???
     */
    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    /**
     * 获取????
     * 
     * @return ????
     */
    public Integer getOrderStatus() {
        return this.orderStatus;
    }

    /**
     * 设置????
     * 
     * @param orderStatus
     *          ????
     */
    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * 获取??
     * 
     * @return ??
     */
    public String getRemark() {
        return this.remark;
    }

    /**
     * 设置??
     * 
     * @param remark
     *          ??
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取????
     * 
     * @return ????
     */
    public String getOrderTime() {
        return this.orderTime;
    }

    /**
     * 设置????
     * 
     * @param orderTime
     *          ????
     */
    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    /**
     * 获取????
     * 
     * @return ????
     */
    public Float getOrderSumprice() {
        return this.orderSumprice;
    }

    /**
     * 设置????
     * 
     * @param orderSumprice
     *          ????
     */
    public void setOrderSumprice(Float orderSumprice) {
        this.orderSumprice = orderSumprice;
    }

    /**
     * 获取???
     * 
     * @return ???
     */
    public Float getActualpay() {
        return this.actualpay;
    }

    /**
     * 设置???
     * 
     * @param actualpay
     *          ???
     */
    public void setActualpay(Float actualpay) {
        this.actualpay = actualpay;
    }

    /**
     * 获取???? id
     * 
     * @return ???? id
     */
    public Integer getAddressId() {
        return this.addressId;
    }

    /**
     * 设置???? id
     * 
     * @param addressId
     *          ???? id
     */
    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    /**
     * 获取0???1???2???3???
     * 
     * @return 0???1???2???3???
     */
    public Integer getIsStatus() {
        return this.isStatus;
    }

    /**
     * 设置0???1???2???3???
     * 
     * @param isStatus
     *          0???1???2???3???
     */
    public void setIsStatus(Integer isStatus) {
        this.isStatus = isStatus;
    }

    /**
     * 获取??id
     * 
     * @return ??id
     */
    public Integer getPid() {
        return this.pid;
    }

    /**
     * 设置??id
     * 
     * @param pid
     *          ??id
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * 获取????
     * 
     * @return ????
     */
    public Integer getCount() {
        return this.count;
    }

    /**
     * 设置????
     * 
     * @param count
     *          ????
     */
    public void setCount(Integer count) {
        this.count = count;
    }
}