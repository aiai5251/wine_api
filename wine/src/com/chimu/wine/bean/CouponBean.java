package com.chimu.wine.bean;

public class CouponBean {
    /** ??? id */
    private Integer id;

    /** ?? */
    private Float price;

    /** ?? id */
    private Integer pid;

    /** ??? ?? */
    private String title;

    /** ??id */
    private Integer uid;

    /** ???? */
    private String buildTime;

    /** ???? */
    private String endTime;

    /** ?????? */
    private Integer maxPrice;

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
     * 获取??
     *
     * @return ??
     */
    public Float getPrice() {
        return this.price;
    }

    /**
     * 设置??
     *
     * @param price
     *          ??
     */
    public void setPrice(Float price) {
        this.price = price;
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
     * 获取??? ??
     *
     * @return ??? ??
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * 设置??? ??
     *
     * @param title
     *          ??? ??
     */
    public void setTitle(String title) {
        this.title = title;
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
     * 获取????
     *
     * @return ????
     */
    public String getBuildTime() {
        return this.buildTime;
    }

    /**
     * 设置????
     *
     * @param buildTime
     *          ????
     */
    public void setBuildTime(String buildTime) {
        this.buildTime = buildTime;
    }

    /**
     * 获取????
     *
     * @return ????
     */
    public String getEndTime() {
        return this.endTime;
    }

    /**
     * 设置????
     *
     * @param endTime
     *          ????
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取??????
     *
     * @return ??????
     */
    public Integer getMaxPrice() {
        return this.maxPrice;
    }

    /**
     * 设置??????
     *
     * @param maxPrice
     *          ??????
     */
    public void setMaxPrice(Integer maxPrice) {
        this.maxPrice = maxPrice;
    }
}
