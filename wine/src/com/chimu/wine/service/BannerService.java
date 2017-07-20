package com.chimu.wine.service;

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
        String imageUrl = FileGlobal.AddFile(file);
        if (CMString.isValid(imageUrl)) {
            bannerBean.setImgurl(imageUrl);
        }
        System.out.print("getUrl == " + bannerBean.getImgurl());
        bannerDao.addBanner(bannerBean);
    }

    public void modifyBanner(BannerBean bannerBean, MultipartFile file) {
//        url = image.getUrl().replaceAll(remote, local);
//        FileGlobal.RemoveFile(url);
        bannerDao.modifyBanner(bannerBean);
    }

    public List<BannerBean> getBannerList() {
        return bannerDao.getBannerList();
    }

    public BannerBean getBannerWithId(Integer id) {
        return bannerDao.getBannerWithId(id);
    }
}
