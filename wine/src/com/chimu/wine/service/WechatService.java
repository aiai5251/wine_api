package com.chimu.wine.service;

import com.alibaba.fastjson.JSON;
import com.chimu.utils.tools.CMString;
import com.chimu.utils.tools.Cache;
import com.chimu.utils.tools.NetGlobal;
import com.chimu.wine.bean.WechatPayBean;

import java.io.ByteArrayInputStream;
import org.jdom2.input.SAXBuilder;
import org.jdom2.Document;
import org.jdom2.Element;

import java.util.Date;
import java.util.List;

public class WechatService {
    private String appid;
    private String appsecret; //8720022262e5661fa5def6c20ec876e4

    public String GetPrepay(String wechatId, String orderNo, String amount) throws Exception{
        WechatPayBean pay = new WechatPayBean();
        pay.setAppid("wxa699e71285eee5a1");
        pay.setMch_id("1480904632");
        pay.setNonce_str(String.valueOf(new java.util.Random().nextInt(100000000)));
        pay.setBody("东方酒业");
        pay.setOut_trade_no(orderNo);
        pay.setTotal_fee(amount);
        pay.setSpbill_create_ip("127.0.0.1");
        pay.setNotify_url("http://69a6a38e.ngrok.natapp.cn/heyi-console/wechat/weixinNotify");
        pay.setTrade_type("JSAPI");
        pay.setOpenid(wechatId);
        pay.BuildSign();
        String xml = NetGlobal.HttpPost("https://api.mch.weixin.qq.com/pay/unifiedorder", null, pay.ToXml());

        Element element;
        if(xml != null){
            SAXBuilder sb = new SAXBuilder();
            Document doc = sb.build(new ByteArrayInputStream(xml.getBytes("utf-8")));
            Element root = doc.getRootElement();
            List<Element> elements = root.getChildren();
            if (elements != null && elements.size() != 0) {
                for(int i = 0; i < elements.size(); i++){
                    element = elements.get(i);
                    if("prepay_id".equals(element.getName()))
                        return GetPay(element.getText());
                }
            }
        }

        return null;
    }

    private String GetPay(String prepayId) throws Exception{
        String timeStamp = Long.toString(System.currentTimeMillis() / 1000);
        String nonceStr = String.valueOf(new java.util.Random().nextInt(100000000));

        StringBuffer sb = new StringBuffer();
        sb.append(String.format("appId=%s&", 				appid));
        sb.append(String.format("nonceStr=%s&", 			nonceStr));
        sb.append(String.format("package=prepay_id=%s&", 	prepayId));
        sb.append("signType=MD5&");
        sb.append(String.format("timeStamp=%s&", 			timeStamp));
        sb.append("key=qazwsxedcrfvtgbyhnujmikolp123456");
        String sign = CMString.Encode(sb.toString()).toUpperCase();

        StringBuffer json = new StringBuffer();
        json.append(String.format("\"appId\":\"%s\",", 				appid));
        json.append(String.format("\"timeStamp\":\"%s\",", 			timeStamp));
        json.append(String.format("\"nonceStr\":\"%s\",", 			nonceStr));
        json.append(String.format("\"package\":\"prepay_id=%s\",", 	prepayId));
        json.append("\"signType\":\"MD5\",");
        json.append(String.format("\"paySign\":\"%s\"", 			sign));

        return json.toString();
    }


//    private String GetToken() throws Exception{
//        Date now = new Date();
//        if(Cache.date == null || now.getTime() > Cache.date.getTime() + 3600000){
//            synchronized (Cache.objectToken){
//                if(Cache.date == null || now.getTime() > Cache.date.getTime() + 3600000){
//                    String url = String.format("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s", appid, appsecret);
//                    String json = NetGlobal.HttpGet(url, null);
//                    if(json != null && json.length() > 0){
//                        Cache.token = JSON.parseObject(json).getString("access_token");
//                        Cache.date = now;
//                    }
//                }
//            }
//        }
//
//        return Cache.token;
//    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getAppsecret() {
        return appsecret;
    }

    public void setAppsecret(String appsecret) {
        this.appsecret = appsecret;
    }
}
