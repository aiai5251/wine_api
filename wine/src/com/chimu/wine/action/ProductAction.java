package com.chimu.wine.action;

import com.chimu.utils.BaseAction;
import com.chimu.wine.bean.*;
import com.chimu.wine.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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
        for (CommentBean commentBean : commentList) {
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

    @RequestMapping(value = "/product_add")
    @ResponseBody
    public Map<String, Object> addProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
        super.configResponse(response);
        Map<String, Object> map = new HashMap<>();
        Boolean isSucceed = getProductWith(request, true);
        if (isSucceed) {
            return super.configResponseMap(map, 1);
        }
        return super.configResponseMap(map, 0);
    }

    @RequestMapping(value = "/product_modify")
    @ResponseBody
    public Map<String, Object> modifyProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
        super.configResponse(response);
        Map<String, Object> map = new HashMap<>();
        Boolean isSucceed = getProductWith(request, false);
        if (isSucceed) {
            return super.configResponseMap(map, 1);
        }
        return super.configResponseMap(map, 0);
    }

    private Boolean getProductWith(HttpServletRequest request, Boolean isAdd) throws Exception {
        String title = request.getParameter("title");
        String submessage = request.getParameter("submessage");
        String price = request.getParameter("price");
        String volume = request.getParameter("volume");
        String description = request.getParameter("description");
        String origprice = request.getParameter("origprice");
        String count = request.getParameter("count");
        String freight_money = request.getParameter("freight_money");
        String point = request.getParameter("point");
        String invalid = request.getParameter("invalid");
        List<MultipartFile> files = null;
        try {
            files = ((MultipartHttpServletRequest)request).getFiles("file");
        } catch(Exception ignored) {}

        List<MultipartFile> files1 = null;
        try {
            files1 = ((MultipartHttpServletRequest)request).getFiles("descriptionFile");
        } catch (Exception ignored) {}

        if (files != null && files.size() > 0 && files1 != null && files1.size() > 0) {
            ProductBean productBean;
            if (isAdd) {
                productBean = new ProductBean();
            } else {
                String id = request.getParameter("id");
                productBean = productService.getProductWithId(Integer.parseInt(id));
            }
            productBean.setTitle(title);
            productBean.setSubmessage(submessage);
            productBean.setPrice(Float.parseFloat(price));
            productBean.setVolume(Integer.parseInt(volume));
            productBean.setDescription(description);
            productBean.setOrigprice(Float.parseFloat(origprice));
            productBean.setCount(Integer.parseInt(count));
            productBean.setFreight_money(Float.parseFloat(freight_money));
            productBean.setPoint(Integer.parseInt(point));
            productBean.setInvalid(Integer.parseInt(invalid));
            if (isAdd) {
                productService.addProduct(productBean, files, files1);
            } else {
                productService.modifyProduct(productBean, files, files1);
            }
            return true;
        }
        return false;
    }

}
