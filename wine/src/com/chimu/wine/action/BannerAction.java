package com.chimu.wine.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by yaorong on 2017/7/10.
 */

@Controller
@RequestMapping(value = "/")
public class BannerAction extends BaseAction {

    @RequestMapping(value = "/banner")
    public String Init(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception{
        return super.Init(request, response, model);
    }

    protected String Action(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
        response.getWriter().print(String.format("{\"head\":0,\"body\":{\"error\":\"%s\"}}", "mid is null"));
        return null;
    }

}
