package com.chimu.admin.action;

import com.alibaba.fastjson.JSON;
import com.chimu.admin.bean.AdminBean;
import com.chimu.admin.service.AdminService;
import com.chimu.utils.BaseAction;
import com.chimu.utils.tools.CMString;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by leiliang on 2017/7/12.
 */
@Controller
@RequestMapping("/admin")
public class AdminAction extends BaseAction {

    @Autowired
    private AdminService adminService;

    /// 登录
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> login(HttpServletRequest request, HttpServletResponse response) {
        super.configResponse(response);

        String phone = request.getParameter("phone");
        String password = request.getParameter("password");

        Map<String, Object> map = new HashMap<>();
        if (CMString.isValid(phone) && CMString.isValid(password)) {
            // 获取管理员信息
            AdminBean adminBean = adminService.getAdmin(phone, CMString.MD5(password));
            if (adminBean != null && CMString.isValid(adminBean.getPhone())) {
                map.put("status", 1);
                map.put("infoMsg", "登录成功");
                map.put("data", JSON.toJSON(adminBean));
            } else {
                map.put("status", 0);
                map.put("infoMsg", "您的账号或密码有误");
                map.put("data", "");
            }
            return map;
        }
        map.put("status", 1);
        map.put("infoMsg", "账号和密码不能为空");
        map.put("data", "");
        return map;
    }

    /// 注册
    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> signIn(HttpServletRequest request, HttpServletResponse response) {
        super.configResponse(response);

        String phone = request.getParameter("phone");
        String password = request.getParameter("password");

        Map<String, Object> map = new HashMap<>();
        if (CMString.isValid(phone) && CMString.isValid(password)) {
            AdminBean adminBean = adminService.getAdmin(phone, CMString.MD5(password));
            if (adminBean != null && CMString.isValid(adminBean.getPhone())) {
                map.put("status", 0);
                map.put("infoMsg", "该用户已存在，不能重复注册");
                map.put("data", JSON.toJSON(new HashMap<>()));
            } else {
                int result = adminService.signInAdmin(phone, CMString.MD5(password));
                if (result == 1) {
                    map.put("status", 1);
                    map.put("infoMsg", "恭喜您，注册成功");
                    map.put("data", JSON.toJSON(new HashMap<>()));
                }
            }
            return map;
        }
        map.put("status", 0);
        map.put("infoMsg", "注册失败，请重试");
        map.put("data", JSON.toJSON(new HashMap<>()));
        return map;
    }
}
