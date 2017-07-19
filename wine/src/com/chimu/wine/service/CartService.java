package com.chimu.wine.service;

import com.chimu.wine.bean.CartBean;
import com.chimu.wine.dao.CartDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    private CartDao cartDao;
    public CartService(CartDao cartDao) {
        this.cartDao = cartDao;
    }

    public void addCart(CartBean cartBean) {
        cartDao.addCart(cartBean);
    }

    public CartBean getCartByPidWithUid(Integer pid, Integer uid) {
        return cartDao.getCartByPidWithUid(pid, uid);
    }

    public void modifyCartById(Integer id, Integer count) {
        cartDao.modifyCartById(id, count);
    }

    public List<CartBean> getCartByUid(Integer uid) {
        return cartDao.getCartByUid(uid);
    }

    public void deleteCartByPidWithUid(Integer pid, Integer uid) {
        cartDao.deleteCartByPidWithUid(pid, uid);
    }
}
