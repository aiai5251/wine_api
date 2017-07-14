package com.chimu.admin.service;

import com.chimu.admin.bean.AdminBean;
import com.chimu.admin.dao.AdminDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by leiliang on 2017/7/12.
 */
@Service
public class AdminService {
    @Autowired
    private AdminDao adminDao;

    /// 新增（注册）管理员
    public int signInAdmin(String phone, String password) {
        return adminDao.signInAdmin(phone, password);
    }

    /// 通过账号、密码获取管理员信息
    public AdminBean getAdmin(String phone, String password) {
        return adminDao.getAdmin(phone, password);
    }

    /// 通过用户Id获取管理员信息
    public AdminBean getAdminByUserId(int id) {
        return adminDao.getAdminByUserId(id);
    }

    /// 通过用户Id删除管理员
    public int deleteAdmin(int id) {
        return adminDao.deleteAdmin(id);
    }
}
