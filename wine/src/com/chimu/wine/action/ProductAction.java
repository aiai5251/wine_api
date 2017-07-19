package com.chimu.wine.action;

import com.chimu.utils.BaseAction;
import com.chimu.wine.bean.*;
import com.chimu.wine.service.*;
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
public class ProductAction extends BaseAction {
    @Autowired()
    private BannerService bannerService;
    @Autowired()
    private ProductService productService;
    @Autowired()
    private PromotionService promotionService;
    @Autowired()
    private CouponService couponService;
    @Autowired()
    private CommentService commentService;
    @Autowired()
    private UserService userService;

    @RequestMapping(value = "/product")
    @ResponseBody
    public Map<String, Object>productList(HttpServletResponse response) {
        super.configResponse(response);
        Map<String, Object> map = new HashMap<>();
        List<BannerBean> bannerList = bannerService.getBannerList();
        map.put("banners", bannerList);
        List<ProductBean> productList = productService.getProductList();
        map.put("productList", productList);
        return super.configResponseMap(map, 1);
    }

    @RequestMapping(value = "/product_detail")
    @ResponseBody
    public Map<String, Object>productDetail(HttpServletRequest request, HttpServletResponse response) {
        super.configResponse(response);
        String pid = request.getParameter("id");
        Map<String, Object> map = new HashMap<>();
        ProductBean productBean = productService.getProductWithId(Integer.parseInt(pid));
        if (productBean == null) {
            return super.configResponseMap(map, 0);
        }
        // 优惠券列表
        List<CouponBean> couponList = couponService.getCouponByPid(productBean.getId());
        productBean.setCouponList(couponList);

        // 促销列表
        List<PromotionBean> promotionList = promotionService.getPromotionList(productBean.getId());
        productBean.setPromotionList(promotionList);

        // 评价列表
        List<CommentBean> commentList = commentService.getCommentByPid(productBean.getId());
        List<CommentBean> comments = new ArrayList<>();
        for (int i = 0; i < commentList.size(); i++) {
            CommentBean commentBean = commentList.get(i);
            System.out.print("uid" + commentBean.getUid());
            UserBean userBean = userService.getCommentUserByUid(commentBean.getUid());
            commentBean.setUser_name(userBean.getName());
            commentBean.setUser_avatar(userBean.getAvatar());
            comments.add(commentBean);
        }
        productBean.setCommentList(comments);

        map.put("data", productBean);
        return super.configResponseMap(map, 1);
    }

}
