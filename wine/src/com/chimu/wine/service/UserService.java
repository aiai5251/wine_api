package com.chimu.wine.service;

import com.chimu.wine.bean.UserBean;
import com.chimu.wine.dao.UserDao;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserDao userDao;
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserBean getCommentUserByUid(Integer uid) {
        return userDao.getCommentUserByUid(uid);
    }
}
