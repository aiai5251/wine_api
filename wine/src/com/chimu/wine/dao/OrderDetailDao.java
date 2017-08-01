package com.chimu.wine.dao;

import com.chimu.wine.bean.OrderDetailBean;

import java.util.List;

public interface OrderDetailDao {
    void addOrderDetail(OrderDetailBean orderDetailBean);
    List<OrderDetailBean> getOrderDetailByOid(Integer oid);
}
