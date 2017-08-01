package com.chimu.wine.action;

import com.chimu.utils.BaseAction;
import com.chimu.wine.service.WechatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/wine")
public class MyQrcodeAction extends BaseAction {
    @Autowired()
    private WechatService wechatService;

    @RequestMapping(value = "/qrcode")
    public void qrcodeAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
        super.configResponse(response);
        String uid = request.getParameter("uid");
        response.getWriter().print(String.format("%s", wechatService.getQrcode(uid)));
    }

}
