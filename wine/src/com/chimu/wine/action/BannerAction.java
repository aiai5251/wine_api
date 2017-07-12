package com.chimu.wine.action;

import com.chimu.wine.bean.BannerBean;
import com.chimu.wine.dao.BannerDao;
import com.chimu.wine.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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


//    private BannerService bannerService;
    @Autowired(required = false)
    private BannerDao bannerDao;

    @RequestMapping(value = "/banner")
    @ResponseBody
    protected Map<String, Object> Action(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
        super.configResponse(response);
        Map<String, Object> map = new HashMap<>();

//        List<BannerBean> bannerList = bannerDao.banner_list_select();
//        System.out.print(bannerList);
        map.put("banners", "121");
        return map;
    }

    @RequestMapping(value = "/banner_add")
    @ResponseBody
    protected  Map<String, Object> bannerAdd(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
        super.configResponse(response);
        Map<String, Object> map = new HashMap<>();
        String bannerId = request.getParameter("id");
        System.out.print(bannerId);
        map.put("id", bannerId);
        return map;
    }
}
