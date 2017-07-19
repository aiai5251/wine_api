package com.chimu.wine.service;

import com.chimu.wine.bean.OrderDetailBean;
import com.chimu.wine.dao.OrderDetailDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService {
    private OrderDetailDao orderDetailDao;
    public OrderDetailService(OrderDetailDao orderDetailDao) {
        this.orderDetailDao = orderDetailDao;
    }

    public void addOrderDetail(OrderDetailBean orderDetailBean) {
        orderDetailDao.addOrderDetail(orderDetailBean);
    }

    public List<OrderDetailBean> getOrderDetailByOid(Integer oid) {
        return orderDetailDao.getOrderDetailByOid(oid);
    }
}
