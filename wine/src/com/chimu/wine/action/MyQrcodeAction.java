package com.chimu.wine.action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chimu.utils.BaseAction;
import com.chimu.utils.Constant;
import com.chimu.wine.service.WechatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;

@Controller
@RequestMapping(value = "/wine")
public class MyQrcodeAction extends BaseAction {
    @Autowired()
    private WechatService wechatService;

    @RequestMapping(value = "/qrcode")
    public void qrcodeAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
        super.configResponse(response);
        response.setContentType("image/jpg"); //设置返回的文件类型
        String uid = request.getParameter("uid");
        JSONObject json = JSON.parseObject(wechatService.getQrcode(uid));
        URL url = new URL("https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=" + json.getString("ticket"));

        BufferedImage qrcodeImage = null; // 二维码
        try {
            InputStream inputStream = url.openStream();
            qrcodeImage = ImageIO.read(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 背景图  本地图片
        BufferedImage backgroundImage;
        File file = new File(Constant.SaveImagesLocalPath + "background.jpg");
        FileInputStream fis = new FileInputStream(file);
        backgroundImage = ImageIO.read(fis);

        // 背景图作为画布
        Graphics2D g = backgroundImage.createGraphics();
        // 放上图片，设定位置
        g.drawImage(qrcodeImage, 20, 350, 200, 200, null);
        g.dispose();

        try {
            OutputStream os = response.getOutputStream();
            // 将画输出
            ImageIO.write(backgroundImage, "jpg", os);
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
