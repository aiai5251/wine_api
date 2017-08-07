package com.chimu.wine.action;

import com.chimu.utils.BaseAction;
import com.chimu.utils.Constant;
import com.chimu.utils.tools.CMString;
import com.chimu.utils.tools.FileGlobal;
import com.chimu.wine.bean.PointBean;
import com.chimu.wine.bean.TeamBean;
import com.chimu.wine.bean.UserBean;
import com.chimu.wine.service.PointService;
import com.chimu.wine.service.TeamService;
import com.chimu.wine.service.UserService;
import com.chimu.wine.service.WeChatCallBackService;
import org.apache.commons.io.IOUtils;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;


@Controller
@RequestMapping(value = "/wine")
public class WeChatCallBackAction extends BaseAction {
    @Autowired()
    private WeChatCallBackService weChatCallBackService;
    @Autowired()
    private UserService userService;
    @Autowired()
    private PointService pointService;
    @Autowired()
    private TeamService teamService;

    @RequestMapping(value = "/wechat_callback", method = RequestMethod.POST)
    public void weChatCallBackAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        Element element;
        String toUserName = null;
        String fromUserName = null;
        String event = null;
        String eventKey = null;

        String xml = IOUtils.toString(request.getInputStream(), "utf-8");
        FileGlobal.AddWeChatFile(xml, "C:/Callback");

        if (xml != null) {
            SAXBuilder sb = new SAXBuilder();
            Document doc = sb.build(new ByteArrayInputStream(xml.getBytes("utf-8")));
            Element root = doc.getRootElement();
            List<Element> elements = root.getChildren();
            if (elements != null && elements.size() != 0) {
                for (int i = 0; i < elements.size(); i++) {
                    element = elements.get(i);

                    if("ToUserName".equals(element.getName()))
                        toUserName = element.getText();
                    else if("FromUserName".equals(element.getName()))
                        fromUserName = element.getText();
                    else if("Event".equals(element.getName()))
                        event = element.getText();
                    else if("EventKey".equals(element.getName()))
                        eventKey = element.getText();
                }
            }
        }

        System.out.print("--ToUserName ==" + toUserName);
        System.out.print("--FromUserName ==" + fromUserName);
        System.out.print("--Event ==" + event);
        System.out.print("--EventKey ==" + eventKey);

        if (event != null) {
            if ("subscribe".equals(event)) {
                if (CMString.isValid(eventKey)) {
                    System.out.print("subscribe -eventKey ==" + eventKey + "....");
                    String[] eventKeys = eventKey.split("_");

                    if (eventKeys.length > 0) {
                        if ("qrscene".equals(eventKeys[0])) {
                            String type = null;
                            if (eventKeys.length > 1)
                                type = eventKeys[1];

                            System.out.print("推荐的用户id：" + type);

                            if (CMString.isValid(type)) {
                                resetUser(fromUserName, type);
                            }
                        }
                    }
                }
                // 新用户关注
                response.getWriter().print(weChatCallBackService.ReplyText(fromUserName, toUserName));
            }

            if ("SCAN".equals(event)) {
                System.out.print("SCAN - eventKey == " + eventKey);
                if (CMString.isValid(eventKey)) {
                    resetUser(fromUserName, eventKey);
                }
                // 新用户关注
                response.getWriter().print(weChatCallBackService.ReplyText(fromUserName, toUserName));
            }

            if ("CLICK".equals(event)) {
                response.getWriter().print(weChatCallBackService.clickReplyText(fromUserName, toUserName, eventKey));
            }
        }

        response.getWriter().print("");
    }

    private void resetUser(String fromUserName, String userId) {
        // 先获取当前用户
        UserBean userBean = userService.getUserWithOpenid(fromUserName);
        UserBean userBean1 = userService.getUserById(Integer.parseInt(userId));
        if (userBean == null) {
            // 没有用户，先创建用户
            userBean = new UserBean();
            userBean.setName("东方酒业用户");
            userBean.setOpenid(fromUserName);
            userBean.setAvatar("");
            userBean.setPoint(0);
            userBean.setAward(0);
            userBean.setIsVip(0);
            userBean.setAdmin(0);
            // 在add的同时 添加积分记录
            userService.addUser(userBean);

            userBean1.setPoint(userBean1.getPoint() + 10);
            userService.modifyUser(userBean1);

            // 老用户添加积分记录
            PointBean pointBean = new PointBean();
            pointBean.setCreate_time(new Date());
            pointBean.setUid(userBean1.getId());
            pointBean.setPoint(10);
            pointBean.setDescription("发展下级得积分");
            pointBean.setType(0);
            pointService.addPoint(pointBean);

            TeamBean teamBean = new TeamBean();
            teamBean.setUid(userBean.getId());
            teamBean.setFri_id(userBean1.getId());
            teamService.addTeam(teamBean);

        }
//        else {
//            if (Objects.equals(userBean.getId(), userBean1.getId())) { // 两个用户相同
//            } else { // 用户不同
//                // 判断是否已经加过积分
//                TeamBean teamBean = teamService.getTeamFidByUid(userBean.getId());
//                if (teamBean == null) {
//                    // 没有和该用户绑定过
//                    teamBean = new TeamBean();
//                    teamBean.setUid(userBean.getId());
//                    teamBean.setFri_id(userBean1.getId());
//                    teamService.addTeam(teamBean);
//
//                    userBean1.setPoint(userBean1.getPoint() + 10);
//                    userService.modifyUser(userBean1);
//
//                    // 添加记录
//                    // 推荐的人
//                    PointBean pointBean1 = new PointBean();
//                    pointBean1.setCreate_time(new Date());
//                    pointBean1.setUid(userBean1.getId());
//                    pointBean1.setPoint(10);
//                    pointBean1.setDescription("推荐成功得积分");
//                    pointBean1.setType(0);
//                    pointService.addPoint(pointBean1);
//                }
//            }
//        }
    }


    @RequestMapping(value = "/wechat_callback", method = RequestMethod.GET)
    public String ActionGet(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String echostr = request.getParameter("echostr");
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");

        System.out.print("echostr = " + echostr + "signature" + signature + "timestamp" + timestamp + "nonce" + nonce);

        if (CMString.isValid(echostr) && CMString.isValid(signature) && CMString.isValid(timestamp) && CMString.isValid(nonce)) {
            if(CheckSignature(signature, timestamp, nonce, Constant.AppKey))
                response.getWriter().print(echostr);
            return null;
        }

        return null;
    }

    private boolean CheckSignature(String signature, String timestamp, String nonce, String token) throws NoSuchAlgorithmException {
        String[] tmpArr = {token, timestamp, nonce};
        Arrays.sort(tmpArr);
        String tmpStr = ArrayToString(tmpArr);
        tmpStr = SHA1Encode(tmpStr);
        return tmpStr.equalsIgnoreCase(signature);
    }

    private String ArrayToString(String [] arr){
        StringBuffer bf = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            bf.append(arr[i]);
        }
        return bf.toString();
    }

    private String SHA1Encode(String sourceString) throws NoSuchAlgorithmException{
        String resultString;
        resultString = sourceString;
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        return Byte2hexString(md.digest(resultString.getBytes()));
    }

    private String Byte2hexString(byte[] bytes){
        StringBuffer buf = new StringBuffer(bytes.length * 2);
        for (int i = 0; i < bytes.length; i++) {
            if (((int) bytes[i] & 0xff) < 0x10) {
                buf.append("0");
            }
            buf.append(Long.toString((int)bytes[i] & 0xff, 16));
        }
        return buf.toString().toUpperCase();
    }

//    @RequestMapping(value = "/wechat_sign")
//    @ResponseBody
//    public void signWechatAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        super.configResponse(response);
//        String callBack = request.getParameter("url");
//        String jsApi_ticket = weChatCallBackService.getJsApiTicket();
//        Map<String, String> ret = sign(jsApi_ticket, callBack);
//        response.getWriter().print(String.format("{\"appId\":\"%s\",\"timestamp\":\"%s\",\"nonceStr\":\"%s\",\"signature\":\"%s\"}", Constant.Appid, ret.get("timestamp"), ret.get("nonceStr"), ret.get("signature")));
//    }
//
//    private static Map<String, String> sign(String jsapi_ticket, String url) {
//        Map<String, String> ret = new HashMap<>();
//        String nonce_str = create_nonce_str();
//        String timestamp = create_timestamp();
//        String string1;
//        String signature = "";
//
//        //注意这里参数名必须全部小写，且必须有序
//        string1 = "jsapi_ticket=" + jsapi_ticket +
//                "&noncestr=" + nonce_str +
//                "&timestamp=" + timestamp +
//                "&url=" + url;
//
//        try {
//            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
//            crypt.reset();
//            crypt.update(string1.getBytes("UTF-8"));
//            signature = byteToHex(crypt.digest());
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//
//        ret.put("url", url);
//        ret.put("jsapi_ticket", jsapi_ticket);
//        ret.put("nonceStr", nonce_str);
//        ret.put("timestamp", timestamp);
//        ret.put("signature", signature);
//
//        return ret;
//    }
//
//    private static String byteToHex(final byte[] hash) {
//        Formatter formatter = new Formatter();
//        for (byte b : hash) {
//            formatter.format("%02x", b);
//        }
//        String result = formatter.toString();
//        formatter.close();
//        return result;
//    }
//
//    private static String create_nonce_str() {
//        return UUID.randomUUID().toString();
//    }
//
//    private static String create_timestamp() {
//        return Long.toString(System.currentTimeMillis() / 1000);
//    }

}
