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
        String imageUrl = FileGlobal.AddFile(file);
        if (CMString.isValid(imageUrl)) {
            bannerBean.setImgurl(imageUrl);
        }
        System.out.print("getUrl == " + bannerBean.getImgurl());
        bannerDao.addBanner(bannerBean);
    }

    public void modifyBanner(BannerBean bannerBean, MultipartFile file) throws Exception {
        if (file != null && !file.isEmpty()) {
            // 先删除原来的图片文件，再添加
            String url = bannerBean.getImgurl().replace(Constant.Host, Constant.SaveImagesLocalPath);
            FileGlobal.RemoveFile(url);
            // 添加
            String imageUrl = FileGlobal.AddFile(file);
            if (CMString.isValid(imageUrl)) {
                bannerBean.setImgurl(imageUrl);
            }
        }
        bannerDao.modifyBanner(bannerBean);
    }

    public List<BannerBean> getBannerList() {
        return bannerDao.getBannerList();
    }

    public BannerBean getBannerWithId(Integer id) {
        return bannerDao.getBannerWithId(id);
    }

    public void deleteBanner(Integer id) {
        bannerDao.deleteBanner(id);
    }
}
