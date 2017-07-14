package com.chimu.wine.bean;

public class CashBean {

    private Integer id;
    private Integer uid;
    private Float money;
    private String date;

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

    public String getDate() {
        return this.date;
    }
    public void setDate(String date) {
        this.date = date;
    }
}