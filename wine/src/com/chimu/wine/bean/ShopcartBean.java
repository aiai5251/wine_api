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
 * MAIN_SHOPCART
 * 
 * @author bianj
 * @version 1.0.0 2017-07-14
 */
public class ShopCartBean {
    /** 版本号 */
    private static final long serialVersionUID = 6676807925904432034L;

    /** ??? id */
    private Integer id;

    /** ?? id */
    private Integer uid;

    /** ?? id */
    private Integer pid;

    /** ???? */
    private Integer sum;

    /**
     * 获取??? id
     * 
     * @return ??? id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * 设置??? id
     * 
     * @param id
     *          ??? id
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
    public Integer getSum() {
        return this.sum;
    }

    /**
     * 设置????
     * 
     * @param sum
     *          ????
     */
    public void setSum(Integer sum) {
        this.sum = sum;
    }
}