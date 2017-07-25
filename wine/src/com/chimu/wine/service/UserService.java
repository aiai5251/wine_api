package com.chimu.wine.service;

import com.chimu.wine.bean.UserBean;
import com.chimu.wine.dao.CouponDao;
import com.chimu.wine.dao.UserDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserDao userDao;
    private CouponDao couponDao;

    public UserService(UserDao userDao, CouponDao couponDao) {
        this.userDao = userDao;
        this.couponDao = couponDao;
    }

    public List<UserBean> getUserList() {
        return userDao.getUserList();
    }

    public UserBean getCommentUserById(Integer id) {
        return userDao.getCommentUserById(id);
    }

    public Integer numberOfCouponByUid(Integer uid) {
        return couponDao.numberOfCouponByUid(uid);
    }
}
