package com.chimu.wine.service;

import com.chimu.utils.Constant;
import com.chimu.utils.tools.CMString;
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
        List<ImageBean> imageList = getImageList(new ArrayList<ImageBean>(), files, null, 0);
        List<ImageBean> desc_imageList = getImageList(new ArrayList<ImageBean>(), files1,  null, 1);
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
        if (files != null && files1 != null) {
            // image数据库中删除原来的图片，删除本地文件
            List<ImageBean> imageList = getImageList(productBean.getImages(), files, productBean.getId(), 0);
            List<ImageBean> desc_imageList = getImageList(productBean.getDesc_images(), files1, productBean.getId(), 1);

            if (imageList.size() > 0) {
                productBean.setImage(imageList.get(0).getUrl());
            }

            if (desc_imageList.size() > 0) {
                productBean.setDescription_image(desc_imageList.get(0).getUrl());
            }
        }
        productDao.modifyProduct(productBean);
    }

    private List<ImageBean> getImageList(List<ImageBean> images, List<MultipartFile> files, Integer id, Integer product_type) throws Exception {
        ImageBean imageBean;
        // 有删除图片
        if (images.size() > files.size()) {
            for(int i = images.size() - 1; i > files.size() - 1; i--) {
                imageDao.deleteImageById(images.get(i).getId());
                images.remove(i);
            }
        }

        for(int i = 0; i < files.size(); i++){
            MultipartFile file = files.get(i);
            if(file != null && !file.isEmpty()){
                if(images.size() > i){
                    imageBean = images.get(i);
                    // remove
                    String url = imageBean.getUrl().replace(Constant.Host, Constant.SaveImagesLocalPath);
                    FileGlobal.RemoveFile(url);
                    // add
                    url = FileGlobal.AddFile(file);
                    imageBean.setUrl(url);
                    imageDao.modifyImageById(imageBean);
                } else {
                    String url = FileGlobal.AddFile(file);
                    imageBean = new ImageBean();
                    imageBean.setUrl(url);
                    if (CMString.isValidInt(id)) {
                        imageBean.setProduct_id(id);
                    }
                    imageBean.setProduct_type(product_type);
                    imageBean.setBanner_id(0);
                    imageBean.setComment_id(0);
                    images.add(imageBean);
                    imageDao.addImage(imageBean);
                }
            }
        }
        return images;
    }

    public List<ProductBean> getProductList() {
        return productDao.getProductList();
    }

    public ProductBean getProductWithId(Integer id) {
        ProductBean productBean = productDao.getProductWithId(id);
        productBean.setImages(imageDao.getImagesByPid(productBean.getId(), 0));
        productBean.setDesc_images(imageDao.getImagesByPid(productBean.getId(), 1));
        return productBean;
    }

}
