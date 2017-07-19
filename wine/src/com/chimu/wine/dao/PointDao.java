package com.chimu.wine.dao;

import com.chimu.wine.bean.PointBean;

public interface PointDao {
    PointBean findPointByPid(Integer id);
}
