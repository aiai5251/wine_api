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
 * MAIN_PRODUCT
 * 
 * @author bianj
 * @version 1.0.0 2017-07-14
 */
public class ProductBean {
    /** 版本号 */
    private static final long serialVersionUID = 1958460210267108433L;

    /** 商品 id */
    private Integer id;

    /** 商品名称 */
    private String title;

    /** 商品小标题 */
    private String submessage;

    /** 商品价格 */
    private Float price;

    /** 商品容量 */
    private Integer volume;

    /** 商品图片list */
    private String images;

    /** 商品描述 */
    private String description;

    /** 原价 */
    private Float origprice;

    /** 商品数量 */
    private Integer count;

    /** 商品详情图 */
    private String descriptionImages;

    /** 运费 */
    private Float freightMoney;

    /** 可获得积分 */
    private Integer point;

    /** 销售 */
    private Integer sales;

    /**
     * 获取商品 id
     * 
     * @return 商品 id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * 设置商品 id
     * 
     * @param id
     *          商品 id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取商品名称
     * 
     * @return 商品名称
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * 设置商品名称
     * 
     * @param title
     *          商品名称
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取商品小标题
     * 
     * @return 商品小标题
     */
    public String getSubmessage() {
        return this.submessage;
    }

    /**
     * 设置商品小标题
     * 
     * @param submessage
     *          商品小标题
     */
    public void setSubmessage(String submessage) {
        this.submessage = submessage;
    }

    /**
     * 获取商品价格
     * 
     * @return 商品价格
     */
    public Float getPrice() {
        return this.price;
    }

    /**
     * 设置商品价格
     * 
     * @param price
     *          商品价格
     */
    public void setPrice(Float price) {
        this.price = price;
    }

    /**
     * 获取商品容量
     * 
     * @return 商品容量
     */
    public Integer getVolume() {
        return this.volume;
    }

    /**
     * 设置商品容量
     * 
     * @param volume
     *          商品容量
     */
    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    /**
     * 获取商品图片list
     * 
     * @return 商品图片list
     */
    public String getImages() {
        return this.images;
    }

    /**
     * 设置商品图片list
     * 
     * @param images
     *          商品图片list
     */
    public void setImages(String images) {
        this.images = images;
    }

    /**
     * 获取商品描述
     * 
     * @return 商品描述
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * 设置商品描述
     * 
     * @param description
     *          商品描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取原价
     * 
     * @return 原价
     */
    public Float getOrigprice() {
        return this.origprice;
    }

    /**
     * 设置原价
     * 
     * @param origprice
     *          原价
     */
    public void setOrigprice(Float origprice) {
        this.origprice = origprice;
    }

    /**
     * 获取商品数量
     * 
     * @return 商品数量
     */
    public Integer getCount() {
        return this.count;
    }

    /**
     * 设置商品数量
     * 
     * @param count
     *          商品数量
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * 获取商品详情图
     * 
     * @return 商品详情图
     */
    public String getDescriptionImages() {
        return this.descriptionImages;
    }

    /**
     * 设置商品详情图
     * 
     * @param descriptionImages
     *          商品详情图
     */
    public void setDescriptionImages(String descriptionImages) {
        this.descriptionImages = descriptionImages;
    }

    /**
     * 获取运费
     * 
     * @return 运费
     */
    public Float getFreightMoney() {
        return this.freightMoney;
    }

    /**
     * 设置运费
     * 
     * @param freightMoney
     *          运费
     */
    public void setFreightMoney(Float freightMoney) {
        this.freightMoney = freightMoney;
    }

    /**
     * 获取可获得积分
     * 
     * @return 可获得积分
     */
    public Integer getPoint() {
        return this.point;
    }

    /**
     * 设置可获得积分
     * 
     * @param point
     *          可获得积分
     */
    public void setPoint(Integer point) {
        this.point = point;
    }

    /**
     * 获取销售
     * 
     * @return 销售
     */
    public Integer getSales() {
        return this.sales;
    }

    /**
     * 设置销售
     * 
     * @param sales
     *          销售
     */
    public void setSales(Integer sales) {
        this.sales = sales;
    }
}