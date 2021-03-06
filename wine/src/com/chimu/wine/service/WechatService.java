package com.chimu.wine.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chimu.utils.Constant;
import com.chimu.utils.tools.CMString;
import com.chimu.utils.tools.NetGlobal;
import com.chimu.utils.tools.WeChatGlobal;
import com.chimu.wine.bean.OrderBean;
import com.chimu.wine.bean.UserBean;
import com.chimu.wine.bean.WechatPayBean;
import com.chimu.wine.dao.UserDao;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class WechatService {
    private UserDao userDao;
    public WechatService(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserBean getUserByCode(String code) throws Exception {
        String url = String.format("https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code", Constant.Appid, Constant.Appsecret, code);
        String json = NetGlobal.HttpGet(url, null);
        if(json != null && json.length() > 0) {
            JSONObject row = JSON.parseObject(json);
            url = String.format("https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s&lang=zh_CN", row.getString("access_token"), row.getString("openid"));
            json = NetGlobal.HttpGet(url, null);
            row = JSON.parseObject(json);
            System.out.print("userInfo---- := " + row);
            if(CMString.isValid(row.getString("openid"))){
                UserBean userBean = userDao.getUserWithOpenid(row.getString("openid"));
                if (userBean != null) {
                    String nameString = new String(row.getString("nickname").getBytes("ISO-8859-1"), "utf-8");
                    nameString = CMString.getSerializeJson(nameString);
                    userBean.setName(nameString);
                    userBean.setAvatar(row.getString("headimgurl"));
                    userDao.modifyUser(userBean);
                } else {
                    userBean = new UserBean();
                    String nameString = new String(row.getString("nickname").getBytes("ISO-8859-1"), "utf-8");
                    nameString = CMString.getSerializeJson(nameString);
                    userBean.setName(nameString);
                    userBean.setOpenid(row.getString("openid"));
                    userBean.setAvatar(row.getString("headimgurl"));
                    userBean.setPoint(0);
                    userBean.setAward(0);
                    userBean.setIsVip(0);
                    userBean.setAdmin(0);
                    userDao.addUser(userBean);
                }
                return userBean;
            }
        }
        return null;
    }

    public String getPerPayId(String order_num, String openid, String amount) throws Exception {
        WechatPayBean wechatPayBean = new WechatPayBean();
        wechatPayBean.setAppid(Constant.Appid);
        wechatPayBean.setMch_id("1480904632");
        wechatPayBean.setNonce_str(String.valueOf(new java.util.Random().nextInt(100000000)));
        wechatPayBean.setBody("东方酒业");
        wechatPayBean.setOut_trade_no(order_num);
        wechatPayBean.setTotal_fee(amount);
        wechatPayBean.setSpbill_create_ip("127.0.0.1");
        wechatPayBean.setNotify_url("http://www.main-zha.com/chimu/wine/wechat_notify");
        wechatPayBean.setTrade_type("JSAPI");
        wechatPayBean.setOpenid(openid);
        wechatPayBean.buildSign();
        System.out.print("下单发送数据: ---------------" + wechatPayBean.createXml() + "---------------------");
        String xml = NetGlobal.HttpPost("https://api.mch.weixin.qq.com/pay/unifiedorder", null, wechatPayBean.createXml());
        System.out.print("发单post接口返回数据：" + xml + "-------------");
        String prepay_id = null;
        if (CMString.isValid(xml)) {
            prepay_id = WeChatGlobal.getOrderNumWithXML(xml, "prepay_id");
            System.out.print("prepay_id ==" + prepay_id);
        }

        return getPrePayId(prepay_id);
    }

    private String getPrePayId(String prepayId) throws Exception{
        String timeStamp = Long.toString(System.currentTimeMillis() / 1000);
        String nonceStr = String.valueOf(new java.util.Random().nextInt(100000000));

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("appId=%s&", 				Constant.Appid));
        sb.append(String.format("nonceStr=%s&", 			nonceStr));
        sb.append(String.format("package=prepay_id=%s&", 	prepayId));
        sb.append("signType=MD5&");
        sb.append(String.format("timeStamp=%s&", 			timeStamp));
        sb.append("key=" + Constant.AppKey);
        System.out.print("签名：" + sb.toString());
        String sign = CMString.Encode(sb.toString()).toUpperCase();

        StringBuilder json = new StringBuilder();
        json.append(String.format("\"appId\":\"%s\",", 				Constant.Appid));
        json.append(String.format("\"timeStamp\":\"%s\",", 			timeStamp));
        json.append(String.format("\"nonceStr\":\"%s\",", 			nonceStr));
        json.append(String.format("\"package\":\"prepay_id=%s\",", 	prepayId));
        json.append("\"signType\":\"MD5\",");
        json.append(String.format("\"paySign\":\"%s\"", 			sign));
        System.out.print("下单json：" + json.toString());
        return json.toString();
    }

    // 微信发送模版消息
    public String sendWechatTemplate(String wcid, OrderBean orderBean) throws Exception {
        String url = String.format("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=%s", WeChatGlobal.getToken());
        String body = String.format("{\"touser\": \"%s\", \"template_id\": \"kniXC0jnm-eD63ixnY5T2ct-E2xJfuhqqkgHbOc7n0o\", \"url\": \"\",\"topcolor\": \"#000000\", \"data\": {\"first\": {\"value\": \"欢迎您关注东方酒业\", \"color\": \"#000000\"}, \"Day\": {\"value\": \"%s\",\"color\": \"#000000\"},\"orderId\": {\"value\": \"%s\", \"color\": \"#FF0033\"}, \"orderType\": {\"value\": \"消费¥%s\", \"color\": \"#FF0033\"},\"customerName\": {\"value\": \"%s\", \"color\": \"#000000\"}, \"customerPhone\": {\"value\": \"%s\", \"color\": \"#000000\"}, \"remark\": {\"value\": \"有人下单了，快点发货哦！\", \"color\": \"#000000\"}}}",
                wcid, orderBean.getModify_time(), orderBean.getOrder_num(), orderBean.getPay(), orderBean.getAddressInfo().getName(), orderBean.getAddressInfo().getTel());
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        return NetGlobal.HttpPost(url, headers, body, "utf-8");
    }

    // https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=gQG88DwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAyQXFRbVplTG5meDIxMDAwMGcwN1QAAgS9zX5ZAwQAAAAA
    public String getQrcode(String code) throws Exception{
        String url = String.format("https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=%s", WeChatGlobal.getToken());
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        String json = String.format("{\"action_name\": \"QR_LIMIT_STR_SCENE\", \"action_info\": {\"scene\": {\"scene_str\": \"%s\"}}}", code);
        return NetGlobal.HttpPost(url, headers, json, "utf-8");
    }

}
