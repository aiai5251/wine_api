package com.chimu.wine.dao;

import com.chimu.wine.bean.PromotionBean;

import java.util.List;

public interface PromotionDao {
    void addPromotion(PromotionBean promotionBean);
    void modifyPromotionById(PromotionBean promotionBean);
    PromotionBean getPromotionById(Integer id);
    void deletePromotionById(Integer id);

    List<PromotionBean> getPromotionList();
    List<PromotionBean> getPromotionListByPid(Integer pid);

}
