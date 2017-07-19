package com.chimu.wine.service;

import com.chimu.wine.bean.PointBean;
import com.chimu.wine.dao.PointDao;
import org.springframework.stereotype.Service;

@Service
public class PointService {
    private PointDao pointDao;
    public PointService(PointDao pointDao) {
        this.pointDao = pointDao;
    }

    public PointBean findPointByPid(Integer id) {
        return pointDao.findPointByPid(id);
    }
}
