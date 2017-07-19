package com.chimu.wine.service;

import com.chimu.utils.Constant;
import com.chimu.utils.tools.CMString;
import com.chimu.utils.tools.FileGlobal;
import com.chimu.wine.bean.BannerBean;
import com.chimu.wine.dao.BannerDao;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@Service
public class BannerService {
    private BannerDao bannerDao;
    public BannerService(BannerDao bannerDao) {
        this.bannerDao = bannerDao;
    }

    public void add(BannerBean bannerBean, MultipartFile file) throws Exception {
        String imageUrl = FileGlobal.AddFile(file, Constant.Host,
                Constant.SaveImagesLocalPath);
        if (CMString.isValid(imageUrl)) {
            bannerBean.setImgurl(imageUrl);
        }
        bannerDao.addBanner(bannerBean);
    }

    public List<BannerBean> getBannerList() {
        return bannerDao.getBannerList();
    }

    public BannerBean getBannerWithId(Integer id) {
        return bannerDao.getBannerWithId(id);
    }
}
