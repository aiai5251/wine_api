package com.chimu.wine.dao;

import com.chimu.wine.bean.ImageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ImageDao {
    void addImage(ImageBean imageBean);
    List<String> getImagesByPid(@Param("product_id")Integer product_id, @Param("product_type")Integer product_type);
    void deleteImageByPid(Integer product_id);
    List<String> getImagesByBid(Integer banner_id);
    void deleteImageByBid(Integer banner_id);
}
