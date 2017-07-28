package com.chimu.wine.dao;

import com.chimu.wine.bean.CommentBean;

import java.util.List;

public interface CommentDao {

    void addComment(CommentBean commentBean);

    List<CommentBean> getCommentByPid(Integer pid);
}
