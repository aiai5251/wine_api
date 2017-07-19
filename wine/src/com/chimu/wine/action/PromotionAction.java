package com.chimu.wine.action;

import com.chimu.utils.BaseAction;
import com.chimu.wine.bean.PromotionBean;
import com.chimu.wine.service.PromotionService;
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
public class PromotionAction extends BaseAction {
    @Autowired()
    private PromotionService promotionService;

    @RequestMapping(value = "/promotion")
    @ResponseBody
    public Map<String, Object> productDetail(HttpServletRequest request, HttpServletResponse response) {
        super.configResponse(response);
        String pid = request.getParameter("id");
        Map<String, Object> map = new HashMap<>();
        List<PromotionBean> promotionBeanList = promotionService.getPromotionList(Integer.parseInt(pid));
        map.put("data", promotionBeanList);
        return super.configResponseMap(map, 1);
    }

}
