package com.chimu.wine.service;

import com.chimu.wine.bean.BannerBean;
import com.chimu.wine.dao.BannerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerService {
    private BannerDao bannerDao;

//    public List<BannerBean> getBannerList() {
////        List<BannerBean> banners = bannerDao.banner_list_select();
////        System.out.print(banners);
////        return banners;
//        return nil;
//    }

    @Autowired()
    public void setBannerDao(BannerDao bannerDao) {
        this.bannerDao = bannerDao;
    }

    public int add(BannerBean bannerBean){
        return bannerDao.add(bannerBean);
    }

    public BannerBean byId(Integer id) {
        return bannerDao.byId(id);
    }
}
