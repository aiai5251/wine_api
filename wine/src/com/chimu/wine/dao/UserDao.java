package com.chimu.wine.dao;

import com.chimu.wine.bean.UserBean;

import java.util.List;

public interface UserDao {
    void addUser(UserBean userBean);
    void modifyUser(UserBean userBean);
    UserBean getUserById(Integer id);

    UserBean getUserByTel(String tel);

    // 根据微信id搜索用户
    UserBean getUserWithOpenid(String openid);

    // 评论获取用户信息
    UserBean getCommentUserById(Integer id);

    // 后台管理系统展示
    List<UserBean> getUserList();
}
