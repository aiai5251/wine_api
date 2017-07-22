package com.chimu.wine.service;

import com.chimu.utils.tools.CMString;
import com.chimu.wine.bean.OrderBean;
import com.chimu.wine.bean.OrderDetailBean;
import com.chimu.wine.dao.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public OrderBean getOrderByOrderNum(String order_num) {
        OrderBean orderBean = orderDao.getOrderByOrderNum(order_num);
        return getOrderDetail(orderBean);
    }

    private OrderBean getOrderDetail(OrderBean orderBean) {
        // 地址信息
        if (CMString.isValidInt(orderBean.getAddress_id())) {
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
        orderDao.modifyOrder(orderBean);
    }
}
