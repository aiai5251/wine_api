package com.chimu.utils.tools;

import com.alibaba.fastjson.JSON;
import com.chimu.utils.Constant;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class WeChatGlobal {
    public static Date date;
    public static final Object objectToken = new Object();
    public static String token = null;

    public static String getOrderNumWithXML(String xml, String paramString) throws IOException, JDOMException {
        String returnString = null;
        Element element;
        if(CMString.isValid(xml)) {
            SAXBuilder sb = new SAXBuilder();
            Document doc = sb.build(new ByteArrayInputStream(xml.getBytes("utf-8")));
            Element root = doc.getRootElement();
            List<Element> elements = root.getChildren();
            if (elements != null && elements.size() != 0) {
                for (Element element1 : elements) {
                    element = element1;
                    if (paramString.equals(element.getName())) {
                        returnString = element.getText();
                        break;
                    }
                }
            }
        }
        return returnString;
    }

    public static String getSucceedXML(String return_code,String return_msg) {
        return "<xml><return_code><![CDATA[" + return_code +
                "]]></return_code><return_msg><![CDATA[" +
                return_msg + "]]></return_msg></xml>";
    }

    public static String getToken() throws Exception{
        Date now = new Date();
        if (WeChatGlobal.date == null || now.getTime() > WeChatGlobal.date.getTime() + 3600000) {
            synchronized(WeChatGlobal.objectToken) {
                if (WeChatGlobal.date == null || now.getTime() > WeChatGlobal.date.getTime() + 3600000) {
                    String url = String.format("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s", Constant.Appid, Constant.Appsecret);
                    String json = NetGlobal.HttpGet(url, null);
                    if (json != null && json.length() > 0) {
                        WeChatGlobal.token = JSON.parseObject(json).getString("access_token");
                        WeChatGlobal.date = now;
                    }
                }
            }
        }
        return WeChatGlobal.token;
    }


}
