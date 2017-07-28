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
        // 先添加
        productDao.addProduct(productBean);
        // 获取id
        List<ImageBean> imageList = addImages(files, productBean.getId(), 0);
        List<ImageBean> desc_imageList = addImages(files1, productBean.getId(), 1);
        ProductBean productBean1 = productDao.getProductWithId(productBean.getId());
        productBean1.setImage(imageList.get(0).getUrl());
        productBean1.setDescription_image(desc_imageList.get(0).getUrl());
        productDao.modifyProduct(productBean1);
    }

    // 添加图片方法
    private List<ImageBean> addImages(List<MultipartFile> files, Integer id, Integer product_type) throws Exception {
        List<ImageBean> bannerImages = new ArrayList<>();
        for (MultipartFile file : files) {
            if (file != null && !file.isEmpty()) {
                ImageBean imageBean = createImageBean(file, id, product_type);
                bannerImages.add(imageBean);
                imageDao.addImage(imageBean);
            }
        }
        return bannerImages;
    }

    public void modifyProduct(ProductBean productBean, List<MultipartFile> files, List<MultipartFile> files1) throws Exception {
        if (files != null && files1 != null) {
            // image数据库中删除原来的图片，删除本地文件
            List<ImageBean> imageList = modifyImages(productBean, files, 0);
            List<ImageBean> desc_imageList = modifyImages(productBean, files1, 1);

            if (imageList.size() > 0) {
                productBean.setImage(imageList.get(0).getUrl());
            }

            if (desc_imageList.size() > 0) {
                productBean.setDescription_image(desc_imageList.get(0).getUrl());
            }
        }
        productDao.modifyProduct(productBean);
    }

    private List<ImageBean> modifyImages(ProductBean productBean, List<MultipartFile> files, Integer product_type) throws Exception {
        List<ImageBean> imageList;
        if (product_type == 0) { //修改轮播图
            imageList = productBean.getImages();
        } else { // 修改详情图
            imageList = productBean.getDesc_images();
        }

        // 原来的图片数组 大于传入的数组，需要删除原来数组中最后几张图片
        if (imageList.size() > files.size()) {
            for(int i = imageList.size() - 1; i > files.size() - 1; i--) {
                String[] rows = imageList.get(i).getUrl().split("=");
                System.out.print("rows == " + rows[1]);
                if (rows.length == 2) {
                    String url = Constant.SaveImagesLocalPath + rows[1];
                    System.out.print("removeUrl == " + url);
                    FileGlobal.RemoveFile(url);
                }

                imageDao.deleteImageById(imageList.get(i).getId());
                imageList.remove(i);
            }
        }
        // 更改前几张图片
        for (int i = 0; i < files.size(); i++) {
            MultipartFile file = files.get(i);
            // 不为空，需要更改
            if (file != null && !file.isEmpty()) {
                // 传入的数组大于已有的数组，前几项是更新，后几项是添加
                if (imageList.size() > i) {
                    ImageBean imageBean = imageList.get(i);
                    // remove
                    String[] rows = imageBean.getUrl().split("=");
                    if (rows.length == 2) {
                        String url = Constant.SaveImagesLocalPath + rows[1];
                        System.out.print("removeUrl == " + url);
                        FileGlobal.RemoveFile(url);
                        // add
                        Thread.sleep(1);
                        url = FileGlobal.AddFile(file);
                        imageBean.setUrl(url);
                        imageDao.modifyImageById(imageBean);
                    }
                } else {
                    ImageBean imageBean = createImageBean(file, productBean.getId(), product_type);
                    imageList.add(imageBean);
                    imageDao.addImage(imageBean);
                }
            }
        }
        return imageList;
    }

    // 创建ImageBean
    private ImageBean createImageBean(MultipartFile file, Integer id, Integer product_type) throws Exception {
        Thread.sleep(1);
        String url = FileGlobal.AddFile(file);
        ImageBean imageBean = new ImageBean();
        imageBean.setUrl(url);
        imageBean.setProduct_id(id);
        imageBean.setProduct_type(product_type);
        imageBean.setBanner_id(0);
        imageBean.setComment_id(0);
        return imageBean;
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
