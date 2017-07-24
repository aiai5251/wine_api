package com.chimu.wine.dao;

import com.chimu.wine.bean.ImageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ImageDao {
    void addImage(ImageBean imageBean);
    List<ImageBean> getImagesByPid(@Param("product_id")Integer product_id, @Param("product_type")Integer product_type);
    void deleteImageByPid(Integer product_id);
    List<ImageBean> getImagesByBid(Integer banner_id);
    void deleteImageByBid(Integer banner_id);
    void deleteImageById(Integer id);
    void modifyImageById(ImageBean imageBean);
}
