package com.chimu.wine.service;

import com.chimu.wine.bean.OrderBean;
import com.chimu.wine.bean.OrderDetailBean;
import com.chimu.wine.dao.*;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private OrderDao orderDao;
    private OrderDetailDao orderDetailDao;
    private ProductDao productDao;
    private AddressDao addressDao;
    private CouponDao couponDao;
    public OrderService(OrderDao orderDao, OrderDetailDao orderDetailDao, ProductDao productDao, AddressDao addressDao, CouponDao couponDao) {
        this.orderDao = orderDao;
        this.orderDetailDao = orderDetailDao;
        this.productDao = productDao;
        this.addressDao = addressDao;
        this.couponDao = couponDao;
    }

    public void addOrder(OrderBean orderBean) {
        orderDao.addOrder(orderBean);
    }

    public OrderBean getOrderById(Integer id) {
        OrderBean orderBean = orderDao.getOrderById(id);
        // 地址信息
        if (orderBean.getAddress_id() > 0) {
            orderBean.setAddressInfo(addressDao.getAddressById(orderBean.getAddress_id()));
        }
        // 优惠券信息
        if (orderBean.getCoupon_id() > 0) {
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
        orderDao.modifyOrder(orderBean);
    }
}
