package com.chimu.wine.service;

import com.chimu.wine.bean.UserBean;
import com.chimu.wine.dao.UserDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserDao userDao;
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void addUser(UserBean userBean) {
        userDao.addUser(userBean);
    }

    public List<UserBean> getUserList() {
        return userDao.getUserList();
    }

    public UserBean getUserWithOpenid(String openid) {
        return userDao.getUserWithOpenid(openid);
    }

    public UserBean getCommentUserByUid(Integer uid) {
        return userDao.getCommentUserByUid(uid);
    }
}
