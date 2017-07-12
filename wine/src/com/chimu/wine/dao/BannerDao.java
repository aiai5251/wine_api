package com.chimu.wine.dao;

import com.chimu.wine.bean.BannerBean;

import java.util.List;

public interface BannerDao {
    List<BannerBean> banner_list_select();
}
