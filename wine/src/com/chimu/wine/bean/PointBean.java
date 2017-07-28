package com.chimu.wine.bean;

import java.util.Date;

public class PointBean {
    private Integer id;
    private Integer uid;
    private Integer point;
    private Date create_time;
    private int type;
    private String description;

    public Integer getId() {
        return this.id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPoint() {
        return this.point;
    }
    public void setPoint(Integer point) {
        this.point = point;
    }

    public Integer getUid() {
        return uid;
    }
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}