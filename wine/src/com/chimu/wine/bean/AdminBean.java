package com.chimu.wine.bean;

/**
 * Created by leiliang on 2017/7/12.
 */
public class AdminBean {

    /// Properties
    private String phone; // 手机号（账号）
    private String password; // 密码
    private int userId; // 用户Id

    /// Getter Methods
    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public int getUserId() {
        return userId;
    }

    /// Setter Methods
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
