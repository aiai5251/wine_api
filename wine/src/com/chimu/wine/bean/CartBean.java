package com.chimu.wine.bean;

public class CartBean {

    private Integer id;
    private Integer uid;
    private Integer pid;
    private Integer count;
    private String title;
    private String submessage;
    private Float price;
    private Integer volume;
    private String images;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return this.uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getPid() {
        return this.pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setProductModel(ProductBean productBean) {
        this.setTitle(productBean.getTitle());
        this.setSubmessage(productBean.getSubmessage());
        this.setPrice(productBean.getPrice());
        this.setVolume(productBean.getVolume());
    }

}
