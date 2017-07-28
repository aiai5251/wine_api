package com.chimu.wine.dao;

import com.chimu.wine.bean.ImageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ImageDao {
    void addImage(ImageBean imageBean);
    List<ImageBean> getImagesByPid(@Param("product_id")Integer product_id, @Param("product_type")Integer product_type);

    void deleteImageById(Integer id);
    void modifyImageById(ImageBean imageBean);

    List<ImageBean> getImagesByCid(Integer comment_id);
}
