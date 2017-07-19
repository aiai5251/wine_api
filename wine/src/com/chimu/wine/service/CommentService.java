package com.chimu.wine.service;

import com.chimu.wine.bean.CommentBean;
import com.chimu.wine.dao.CommentDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private CommentDao commentDao;
    public CommentService(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    public List<CommentBean> getCommentByPid(Integer pid) {
        return commentDao.getCommentByPid(pid);
    }

}
