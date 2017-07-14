package com.chimu.wine.bean;

public class AddressBean {

    private Integer id;
    private String name;
    private String tel;
    private String defult;
    private Integer uid;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return this.tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDefult() {
        return this.defult;
    }

    public void setDefult(String defult) {
        this.defult = defult;
    }

    public Integer getUid() {
        return this.uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}