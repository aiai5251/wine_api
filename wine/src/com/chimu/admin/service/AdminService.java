package com.chimu.admin.service;

import com.chimu.admin.bean.AdminBean;
import com.chimu.admin.dao.AdminDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by leiliang on 2017/7/12.
 */
@Service
public class AdminService {
    @Autowired
    private AdminDao adminDao;

    /// 通过账号、密码获取管理员信息
    public AdminBean getAdmin(String phone, String password) {
        AdminBean adminBean = adminDao.getAdmin(phone, password);
        return adminBean;
    }

    /// 通过用户Id获取管理员信息
    public AdminBean getAdminByUserId(int userId) {
        AdminBean adminBean = adminDao.getAdminByUserId(userId);
        return adminBean;
    }
}
