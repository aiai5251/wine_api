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
 * MAIN_FEE_RECORD
 * 
 * @author bianj
 * @version 1.0.0 2017-07-14
 */
public class FeeRecordBean {
    /** 版本号 */
    private static final long serialVersionUID = 2130517886285084452L;

    /** ??id */
    private Integer id;

    /** ??id */
    private String uid;

    /** ???? */
    private Float money;

    /** ?? */
    private Float feeMoney;

    /**
     * 获取??id
     * 
     * @return ??id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * 设置??id
     * 
     * @param id
     *          ??id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取??id
     * 
     * @return ??id
     */
    public String getUid() {
        return this.uid;
    }

    /**
     * 设置??id
     * 
     * @param uid
     *          ??id
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * 获取????
     * 
     * @return ????
     */
    public Float getMoney() {
        return this.money;
    }

    /**
     * 设置????
     * 
     * @param money
     *          ????
     */
    public void setMoney(Float money) {
        this.money = money;
    }

    /**
     * 获取??
     * 
     * @return ??
     */
    public Float getFeeMoney() {
        return this.feeMoney;
    }

    /**
     * 设置??
     * 
     * @param feeMoney
     *          ??
     */
    public void setFeeMoney(Float feeMoney) {
        this.feeMoney = feeMoney;
    }
}