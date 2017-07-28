package com.chimu.wine.dao;

import com.chimu.wine.bean.PromotionBean;

import java.util.List;

public interface PromotionDao {
    void addPromotion(PromotionBean promotionBean);
    void modifyPromotion(PromotionBean promotionBean);
    PromotionBean getPromotionById(Integer id);
    void deletePromotionById(Integer id);

    List<PromotionBean> getPromotionList(Integer pid);
}
