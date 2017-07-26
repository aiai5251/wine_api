package com.chimu.wine.dao;

import com.chimu.wine.bean.OrderBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderDao {
    void addOrder(OrderBean orderBean);
    List<OrderBean> getOrderList();
    OrderBean getOrderById(Integer id);
    List<OrderBean> getOrderByUid(Integer uid);
    // 根据订单状态获取列表
    List<OrderBean> getOrderByUidWithStatus(@Param("uid")Integer uid, @Param("status")Integer status);
    OrderBean getOrderByOrderNum(String order_num);
    void modifyOrder(OrderBean orderBean);
}
