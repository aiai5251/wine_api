package com.chimu.admin.bean;

public class AdminBean {

    /// Properties
    private String phone; // 手机号（账号）
    private String password; // 密码
    private int id; // 用户Id

    /// Getter Methods
    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    /// Setter Methods
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }
}
