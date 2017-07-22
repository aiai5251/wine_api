package com.chimu.wine.dao;

import com.chimu.wine.bean.OrderBean;

import java.util.List;

public interface OrderDao {
    void addOrder(OrderBean orderBean);
    List<OrderBean> getOrderList();
    OrderBean getOrderById(Integer id);
    List<OrderBean> getOrderByUid(Integer uid);
    OrderBean getOrderByOrderNum(String order_num);
    void modifyOrder(OrderBean orderBean);
}
