package com.chimu.wine.dao;

import com.chimu.wine.bean.CommentBean;

import java.util.List;

public interface CommentDao {
    List<CommentBean> getCommentByPid(Integer pid);
}
