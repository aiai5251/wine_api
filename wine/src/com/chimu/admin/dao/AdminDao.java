package com.chimu.admin.dao;

import com.chimu.admin.bean.AdminBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by leiliang on 2017/7/12.
 */
@Repository
public interface AdminDao {
    /// 新增（注册）管理员
    int signInAdmin(@Param("phone") String phone, @Param("password") String password);
    /// 通过账号、密码获取管理员信息
    AdminBean getAdmin(@Param("phone") String phone, @Param("password") String password);
    /// 通过用户Id获取管理员信息
    AdminBean getAdminByUserId(int userId);
    /// 通过用户id删除管理员
    int deleteAdmin(int userId);
}
