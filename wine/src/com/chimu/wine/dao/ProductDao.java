package com.chimu.wine.dao;

import com.chimu.wine.bean.ProductBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductDao {
    int addProduct(ProductBean productBean);

    List<ProductBean> getProductList();

    // 通过id，查找当前的banner数据
    ProductBean getProductWithId(@Param("id") Integer id);

    void modifyProduct(ProductBean productBean);
}
