package com.chimu.wine.dao;

import com.chimu.wine.bean.BannerBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BannerDao {
    List<BannerBean> banner_list_select();

//    通过id，查找当前的banner数据
    BannerBean byId(@Param("id")Integer id);

//    添加一个banner
    int add(BannerBean bannerBean);
}
