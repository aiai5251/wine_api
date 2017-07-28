package com.chimu.wine.action;

import com.chimu.utils.BaseAction;
import com.chimu.wine.bean.CommentBean;
import com.chimu.wine.bean.UserBean;
import com.chimu.wine.service.CommentService;
import com.chimu.wine.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
@RequestMapping(value = "/wine")
public class CommentAction extends BaseAction {
    @Autowired()
    private CommentService commentService;
    @Autowired()
    private UserService userService;

    @RequestMapping(value = "/comment")
    @ResponseBody
    public Map<String, Object> commentAction(HttpServletRequest request, HttpServletResponse response) {
        super.configResponse(response);
        String pid = request.getParameter("pid");
        Map<String, Object> map = new HashMap<>();
        List<CommentBean> commentList = commentService.getCommentByPid(Integer.parseInt(pid));
        List<CommentBean> comments = new ArrayList<>();
        for (CommentBean commentBean : commentList) {
            UserBean userBean = userService.getCommentUserById(commentBean.getUid());
            commentBean.setUser_name(userBean.getName());
            commentBean.setUser_avatar(userBean.getAvatar());
            comments.add(commentBean);
        }
        map.put("data", comments);
        return super.configResponseMap(map, 1);
    }

    @RequestMapping(value = "/comment_add")
    @ResponseBody
    public Map<String, Object> addCommentAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
        super.configResponse(response);
        Map<String, Object> map = new HashMap<>();
        String title = request.getParameter("title");
        String pid = request.getParameter("pid");
        String uid = request.getParameter("uid");

        CommentBean commentBean = new CommentBean();
        commentBean.setTitle(title);
        commentBean.setPid(Integer.parseInt(pid));
        commentBean.setUid(Integer.parseInt(uid));
        commentBean.setCreate_time(new Date());

        List<MultipartFile> files = null;
        try {
            files = ((MultipartHttpServletRequest)request).getFiles("file");
        } catch(Exception ignored) {}

        if (files != null && files.size() > 0) {
            commentService.addComment(commentBean, files);
        }

        return super.configResponseMap(map, 1);
    }
}
