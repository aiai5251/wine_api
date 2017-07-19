package com.chimu.wine.action;

import com.chimu.utils.BaseAction;
import com.chimu.wine.bean.CartBean;
import com.chimu.wine.service.CartService;
import com.chimu.wine.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/wine")
public class CashAction extends BaseAction {
    @Autowired()
    private CartService cartService;
    @Autowired()
    private ProductService productService;

    @RequestMapping("/cart_add")
    @ResponseBody
    public Map<String, Object> addCartAction(HttpServletRequest request, HttpServletResponse response) {
        super.configResponse(response);
        Map<String, Object> map = new HashMap<>();
        String pid = request.getParameter("pid");
        String uid = request.getParameter("uid");
        String count = request.getParameter("count");

        CartBean hasCartBean = cartService.getCartByPidWithUid(Integer.parseInt(pid), Integer.parseInt(uid));
        if (hasCartBean != null) {
            hasCartBean.setCount(Integer.parseInt(count));
            cartService.modifyCartById(hasCartBean.getId(), Integer.parseInt(count));
            map.put("data", hasCartBean);
        } else {
            CartBean cartBean = new CartBean();
            cartBean.setPid(Integer.parseInt(pid));
            cartBean.setUid(Integer.parseInt(uid));
            cartBean.setCount(Integer.parseInt(count));
            cartService.addCart(cartBean);
            map.put("data", cartBean);
        }
        return super.configResponseMap(map, 1);
    }

    @RequestMapping(value = "/cart")
    @ResponseBody
    public Map<String, Object> cart(HttpServletRequest request, HttpServletResponse response) {
        super.configResponse(response);
        String uid = request.getParameter("uid");
        Map<String, Object> map = new HashMap<>();
        List<CartBean> cartList = cartService.getCartByUid(Integer.parseInt(uid));
        for (CartBean cartBean : cartList) {
            cartBean.setProductModel(productService.getProductWithId(cartBean.getPid()));
        }
        map.put("data", cartList);
        return super.configResponseMap(map, 1);
    }
}
