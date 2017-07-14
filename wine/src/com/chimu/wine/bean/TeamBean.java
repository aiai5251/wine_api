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
 * MAIN_TEAM
 * 
 * @author bianj
 * @version 1.0.0 2017-07-14
 */
public class TeamBean {
    /** 版本号 */
    private static final long serialVersionUID = 6474687529465241501L;

    /** ??id */
    private Integer id;

    /** ??id */
    private String uid;

    /** ??????id */
    private String friId;

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
     * 获取??????id
     * 
     * @return ??????id
     */
    public String getFriId() {
        return this.friId;
    }

    /**
     * 设置??????id
     * 
     * @param friId
     *          ??????id
     */
    public void setFriId(String friId) {
        this.friId = friId;
    }
}