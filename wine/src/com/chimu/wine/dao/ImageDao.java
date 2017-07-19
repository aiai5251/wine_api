package com.chimu.wine.dao;

import com.chimu.wine.bean.ImageBean;
import java.util.List;

public interface ImageDao {
    void addImage(ImageBean imageBean);
    List<String> getImagesByPid(Integer product_id);
    List<String> getImagesByBid(Integer banner_id);
}
