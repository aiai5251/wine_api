package com.chimu.wine.dao;

import com.chimu.wine.bean.BannerBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BannerDao {
    List<BannerBean> getBannerList();

//  通过id，查找当前的banner数据
    BannerBean getBannerWithId(@Param("id")Integer id);

//  添加一个banner
    int addBanner(BannerBean bannerBean);

//  修改一个banner
    BannerBean modifyBanner(BannerBean bannerBean);
}
