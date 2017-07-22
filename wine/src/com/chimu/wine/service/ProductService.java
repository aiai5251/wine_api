package com.chimu.wine.service;

import com.chimu.utils.Constant;
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

    public void addProduct(ProductBean productBean, List<MultipartFile> files, List<MultipartFile> files1) throws Exception {
        List<ImageBean> imageList = getImageList(files, 0);
        List<ImageBean> desc_imageList = getImageList(files1, 1);
        productBean.setImage(imageList.get(0).getUrl());
        productBean.setDescription_image(desc_imageList.get(0).getUrl());
        productDao.addProduct(productBean);

        //        图片添加到image数据库中
        for (ImageBean imageBean : imageList) {
            imageBean.setProduct_id(productBean.getId());
            imageDao.addImage(imageBean);
        }

        for (ImageBean imageBean : desc_imageList) {
            imageBean.setProduct_id(productBean.getId());
            imageDao.addImage(imageBean);
        }
    }

    public void modifyProduct(ProductBean productBean, List<MultipartFile> files, List<MultipartFile> files1) throws Exception {
        // image数据库中删除原来的图片，删除本地文件
        imageDao.deleteImageByPid(productBean.getId());
        deleteFile(productBean);
        List<ImageBean> imageList = getImageList(files, 0);
        List<ImageBean> desc_imageList = getImageList(files1, 1);
        productBean.setImage(imageList.get(0).getUrl());
        productBean.setDescription_image(desc_imageList.get(0).getUrl());
        productDao.modifyProduct(productBean);

        //        图片添加到image数据库中
        for (ImageBean imageBean : imageList) {
            imageBean.setProduct_id(productBean.getId());
            imageDao.addImage(imageBean);
        }

        for (ImageBean imageBean : desc_imageList) {
            imageBean.setProduct_id(productBean.getId());
            imageDao.addImage(imageBean);
        }
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

    private void deleteFile(ProductBean productBean) throws Exception {
        String url;
        for (int i = 0; i < productBean.getImages().size(); i++) {
            url = productBean.getImages().get(i).replace(Constant.Host, Constant.SaveImagesLocalPath);
            FileGlobal.RemoveFile(url);
        }
        for (int i = 0; i < productBean.getDesc_images().size(); i++) {
            url = productBean.getDesc_images().get(i).replace(Constant.Host, Constant.SaveImagesLocalPath);
            FileGlobal.RemoveFile(url);
        }
    }

    public List<ProductBean> getProductList() {
        return productDao.getProductList();
    }

    public ProductBean getProductWithId(Integer id) {
        ProductBean productBean = productDao.getProductWithId(id);
        productBean.setImages(imageDao.getImagesByPid(id, 0));
        productBean.setDesc_images(imageDao.getImagesByPid(id, 1));
        return productBean;
    }

}
