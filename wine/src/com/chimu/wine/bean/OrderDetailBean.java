package com.chimu.wine.bean;

public class OrderDetailBean {
    private Integer id;
    private Integer oid;
    private Integer pid;
    private Integer count;
    private Float price;
    private ProductBean productInfo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public ProductBean getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(ProductBean productInfo) {
        this.productInfo = productInfo;
    }
}
