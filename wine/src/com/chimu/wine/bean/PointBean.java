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
 * MAIN_POINT
 * 
 * @author bianj
 * @version 1.0.0 2017-07-14
 */
public class PointBean {
    /** 版本号 */
    private static final long serialVersionUID = 7616215254441165550L;

    /** ??id */
    private Integer id;

    /** ??id */
    private Integer pid;

    /** ??id */
    private Integer userId;

    /** ????????? */
    private Integer point;

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
     * 获取??id
     * 
     * @return ??id
     */
    public Integer getUserId() {
        return this.userId;
    }

    /**
     * 设置??id
     * 
     * @param userId
     *          ??id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取?????????
     * 
     * @return ?????????
     */
    public Integer getPoint() {
        return this.point;
    }

    /**
     * 设置?????????
     * 
     * @param point
     *          ?????????
     */
    public void setPoint(Integer point) {
        this.point = point;
    }
}