package com.chimu.wine.dao;

import com.chimu.wine.bean.BannerBean;

import java.util.List;

public interface BannerDao {
    List<BannerBean> getBannerList();

    //  通过id，查找当前的banner数据
    BannerBean getBannerWithId(Integer id);

    //  添加一个banner
    void addBanner(BannerBean bannerBean);

    //  修改一个banner
    void modifyBanner(BannerBean bannerBean);

    void deleteBanner(Integer id);
}
