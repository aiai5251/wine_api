package com.chimu.wine.bean;

import java.util.Date;

public class CashBean {

    private Integer id;
    private Integer uid;
    private Float money;
    private Date date;

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

    public Float getMoney() {
        return this.money;
    }
    public void setMoney(Float money) {
        this.money = money;
    }


    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
}