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

    public void addPromotion(PromotionBean promotionBean) {
        promotionDao.addPromotion(promotionBean);
    }

    public void modifyPromotionById(PromotionBean promotionBean) {
        promotionDao.modifyPromotionById(promotionBean);
    }

    public PromotionBean getPromotionById(Integer id) {
        return promotionDao.getPromotionById(id);
    }

    public void deletePromotionById(Integer id) {
        promotionDao.deletePromotionById(id);
    }

    public List<PromotionBean> getPromotionList() {
        return promotionDao.getPromotionList();
    }

    public List<PromotionBean> getPromotionListByPid(Integer pid) {
        return promotionDao.getPromotionListByPid(pid);
    }

}
