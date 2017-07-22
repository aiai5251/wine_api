package com.chimu.wine.service;

import com.chimu.wine.bean.PointBean;
import com.chimu.wine.dao.PointDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointService {
    private PointDao pointDao;
    public PointService(PointDao pointDao) {
        this.pointDao = pointDao;
    }

    public List<PointBean> getPointListByUid(Integer uid) {
        return pointDao.getPointListByUid(uid);
    }

    public Integer addPoint(PointBean bean) {
        return pointDao.addPoint(bean);
    }
}
