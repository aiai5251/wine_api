package com.chimu.wine.bean;

import java.util.List;

public class ProductBean {

    private Integer id;
    private String title;
    private String submessage;
    private Float price;
    private Integer volume;
    private String image;
    private String description;
    private Float origprice;
    private Integer count;
    private String description_image;
    private Float freight_money;
    private Integer point;
    private Integer sales;
    private List<ImageBean> images;
    private List<ImageBean> desc_images;
    private Integer invalid; //默认下架
//    促销列表
    private List<PromotionBean> promotionList;
//    优惠券列表
    private List<CouponBean> couponList;
//    评论列表
    private List<CommentBean> commentList;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubmessage() {
        return this.submessage;
    }

    public void setSubmessage(String submessage) {
        this.submessage = submessage;
    }

    public Float getPrice() {
        return this.price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getVolume() {
        return this.volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getOrigprice() {
        return this.origprice;
    }

    public void setOrigprice(Float origprice) {
        this.origprice = origprice;
    }

    public Integer getCount() {
        return this.count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getDescription_image() {
        return this.description_image;
    }

    public void setDescription_image(String description_image) {
        this.description_image = description_image;
    }

    public Float getFreight_money() {
        return this.freight_money;
    }

    public void setFreight_money(Float freight_money) {
        this.freight_money = freight_money;
    }

    public Integer getPoint() {
        return this.point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public Integer getSales() {
        return this.sales;
    }

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

    public List<ImageBean> getImages() {
        return images;
    }

    public void setImages(List<ImageBean> images) {
        this.images = images;
    }

    public List<ImageBean> getDesc_images() {
        return desc_images;
    }

    public void setDesc_images(List<ImageBean> desc_images) {
        this.desc_images = desc_images;
    }

    public Integer getInvalid() {
        return invalid;
    }

    public void setInvalid(Integer invalid) {
        this.invalid = invalid;
    }
}