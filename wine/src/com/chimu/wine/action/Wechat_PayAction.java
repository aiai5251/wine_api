package com.chimu.wine.action;

import com.chimu.utils.tools.StringGlobal;
import com.chimu.wine.service.WechatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/")
public class Wechat_PayAction {
    @Autowired(required=false)
    private WechatService wechatService;

    @RequestMapping(value = "/pay/wechat_pay")
    protected String Action(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception{
        String type = request.getParameter("type");
        String wechatId = request.getParameter("wcid");
        String orderNo = request.getParameter("order_no");
        String amount = request.getParameter("amount");

//		wechatId = "o1D_JwGKMNWZmBYLxghYYw0GIlUg";
//		orderNo = "E201608081615020085728562-1-111";
//		amount = "1";

        model.put("data", wechatService.GetPrepay(wechatId, orderNo, amount));

        String[] rows = orderNo.split("-");

        String orderno = null;
        String from = null;
        String id = null;

        if(rows != null && rows.length > 2){
            orderno = rows[0];
            from = rows[1];
            id = rows[2];
        }

        if(StringGlobal.IsNull(type)){
//            model.put("url", String.format("http://www.pinshe.org/html/v1/coffee/order_done.html?from=%s&id=%s&orderno=%s&time=%d", from, id, orderno, new Date().getTime()));
        }else{
//            if("1".equals(type))
//                model.put("url", String.format("http://www.pinshe.org/html/v1/coffee/qrcode_done.html?from=%s&id=%s&orderno=%s&time=%d", from, id, orderno, new Date().getTime()));
        }

        return "/wechat_pay";
    }
}
