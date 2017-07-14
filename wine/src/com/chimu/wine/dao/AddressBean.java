package com.chimu.wine.dao;/*
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
 * MAIN_ADDRESS
 * 
 * @author bianj
 * @version 1.0.0 2017-07-14
 */
public class AddressBean {
    /** 版本号 */
    private static final long serialVersionUID = -2553321677238511086L;

    /** ???? id */
    private Integer id;

    /** ?????? */
    private String name;

    /** ???? ?? */
    private String tel;

    /** ?????? */
    private String defult;

    /** ?? id */
    private Integer uid;

    /**
     * 获取???? id
     * 
     * @return ???? id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * 设置???? id
     * 
     * @param id
     *          ???? id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取??????
     * 
     * @return ??????
     */
    public String getName() {
        return this.name;
    }

    /**
     * 设置??????
     * 
     * @param name
     *          ??????
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取???? ??
     * 
     * @return ???? ??
     */
    public String getTel() {
        return this.tel;
    }

    /**
     * 设置???? ??
     * 
     * @param tel
     *          ???? ??
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * 获取??????
     * 
     * @return ??????
     */
    public String getDefult() {
        return this.defult;
    }

    /**
     * 设置??????
     * 
     * @param defult
     *          ??????
     */
    public void setDefult(String defult) {
        this.defult = defult;
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
}