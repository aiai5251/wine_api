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
 * MAIN_CASH
 * 
 * @author bianj
 * @version 1.0.0 2017-07-14
 */
public class CashBean {
    /** 版本号 */
    private static final long serialVersionUID = -5872037304061783125L;

    /** ?? id */
    private Integer id;

    /** ?? id */
    private Integer uid;

    /** ?? */
    private Float money;

    /** ?? */
    private String date;

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
     * 获取??
     * 
     * @return ??
     */
    public Float getMoney() {
        return this.money;
    }

    /**
     * 设置??
     * 
     * @param money
     *          ??
     */
    public void setMoney(Float money) {
        this.money = money;
    }

    /**
     * 获取??
     * 
     * @return ??
     */
    public String getDate() {
        return this.date;
    }

    /**
     * 设置??
     * 
     * @param date
     *          ??
     */
    public void setDate(String date) {
        this.date = date;
    }
}