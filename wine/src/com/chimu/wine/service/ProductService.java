package com.chimu.wine.service;

import com.chimu.wine.bean.ProductBean;
import com.chimu.wine.dao.ProductDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductDao productDao;
    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public List<ProductBean> getProductList() {
        return productDao.getProductList();
    }

    public ProductBean getProductWithId(Integer id) {
        return productDao.getProductWithId(id);
    }

    public void modifyProduct(ProductBean productBean) {
        productDao.modifyProduct(productBean);
    }
}
