package com.chimu.wine.bean;

/**
 * Created by didi on 2017/7/14.
 */
public class ProductBean {
    private String id;//商品id
    private String title;//商品名称
    private String submessage;//副标题
    private String volume;//单个产品容量
    private String price;//价格
    private String imgurl;//宣传图主图
    private String images;//宣传图
    private String origprice;//原价
    private String description;//详情描述
    private String count;//库存量
    private String freight_money;//运费
    private String description_images;//详情图片
    private String point;//商品积分
    private String sales;//产品销量

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubmessage() {
        return submessage;
    }
    public void setSubmessage(String submessage) {
        this.submessage = submessage;
    }

    public String getVolume() {
        return volume;
    }
    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }

    public String getImgurl() {
        return imgurl;
    }
    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getImages() {
        return images;
    }
    public void setImages(String images) {
        this.images = images;
    }

    public String getOrigprice() {
        return origprice;
    }
    public void setOrigprice(String origprice) {
        this.origprice = origprice;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getSales() {
        return sales;
    }
    public void setSales(String sales) {
        this.sales = sales;
    }

    public String getCount() {
        return count;
    }
    public void setCount(String count) {
        this.count = count;
    }

    public String getFreight_money() {
        return freight_money;
    }
    public void setFreight_money(String freight_money) {
        this.freight_money = freight_money;
    }

    public String getDescription_images() {
        return description_images;
    }
    public void setDescription_images(String description_images) {
        this.description_images = description_images;
    }

    public String getPoint() {
        return point;
    }
    public void setPoint(String point) {
        this.point = point;
    }
}
