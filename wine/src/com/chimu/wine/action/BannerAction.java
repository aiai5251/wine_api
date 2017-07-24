package com.chimu.wine.action;

import com.chimu.utils.BaseAction;
import com.chimu.wine.bean.BannerBean;
import com.chimu.wine.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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
    public Map<String, Object> showBannerList(HttpServletResponse response) {
        super.configResponse(response);
        Map<String, Object> map = new HashMap<>();
        List<BannerBean> bannerList = bannerService.getBannerList();
        map.put("data", bannerList);
        if (bannerList != null) {
            return super.configResponseMap(map, 1);
        }
        return super.configResponseMap(map, 0);
    }

    @RequestMapping(value = "/banner_add")
    @ResponseBody
    public Map<String, Object> bannerAdd(HttpServletRequest request, HttpServletResponse response) throws Exception {
        super.configResponse(response);
        Map<String, Object> map = new HashMap<>();
        String bannerTitle = request.getParameter("title");
        String bannerUrl = request.getParameter("url");

        MultipartFile file = null;
        try {
            file = ((MultipartHttpServletRequest)request).getFile("file");
        } catch(Exception ignored) {}

        if (file != null && !file.isEmpty()) {
            BannerBean bannerBean = new BannerBean();
            bannerBean.setTitle(bannerTitle);
            bannerBean.setUrl(bannerUrl);
            bannerService.add(bannerBean, file);
            map.put("data", bannerBean);
            return super.configResponseMap(map, 1);
        }
        return super.configResponseMap(map,0);
    }

    @RequestMapping(value = "/banner_modify")
    @ResponseBody
    public Map<String, Object> bannerModify(HttpServletRequest request, HttpServletResponse response) throws Exception {
        super.configResponse(response);
        String id = request.getParameter("id");
        String bannerTitle = request.getParameter("title");
        String bannerUrl = request.getParameter("url");

        Map<String, Object> map = new HashMap<>();
        BannerBean bannerBean = bannerService.getBannerWithId(Integer.parseInt(id));
        bannerBean.setTitle(bannerTitle);
        bannerBean.setUrl(bannerUrl);
        MultipartFile file = null;
        try {
            file = ((MultipartHttpServletRequest)request).getFile("file");
        } catch(Exception ignored) {}
        if (file != null && !file.isEmpty()) {
            bannerService.modifyBanner(bannerBean, file);
            map.put("data", bannerBean);
            return super.configResponseMap(map, 1);
        }
        return super.configResponseMap(map, 0);
    }

    @RequestMapping(value = "/banner_delete")
    @ResponseBody
    public Map<String, Object> deleteBannerAction(HttpServletRequest request, HttpServletResponse response) {
        super.configResponse(response);
        Map<String, Object> map = new HashMap<>();
        String id = request.getParameter("id");
        bannerService.deleteBanner(Integer.parseInt(id));
        return super.configResponseMap(map, 1);
    }
}


