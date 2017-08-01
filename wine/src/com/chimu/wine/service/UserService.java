package com.chimu.wine.service;

import com.chimu.wine.bean.PointBean;
import com.chimu.wine.bean.UserBean;
import com.chimu.wine.dao.MyCouponDao;
import com.chimu.wine.dao.PointDao;
import com.chimu.wine.dao.UserDao;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService {
    private UserDao userDao;
    private MyCouponDao myCouponDao;
    private PointDao pointDao;

    public UserService(UserDao userDao, MyCouponDao myCouponDao, PointDao pointDao) {
        this.userDao = userDao;
        this.myCouponDao = myCouponDao;
        this.pointDao = pointDao;
    }

    public void addUser(UserBean userBean) {
        userDao.addUser(userBean);

        if (userBean.getPoint() > 0) { // 新用户是扫码推荐进来的
            PointBean pointBean = new PointBean();
            pointBean.setCreate_time(new Date());
            pointBean.setUid(userBean.getId());
            pointBean.setPoint(userBean.getPoint());
            pointBean.setDescription("推荐成功得积分");
            pointBean.setType(0);
            pointDao.addPoint(pointBean);
        }

    }

    public void modifyUser(UserBean userBean) {
        userDao.modifyUser(userBean);
    }

    public UserBean getUserById(Integer id) {
        UserBean userBean = userDao.getUserById(id);
        // 获取优惠券个数
        userBean.setCoupon_count(myCouponDao.numberOfCouponByUid(userBean.getId()));
        return userBean;
    }

    public UserBean getUserByTel(String tel) {
        return userDao.getUserByTel(tel);
    }

    public List<UserBean> getUserList() {
        return userDao.getUserList();
    }

    public UserBean getUserWithOpenid(String openid) {
        return userDao.getUserWithOpenid(openid);
    }

    public UserBean getCommentUserById(Integer id) {
        return userDao.getCommentUserById(id);
    }

}
