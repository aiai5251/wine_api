package com.chimu.wine.action;

import com.chimu.utils.BaseAction;
import com.chimu.wine.bean.PointBean;
import com.chimu.wine.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by leiliang on 2017/7/22.
 */
@Controller
@RequestMapping(value = "/wine")
public class PointAction extends BaseAction {

    @Autowired
    private PointService pointService;

    @RequestMapping(value = "/getPointDetailList")
    @ResponseBody
    public Map<String, Object> getPointList(HttpServletRequest request, HttpServletResponse response) {
        super.configResponse(response);
        Map<String, Object> map = new HashMap<>();
        Integer uid = Integer.parseInt(request.getParameter("uid"));
        List<PointBean> pointList = pointService.getPointListByUid(uid);
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("pointList", pointList);
        map.put("data", dataMap);
        return super.configResponseMap(map, 1);
    }

}
