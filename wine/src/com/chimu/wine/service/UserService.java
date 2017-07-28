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

    public void modifyUser(UserBean userBean) {
        userDao.modifyUser(userBean);
    }

    public UserBean getUserById(Integer id) {
        UserBean userBean = userDao.getUserById(id);
        // 获取优惠券个数
        userBean.setCoupon_count(couponDao.numberOfCouponByUid(userBean.getId()));
        return userBean;
    }

    public UserBean getUserByTel(String tel) {
        return userDao.getUserByTel(tel);
    }

    public List<UserBean> getUserList() {
        return userDao.getUserList();
    }

    public List<UserBean> getUserWithAdmin() {
        return userDao.getUserWithAdmin();
    }

    public UserBean getCommentUserById(Integer id) {
        return userDao.getCommentUserById(id);
    }

}
