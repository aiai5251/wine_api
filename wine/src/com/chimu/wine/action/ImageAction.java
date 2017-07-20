package com.chimu.wine.action;

import com.chimu.utils.BaseAction;
import com.chimu.utils.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.misc.IOUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
@RequestMapping(value = "/")
public class ImageAction extends BaseAction {

    @RequestMapping(value = "/image")
    public void testPic(HttpServletRequest request, HttpServletResponse response) throws IOException {
        super.configResponse(response);
        response.setContentType("image/jpg"); //设置返回的文件类型

        File file = new File(Constant.SaveImagesLocalPath + request.getParameter("name"));
        FileInputStream fis = new FileInputStream(file);
        OutputStream outputStream = response.getOutputStream();

        // 图片多大
        byte[] b = new byte[(int)file.length()];
        if(fis.available()>0) {
            int i;
            while((i = fis.read(b)) > 0) {  //读取流，写入流
                if(b.length > 0) {
                    outputStream.write(b, 0, i);
                }
            }
            outputStream.flush();
        }
    }
}
