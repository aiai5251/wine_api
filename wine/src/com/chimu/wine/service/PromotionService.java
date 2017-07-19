package com.chimu.wine.service;

import com.chimu.wine.bean.PromotionBean;
import com.chimu.wine.dao.PromotionDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionService {
    private PromotionDao promotionDao;
    public PromotionService(PromotionDao promotionDao) {
        this.promotionDao = promotionDao;
    }

    public List<PromotionBean> getPromotionList(Integer pid) {
        return promotionDao.getPromotionList(pid);
    }

}
