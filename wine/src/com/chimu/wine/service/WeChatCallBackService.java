package com.chimu.wine.service;

import com.alibaba.fastjson.JSON;
import com.chimu.utils.tools.NetGlobal;
import com.chimu.utils.tools.WeChatGlobal;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class WeChatCallBackService {

    // 自动回复，目前没有设置自动回复的文本，暂不需要写获取接口
//    public String GetAutoReply() throws Exception{
//        String url = String.format("https://api.weixin.qq.com/cgi-bin/get_current_autoreply_info?access_token=%s", WeChatGlobal.getToken());
//        return NetGlobal.HttpGet(url, null, "utf-8");
//    }

    // 写死在后台，关注自动回复默认文本
    public String ReplyText(String toUser, String fromUser) throws Exception{
        String content = "你好，欢迎关注东方酒业!";

//        String json = GetAutoReply();
//        if (CMString.isValid(json)) {
//            JSONObject row = JSON.parseObject(json);
//            if(row != null){
//                JSONObject add_friend_autoReply_info = row.getJSONObject("add_friend_autoreply_info");
//                if(add_friend_autoReply_info != null)
//                    content = add_friend_autoReply_info.getString("content");
//            }
//        }
//
//        if(content == null)
//            content = "";
        return getXmlString(toUser, fromUser, content);
    }

    // 点击发送文本 event = CLICK
    public String clickReplyText(String toUser, String fromUser, String content) {
        return getXmlString(toUser, fromUser, content);
    }

    private String getXmlString(String toUser, String fromUser, String content) {
        StringBuffer xml = new StringBuffer();
        xml.append("<xml>");
        xml.append(String.format("<ToUserName><![CDATA[%s]]></ToUserName>", toUser));
        xml.append(String.format("<FromUserName><![CDATA[%s]]></FromUserName>", fromUser));
        xml.append(String.format("<CreateTime>%d</CreateTime>", new Date().getTime()));
        xml.append(String.format("<MsgType><![CDATA[%s]]></MsgType>", "text"));
        xml.append(String.format("<Content><![CDATA[%s]]></Content>", content));
        xml.append("<MsgId><![CDATA[1234567890123456]]></MsgId>");
        xml.append("</xml>");
        System.out.print("pushXml" + xml.toString());
        return xml.toString();
    }

    // 获取菜单
//    public String GetMenu() throws Exception{
//        String url = String.format("https://api.weixin.qq.com/cgi-bin/get_current_selfmenu_info?access_token=%s", WeChatGlobal.getToken());
//		return NetGlobal.HttpGet(url, null, "utf-8");
//    }
//
//    public String SetMenu() throws Exception{
//        String url = String.format("https://api.weixin.qq.com/cgi-bin/get_current_selfmenu_info?access_token=%s", WeChatGlobal.getToken());
//        String json = NetGlobal.HttpGet(url, null, "utf-8");
//
//        if(json != null && json.length() > 0){
//            JSONObject row = JSON.parseObject(json);
//            url = String.format("https://api.weixin.qq.com/cgi-bin/menu/create?access_token=%s", getToken());
//            System.out.print(url);
//            Map<String, String> headers = new HashMap<>();
//            headers.put("Content-Type", "application/json");
//
//            json = row.getJSONObject("selfmenu_info").toJSONString();
//            json = json.replaceAll("\\{\"list\"\\:\\[", "[");
//            json = json.replaceAll("\\}\\]\\}\\}","}]}");
//            System.out.print(json);
//            return NetGlobal.HttpPost(url, headers, json, "utf-8");
//        }
//        return null;
//    }

    // 微信公众号菜单使用接口来调整：
    /*
    * https://mp.weixin.qq.com/debug
    * access_token: yEPhD2oyBaEEfkidQaocyp7lcVxEt1l1-MN_6n0kBG2ZjRXv-muKoVfcvvu1ABN3DxUrw3UN2-KjDoL9VwlIRBQ91Qloty0QcPUkRJeqXWURWZfAHAXCF
    {
        "button": [
        {
            "type": "view",
            "name": "买酒",
            "url": "http://www.main-zha.com/wine/goodslist.html"
        },
        {
            "name": "菜单",
            "sub_button": [
                {
                    "type": "view",
                    "name": "我的二维码",
                    "url": "http://www.main-zha.com/wine/my_qrcode.html"
                },
                {
                    "type": "click",
                    "name": "联系客服",
                    "key": "请咨询：18515379685"
                }
            ]
        }
        ]
    }
*/


//    public String getJsApiTicket() throws Exception{
//        String url = String.format("https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=%s&type=jsapi", WeChatGlobal.getToken());
//        String json = NetGlobal.HttpGet(url, null);
//        if(json != null && json.length() > 0){
//            return JSON.parseObject(json).getString("ticket");
//        }
//        return null;
//    }

}
