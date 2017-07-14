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
 * MAIN_TYPE
 * 
 * @author bianj
 * @version 1.0.0 2017-07-14
 */
public class TypeBean {
    /** 版本号 */
    private static final long serialVersionUID = -3944545848027512094L;

    /** ??id */
    private Integer id;

    /** ??id */
    private Integer pid;

    /** ???? */
    private String name;

    /** ?? */
    private Integer type;

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
     * 获取????
     * 
     * @return ????
     */
    public String getName() {
        return this.name;
    }

    /**
     * 设置????
     * 
     * @param name
     *          ????
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取??
     * 
     * @return ??
     */
    public Integer getType() {
        return this.type;
    }

    /**
     * 设置??
     * 
     * @param type
     *          ??
     */
    public void setType(Integer type) {
        this.type = type;
    }
}