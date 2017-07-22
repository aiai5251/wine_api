package com.chimu.wine.dao;

import com.chimu.wine.bean.UserBean;

import java.util.List;

public interface UserDao {
    void addUser(UserBean userBean);
    void modifyUser(UserBean userBean);
    List<UserBean> getUserList();
    UserBean getUserWithOpenid(String openid);
    // 评论获取用户信息
    UserBean getCommentUserByUid(Integer uid);
}
