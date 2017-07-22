package com.chimu.wine.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chimu.utils.Constant;
import com.chimu.utils.tools.CMString;
import com.chimu.utils.tools.NetGlobal;
import com.chimu.wine.bean.UserBean;
import com.chimu.wine.dao.UserDao;
import org.springframework.stereotype.Service;

@Service
public class WechatService {
    private UserDao userDao;
    public WechatService(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserBean getUserByCode(String code) throws Exception {
        String url = String.format("https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code", Constant.Appid, Constant.Appsecret, code);
        String json = NetGlobal.HttpGet(url, null);
        if(json != null && json.length() > 0){
            JSONObject row = JSON.parseObject(json);
            url = String.format("https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s&lang=zh_CN", row.getString("access_token"), row.getString("openid"));
            json = NetGlobal.HttpGet(url, null);
            row = JSON.parseObject(json);
            if(!CMString.isValid(row.getString("openid"))){
                UserBean userBean = userDao.getUserWithOpenid(row.getString("openid"));
                if (userBean != null) {
                    userBean.setName(new String(row.getString("nickname").getBytes("ISO-8859-1"), "utf-8"));
                    userBean.setAvatar(row.getString("headimgurl"));
                    userDao.modifyUser(userBean);
                } else {
                    userBean = new UserBean();
                    userBean.setName(new String(row.getString("nickname").getBytes("ISO-8859-1"), "utf-8"));
                    userBean.setOpenid(row.getString("openid"));
                    userBean.setAvatar(row.getString("headimgurl"));
                    userBean.setPoint(0);
                    userBean.setAward(0);
                    userBean.setIsVip(0);
                    userDao.addUser(userBean);
                }
                return userBean;
            }
        }
        return null;
    }

}
