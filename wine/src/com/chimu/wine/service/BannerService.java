package com.chimu.wine.service;

import com.chimu.wine.bean.BannerBean;
import com.chimu.wine.dao.BannerDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerService {
    private BannerDao bannerDao;

    public BannerService(BannerDao bannerDao) {
        this.bannerDao = bannerDao;
    }

//    @Autowired()
//    public void setBannerDao(BannerDao bannerDao) {
//        this.bannerDao = bannerDao;
//    }

    public int add(BannerBean bannerBean){
        return bannerDao.addBanner(bannerBean);
    }

    public List<BannerBean> getBannerList() {
        return bannerDao.getBannerList();
    }

    public BannerBean getBannerWithId(Integer id) {
        return bannerDao.getBannerWithId(id);
    }
}
