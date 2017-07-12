package com.chimu.wine.action;

import com.chimu.utils.BaseAction;
import com.chimu.wine.bean.BannerBean;
import com.chimu.wine.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/wine")
public class BannerAction extends BaseAction {

    @Autowired()
    private BannerService bannerService;

    @RequestMapping(value = "/banner")
    @ResponseBody
    protected Map<String, Object> showBannerList(HttpServletResponse response) {
        super.configResponse(response);
        Map<String, Object> map = new HashMap<>();
        List<BannerBean> bannerList = bannerService.getBannerList();
        map.put("banners", bannerList);
        if (bannerList != null) {
            return super.configResponseMap(map, 1);
        }
        return super.configResponseMap(map, 0);
    }

    @RequestMapping(value = "/banner_add")
    @ResponseBody
    protected  Map<String, Object> bannerAdd(HttpServletRequest request, HttpServletResponse response) {
        super.configResponse(response);
        Map<String, Object> map = new HashMap<>();
        String bannerImageUrl = request.getParameter("url");
        String bannerTitle = request.getParameter("title");
        String bannerUrl = request.getParameter("url");

        BannerBean bannerBean = new BannerBean();
        bannerBean.setImgurl(bannerImageUrl);
        bannerBean.setUrl(bannerUrl);
        bannerBean.setTitle(bannerTitle);
        Integer iid = bannerService.add(bannerBean);
        System.out.print(iid);

        map.put("banner", bannerBean);
        map.put("status", 1);
        map.put("infoMsg", "获取成功");
        return map;
    }

    @RequestMapping(value = "/banner_modify")
    @ResponseBody
    protected  Map<String, Object> bannerModify(HttpServletRequest request, HttpServletResponse response) {
        super.configResponse(response);
        Map<String, Object> map = new HashMap<>();
        return super.configResponseMap(map, 1);
    }
}


