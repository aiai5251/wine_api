package com.chimu.wine.service;

import com.chimu.utils.tools.CMString;
import com.chimu.wine.bean.*;
import com.chimu.wine.dao.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {
    private OrderDao orderDao;
    private OrderDetailDao orderDetailDao;
    private ProductDao productDao;
    private AddressDao addressDao;
    private CouponDao couponDao;
    private PointDao pointDao;
    private UserDao userDao;

    public OrderService(OrderDao orderDao, OrderDetailDao orderDetailDao, ProductDao productDao, AddressDao addressDao, CouponDao couponDao, PointDao pointDao, UserDao userDao) {
        this.orderDao = orderDao;
        this.orderDetailDao = orderDetailDao;
        this.productDao = productDao;
        this.addressDao = addressDao;
        this.couponDao = couponDao;
        this.pointDao = pointDao;
        this.userDao = userDao;
    }

    public void addOrder(OrderBean orderBean) {
        orderDao.addOrder(orderBean);
    }

    public List<OrderBean> getOrderList() {
        List<OrderBean> orderList = orderDao.getOrderList();
        List<OrderBean> orderNewList = new ArrayList<>();
        for (OrderBean orderBean : orderList) {
            orderNewList.add(getOrderDetail(orderBean));
        }
        return orderNewList;
    }

    public OrderBean getOrderById(Integer id) {
        OrderBean orderBean = orderDao.getOrderById(id);
        return getOrderDetail(orderBean);
    }

    public List<OrderBean> getOrderByUid(Integer uid) {
        List<OrderBean> orderList = orderDao.getOrderByUid(uid);
        List<OrderBean> orderNewList = new ArrayList<>();
        for (OrderBean orderBean : orderList) {
            orderNewList.add(getOrderDetail(orderBean));
        }
        return orderNewList;
    }

    public List<OrderBean> getOrderByUidWithStatus(Integer uid, Integer status) {
        List<OrderBean> orderList = orderDao.getOrderByUidWithStatus(uid, status);
        List<OrderBean> orderNewList = new ArrayList<>();
        for (OrderBean orderBean : orderList) {
            orderNewList.add(getOrderDetail(orderBean));
        }
        return orderNewList;
    }

    public OrderBean getOrderByOrderNum(String order_num) {
        OrderBean orderBean = orderDao.getOrderByOrderNum(order_num);
        return getOrderDetail(orderBean);
    }

    private OrderBean getOrderDetail(OrderBean orderBean) {
        // 地址信息
        if (orderBean.getAddress_id() == 0) {
            orderBean.setAddressInfo(addressDao.getAddressSelectedByUid(orderBean.getUid()));
        } else {
            orderBean.setAddressInfo(addressDao.getAddressById(orderBean.getAddress_id()));
        }

        // 优惠券信息
        if (CMString.isValidInt(orderBean.getCoupon_id())) {
            orderBean.setCouponInfo(couponDao.getCouponById(orderBean.getCoupon_id()));
        }
        // 订单详情信息
        orderBean.setOrderDetails(orderDetailDao.getOrderDetailByOid(orderBean.getId()));
        // 订单详情中的商品信息
        for (OrderDetailBean orderDetailBean : orderBean.getOrderDetails()) {
            orderDetailBean.setProductInfo(productDao.getProductWithId(orderDetailBean.getPid()));
        }
        return orderBean;
    }

    public void modifyOrder(OrderBean orderBean) {
        // 订单完成
        if (orderBean.getStatus() == 1) {
            // 先送积分,根据订单总额来送
            addPointWithModifyUser(orderBean, (int)Math.round((orderBean.getAmount() / 100.0)), true);
            // 该订单使用了积分
            if (orderBean.getPoint() > 0) {
                addPointWithModifyUser(orderBean, orderBean.getPoint(), false);
            }
            // 使用了优惠券
            if (orderBean.getCoupon_id() > 0) {
                CouponBean couponBean = couponDao.getCouponById(orderBean.getCoupon_id());
                couponBean.setStatus(1);
                couponDao.modifyCouponById(couponBean);
            }
        }
        orderDao.modifyOrder(orderBean);
    }

    private void addPointWithModifyUser(OrderBean orderBean, Integer point, boolean point_add) {
        // 积分增加减少，纪录信息，用户积分变化
        PointBean pointBean = new PointBean();
        pointBean.setCreate_time(new Date());
        pointBean.setUid(orderBean.getUid());
        UserBean userBean = userDao.getUserById(orderBean.getUid());
        if (point_add) {
            pointBean.setPoint(point);
            pointBean.setDescription("购买送积分");
            pointBean.setType(0);
            userBean.setPoint(userBean.getPoint() + point);
        } else {
            pointBean.setPoint(point);
            pointBean.setDescription("消费使用积分");
            pointBean.setType(1);
            userBean.setPoint(userBean.getPoint() - point);
        }
        pointDao.addPoint(pointBean);
        userDao.modifyUser(userBean);
    }
}
