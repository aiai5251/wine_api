package com.chimu.wine.dao;

import com.chimu.wine.bean.PointBean;

import java.util.List;

public interface PointDao {
    List<PointBean> getPointListByUid(Integer uid);
    Integer addPoint(PointBean bean);
}
