package com.chimu.wine.service;

import com.chimu.utils.tools.FileGlobal;
import com.chimu.wine.bean.ImageBean;
import com.chimu.wine.bean.ProductBean;
import com.chimu.wine.dao.ImageDao;
import com.chimu.wine.dao.ProductDao;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private ProductDao productDao;
    private ImageDao imageDao;
    public ProductService(ProductDao productDao, ImageDao imageDao) {
        this.productDao = productDao;
        this.imageDao = imageDao;
    }

    public int addProduct(ProductBean productBean, List<MultipartFile> files, List<MultipartFile> files1) throws Exception {
        List<ImageBean> imageList = getImageList(files, 0);
        List<ImageBean> desc_imageList = getImageList(files1, 1);
        productBean.setImage(imageList.get(0).getUrl());
        productBean.setDescription_image(desc_imageList.get(0).getUrl());
        int id = productDao.addProduct(productBean);
        System.out.print("dasdasd === " + id);

        for (ImageBean imageBean : imageList) {
            imageBean.setProduct_id(productBean.getId());
            imageDao.addImage(imageBean);
        }

        for (ImageBean imageBean : desc_imageList) {
            imageBean.setProduct_id(productBean.getId());
            imageDao.addImage(imageBean);
        }
        return 1;
    }

    private List<ImageBean> getImageList(List<MultipartFile> files, Integer product_type) throws Exception {
        List<ImageBean> imageList = new ArrayList<>();
        for (MultipartFile file : files) {
            if (file != null && !file.isEmpty()) {
                Thread.sleep(1);
                String url = FileGlobal.AddFile(file);
                ImageBean imageBean = new ImageBean();
                imageBean.setUrl(url);
                imageBean.setProduct_type(product_type);
                imageList.add(imageBean);
            }
        }
        return imageList;
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
