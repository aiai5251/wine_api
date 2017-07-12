package com.chimu.admin.action;

import com.alibaba.fastjson.JSON;
import com.chimu.admin.bean.AdminBean;
import com.chimu.admin.service.AdminService;
import com.chimu.utils.BaseAction;
import com.chimu.utils.tools.CMString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @Autowired()
    private AdminService adminService;

    /// 登录
    @RequestMapping("/login")
    @ResponseBody
    public Map<String, Object> login(HttpServletRequest request, HttpServletResponse response) {
        super.configResponse(response);
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");

        Map<String, Object> map = new HashMap<String, Object>();
        if (CMString.isValid(phone) && CMString.isValid(password)) {
            // 设置response

            // 获取管理员信息
//            adminService = new AdminService();
            AdminBean adminBean = adminService.getAdmin(phone, password);
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
    @RequestMapping("/signIn")
    @ResponseBody
    public Map<String, Object> signIn(HttpServletRequest request, HttpServletResponse response) {
        super.configResponse(response);
        return null;
    }
}
