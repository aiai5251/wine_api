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
 * MAIN_COMMENT
 * 
 * @author bianj
 * @version 1.0.0 2017-07-14
 */
public class CommentBean {
    /** 版本号 */
    private static final long serialVersionUID = 1664223025459487108L;

    /** ??id */
    private Integer id;

    /** ?? id */
    private Integer pid;

    /** ???? */
    private String message;

    /** ??id */
    private Integer uid;

    /** ?? */
    private String date;

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
    public String getMessage() {
        return this.message;
    }

    /**
     * 设置????
     * 
     * @param message
     *          ????
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 获取??id
     * 
     * @return ??id
     */
    public Integer getUid() {
        return this.uid;
    }

    /**
     * 设置??id
     * 
     * @param uid
     *          ??id
     */
    public void setUid(Integer uid) {
        this.uid = uid;
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