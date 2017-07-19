package com.chimu.wine.bean;

import java.util.List;

public class ProductBean {

    private Integer id;
    private String title;
    private String submessage;

    /**
     * 商品价格
     */
    private Float price;

    /**
     * 商品容量
     */
    private Integer volume;

    /**
     * 商品图片list
     */
    private String images;

    /**
     * 商品描述
     */
    private String description;

    /**
     * 原价
     */
    private Float origprice;

    /**
     * 商品数量
     */
    private Integer count;

    /**
     * 商品详情图
     */
    private String description_images;

    /**
     * 运费
     */
    private Float freight_money;

    /**
     * 可获得积分
     */
    private Integer point;

    /**
     * 销售
     */
    private Integer sales;

//    促销列表
    private List<PromotionBean> promotionList;

//    优惠券列表
    private List<CouponBean> couponList;

//    评论列表
    private List<CommentBean> commentList;

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
     * @param id 商品 id
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
     * @param title 商品名称
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
     * @param submessage 商品小标题
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
     * @param price 商品价格
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
     * @param volume 商品容量
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
     * @param images 商品图片list
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
     * @param description 商品描述
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
     * @param origprice 原价
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
     * @param count 商品数量
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * 获取商品详情图
     *
     * @return 商品详情图
     */
    public String getDescription_images() {
        return this.description_images;
    }

    /**
     * 设置商品详情图
     *
     * @param description_images 商品详情图
     */
    public void setDescription_images(String description_images) {
        this.description_images = description_images;
    }

    /**
     * 获取运费
     *
     * @return 运费
     */
    public Float getFreight_money() {
        return this.freight_money;
    }

    /**
     * 设置运费
     *
     * @param freight_money 运费
     */
    public void setFreight_money(Float freight_money) {
        this.freight_money = freight_money;
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
     * @param point 可获得积分
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
     * @param sales 销售
     */
    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public List getPromotionList() {
        return promotionList;
    }

    public void setPromotionList(List promotionList) {
        this.promotionList = promotionList;
    }

    public List<CouponBean> getCouponList() {
        return couponList;
    }

    public void setCouponList(List<CouponBean> couponList) {
        this.couponList = couponList;
    }

    public List<CommentBean> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<CommentBean> commentList) {
        this.commentList = commentList;
    }
}