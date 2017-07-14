package com.chimu.wine.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductDao {

    List<ProductBean>getProductList();

    //  通过id，查找当前的banner数据
    ProductBean getBannerWithId(@Param("id")Integer id);

}
