package com.chimu.wine.dao;

import com.chimu.wine.bean.PromotionBean;

import java.util.List;

public interface PromotionDao {
    List<PromotionBean> getPromotionList(Integer pid);
}
