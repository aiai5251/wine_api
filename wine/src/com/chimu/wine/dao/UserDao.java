package com.chimu.wine.dao;

import com.chimu.wine.bean.UserBean;

public interface UserDao {
    UserBean getCommentUserByUid(Integer uid);
}
