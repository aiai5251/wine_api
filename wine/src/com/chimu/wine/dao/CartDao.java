package com.chimu.wine.dao;

import com.chimu.wine.bean.CartBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartDao {
    void addCart(CartBean cartBean);
//    多个参数需要添加 @Param("id")
    CartBean getCartByPidWithUid(@Param("pid")Integer pid, @Param("uid")Integer uid);
    void modifyCartById(CartBean cartBean);
    List<CartBean> getCartByUid(Integer uid);
    void deleteCartById(Integer id);
}
