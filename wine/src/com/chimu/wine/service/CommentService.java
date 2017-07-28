package com.chimu.wine.service;

import com.chimu.utils.tools.FileGlobal;
import com.chimu.wine.bean.CommentBean;
import com.chimu.wine.bean.ImageBean;
import com.chimu.wine.dao.CommentDao;
import com.chimu.wine.dao.ImageDao;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {
    private CommentDao commentDao;
    private ImageDao imageDao;
    public CommentService(CommentDao commentDao, ImageDao imageDao) {
        this.commentDao = commentDao;
        this.imageDao = imageDao;
    }

    public void addComment(CommentBean commentBean, List<MultipartFile> files) throws Exception {
        commentDao.addComment(commentBean);

        // 图片添加到本地和数据库中
        for (MultipartFile file : files) {
            if (file != null && !file.isEmpty()) {
                String url = FileGlobal.AddFile(file);
                ImageBean imageBean = new ImageBean();
                imageBean.setUrl(url);
                imageBean.setProduct_id(0);
                imageBean.setProduct_type(0);
                imageBean.setBanner_id(0);
                imageBean.setComment_id(commentBean.getId());
                imageDao.addImage(imageBean);
            }
        }

    }

    public List<CommentBean> getCommentByPid(Integer pid) {
        List<CommentBean> comments = commentDao.getCommentByPid(pid);
        List<CommentBean> commentList = new ArrayList<>();
        for (CommentBean commentBean : comments) {
            commentBean.setImages(imageDao.getImagesByCid(commentBean.getId()));
            commentList.add(commentBean);
        }
        return commentList;
    }

}
