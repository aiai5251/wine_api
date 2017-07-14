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
 * MAIN_ORDER_PROUCT
 * 
 * @author bianj
 * @version 1.0.0 2017-07-14
 */
public class OrderProuctBean {
    /** 版本号 */
    private static final long serialVersionUID = -765202778419318708L;

    /** ??? */
    private String orderNum;

    /** ?? id */
    private Integer pid;

    /** ???? */
    private String title;

    /** ???? */
    private Integer count;

    /** ???? */
    private Float discount;

    /** ???? */
    private String image;

    /** ?????? */
    private String style;

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
     * 获取?? id
     * 
     * @return ?? id
     */
    public Integer getPid() {
        return this.pid;
    }

    /**
     * 设置?? id
     * 
     * @param pid
     *          ?? id
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * 获取????
     * 
     * @return ????
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * 设置????
     * 
     * @param title
     *          ????
     */
    public void setTitle(String title) {
        this.title = title;
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

    /**
     * 获取????
     * 
     * @return ????
     */
    public Float getDiscount() {
        return this.discount;
    }

    /**
     * 设置????
     * 
     * @param discount
     *          ????
     */
    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    /**
     * 获取????
     * 
     * @return ????
     */
    public String getImage() {
        return this.image;
    }

    /**
     * 设置????
     * 
     * @param image
     *          ????
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * 获取??????
     * 
     * @return ??????
     */
    public String getStyle() {
        return this.style;
    }

    /**
     * 设置??????
     * 
     * @param style
     *          ??????
     */
    public void setStyle(String style) {
        this.style = style;
    }
}