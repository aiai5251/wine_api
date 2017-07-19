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
        String imageUrl = FileGlobal.AddFile(file, "http://localhost:9090",
                "/Users/didi/Desktop/wineProject/wine_api/wine/WebRoot/WEB-INF/image");
        if (CMString.isValid(imageUrl)) {
            bannerBean.setImgurl(imageUrl);
        }
        bannerDao.addBanner(bannerBean);

//        String url;
//        ImageBean imageBean;
//        MultipartFile file;
//        List<ImageBean> images = new ArrayList<>();
//        if (files != null && files.size() > 0) {
//            for (int i = 0; i < files.size(); i++) {
//                file = files.get(i);
//                if (file != null && !file.isEmpty()) {
//                    Thread.sleep(1);
//                    url = FileGlobal.AddFile(file, "http://localhost:9090", "banner");
//                    imageBean = new ImageBean();
//                    imageBean.setUrl(url);
//                    imageBean.setBanner_id(bannerBean.getId());
//                    imageDao.addImage(imageBean);
//                    images.add(imageBean);
//                }
//            }
//        }


    }

    public List<BannerBean> getBannerList() {
        return bannerDao.getBannerList();
    }

    public BannerBean getBannerWithId(Integer id) {
        return bannerDao.getBannerWithId(id);
    }
}
