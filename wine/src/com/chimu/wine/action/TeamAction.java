package com.chimu.wine.action;

import com.chimu.utils.BaseAction;
import com.chimu.wine.bean.TeamBean;
import com.chimu.wine.service.TeamService;
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
public class TeamAction extends BaseAction {
    @Autowired()
    private TeamService teamService;

    @RequestMapping(value = "/team")
    @ResponseBody
    public Map<String, Object> teamAction(HttpServletRequest request, HttpServletResponse response) {
        super.configResponse(response);
        Map<String, Object> map = new HashMap<>();
        String fid = request.getParameter("fid");
        List<TeamBean> teamBeans = teamService.getTeamUidByFid(Integer.parseInt(fid));
        map.put("data", teamBeans);
        return super.configResponseMap(map, 1);
    }

}
