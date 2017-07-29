package com.chimu.wine.action;

import com.chimu.utils.BaseAction;
import com.chimu.utils.tools.CMString;
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
    public Map<String, Object> promotionAction(HttpServletRequest request, HttpServletResponse response) {
        super.configResponse(response);
        String id = request.getParameter("id");
        String pid = request.getParameter("pid");
        Map<String, Object> map = new HashMap<>();
        if (CMString.isValid(id)) {
            PromotionBean promotionBean = promotionService.getPromotionById(Integer.parseInt(id));
            map.put("data", promotionBean);
        } else if (CMString.isValid(pid)) {
            List<PromotionBean> promotionBeanList = promotionService.getPromotionListByPid(Integer.parseInt(pid));
            map.put("data", promotionBeanList);
        } else {
            List<PromotionBean> promotionBeanList = promotionService.getPromotionList();
            map.put("data", promotionBeanList);
        }
        return super.configResponseMap(map, 1);
    }

    @RequestMapping(value = "/promotion_add")
    @ResponseBody
    public Map<String, Object> addPromotionAction(HttpServletRequest request, HttpServletResponse response) {
        super.configResponse(response);
        Map<String, Object> map = new HashMap<>();
        String pid = request.getParameter("pid");
        String name = request.getParameter("name");
        String description = request.getParameter("description");

        PromotionBean promotionBean = new PromotionBean();
        promotionBean.setName(name);
        promotionBean.setPid(Integer.parseInt(pid));
        promotionBean.setDescription(description);
        promotionService.addPromotion(promotionBean);

        map.put("data", promotionBean);
        return super.configResponseMap(map, 1);
    }

    @RequestMapping(value = "/promotion_modify")
    @ResponseBody
    public Map<String, Object> modifyPromotionAction(HttpServletRequest request, HttpServletResponse response) {
        super.configResponse(response);
        Map<String, Object> map = new HashMap<>();
        String id = request.getParameter("id");
        String pid = request.getParameter("pid");
        String name = request.getParameter("name");
        String description = request.getParameter("description");

        PromotionBean promotionBean = promotionService.getPromotionById(Integer.parseInt(id));
        if (CMString.isValid(pid))
            promotionBean.setPid(Integer.parseInt(pid));
        if (CMString.isValid(name))
            promotionBean.setName(name);
        if (CMString.isValid(description))
            promotionBean.setDescription(description);

        promotionService.modifyPromotionById(promotionBean);
        map.put("data", promotionBean);
        return super.configResponseMap(map, 1);
    }

    @RequestMapping(value = "/promotion_delete")
    @ResponseBody
    public Map<String, Object> deletePromotionAction(HttpServletRequest request, HttpServletResponse response) {
        super.configResponse(response);
        Map<String, Object> map = new HashMap<>();
        String id = request.getParameter("id");
        promotionService.deletePromotionById(Integer.parseInt(id));
        return super.configResponseMap(map, 1);
    }

}
