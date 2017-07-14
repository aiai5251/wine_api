package com.chimu.wine.bean;

public class FeeRecordBean {

    private Integer id;
    private String uid;
    private Float money;
    private Float feeMoney;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Float getMoney() {
        return this.money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public Float getFeeMoney() {
        return this.feeMoney;
    }

    public void setFeeMoney(Float feeMoney) {
        this.feeMoney = feeMoney;
    }
}