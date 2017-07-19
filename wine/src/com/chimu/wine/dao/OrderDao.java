package com.chimu.wine.dao;

import com.chimu.wine.bean.OrderBean;

public interface OrderDao {
    void addOrder(OrderBean orderBean);
    OrderBean getOrderById(Integer id);
    void modifyOrder(OrderBean orderBean);
}
