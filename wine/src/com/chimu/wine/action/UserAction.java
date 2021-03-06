package com.chimu.wine.action;

import com.chimu.utils.BaseAction;
import com.chimu.utils.tools.CMString;
import com.chimu.wine.bean.UserBean;
import com.chimu.wine.service.UserService;
import com.chimu.wine.service.WechatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/wine")
public class UserAction extends BaseAction {
    @Autowired()
    private UserService userService;
    @Autowired()
    private WechatService wechatService;

    @RequestMapping(value = "/user")
    @ResponseBody
    public Map<String, Object> getUserList(HttpServletRequest request, HttpServletResponse response) {
        super.configResponse(response);
        Map<String, Object> map = new HashMap<>();
        String id = request.getParameter("id");
        if (CMString.isValid(id)) {
            UserBean userBean = userService.getUserById(Integer.parseInt(id));
            map.put("data", userBean);
        } else {
            List<UserBean> userList = userService.getUserList();
            map.put("data", userList);
        }
        return super.configResponseMap(map, 1);
    }

    @RequestMapping(value = "/login")
    @ResponseBody
    public Map<String, Object> loginAction(HttpServletRequest request, HttpServletResponse response) {
        super.configResponse(response);
        Map<String, Object> map = new HashMap<>();
        String tel = request.getParameter("tel");
        String password = request.getParameter("password");
        UserBean userBean = userService.getUserByTel(tel);
        if (userBean.getAdmin() == 1) {
            if (userBean.getPassword().equals(CMString.MD5Encode(password))) {
                return super.configResponseMap(map, 1);
            }
        }
        return super.configResponseMap(map,0);
    }

    @RequestMapping(value = "/register")
    @ResponseBody
    public Map<String, Object> registerAction(HttpServletRequest request, HttpServletResponse response) {
        super.configResponse(response);
        Map<String, Object> map = new HashMap<>();
        String id = request.getParameter("id");
        String tel = request.getParameter("tel");
        String password = request.getParameter("password");
        UserBean userBean = userService.getUserById(Integer.parseInt(id));
        userBean.setTel(tel);
        userBean.setPassword(CMString.MD5Encode(password));
        userService.modifyUser(userBean);
        return super.configResponseMap(map, 1);
    }

    @RequestMapping(value = "/wechat")
    @ResponseBody
    public Map<String, Object> wechatAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
        super.configResponse(response);
        Map<String, Object> map = new HashMap<>();
        String code = request.getParameter("code");
        String url = request.getParameter("state");
        System.out.println("--------微信授权回调成功-----");
        System.out.print("code = " + code + "; url = " + url);
        UserBean userBean = wechatService.getUserByCode(code);
        if (userBean != null) {
            response.sendRedirect("http://www.main-zha.com/wine/com/wechat.html?state=" + url + "&wcid=" + userBean.getOpenid() + "&uid=" + userBean.getId());
        }
        return super.configResponseMap(map, 1);
    }

}
