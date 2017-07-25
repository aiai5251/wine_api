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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}
