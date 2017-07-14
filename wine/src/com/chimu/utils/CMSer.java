package com.chimu.utils;

import com.chimu.utils.tools.CMString;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Created by leiliang on 2017/7/14.
 */
public class CMSer {

    public static String upfilePath = null;
    public static String CONFIG_BUNDLE_NAME = "config";

    public static Map<String, Object> uploadMapFileMap(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        try {
            getParam();
            if (!CMString.isValid(upfilePath)) {
                upfilePath = Config.imagePath();
            }
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;
            Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
            for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
                MultipartFile mf = entity.getValue();
                String key = entity.getKey();
                String dirfile = "";
                if (mf.getOriginalFilename().length() != 0) {
                    dirfile = copyUpFile(mf, upfilePath);
                }
                map.put(key, dirfile);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return map;
        }
        return map;
    }

    public static String copyUpFile(MultipartFile mf, String upfilePath) {
        String filename = "";
        String fileMore = "";
        String ramdom = "";
        File dir = null;
        try {
            Date currDate = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
            String currTime = format.format(currDate);

            if (!CMString.isValid(upfilePath)) {
                upfilePath = Config.imagePath();
            }
            InputStream is = mf.getInputStream();
            filename = mf.getOriginalFilename();
            if (filename.indexOf(".mp4") > -1) {
                upfilePath = Config.videoPath();
            }
            Random randomclass = new Random();
            int x = randomclass.nextInt(899999);
            x = x + 100000;
            ramdom = Integer.toString(x);

            if (filename != null && filename.length() > 0 && filename.indexOf(".mp4") > -1) {
                filename = currTime + ramdom + ".mp4";
            } else {
                filename = currTime + ramdom + filename.substring(filename.length() - 4, filename.length());
            }

            dir = new File(upfilePath);
            if (!dir.exists() && !dir.isDirectory()) {
                dir.mkdir();
            }
            // 如果服务器已经存在和上传文件同名的文件，则输出提示信息
            File tempFile = new File(dir + "/" + filename);
            if (tempFile.exists()) {
                // 删除已存在文件
                tempFile.delete();
            }
            // 开始保存文件到服务器
            if (CMString.isValid(filename)) {
                FileOutputStream fos = new FileOutputStream(dir + "/" + filename);
                byte[] buffer = new byte[8192]; // 每次读8K字节
                int count = 0;
                // 开始读取上传文件的字节，并将其输出到服务端的上传文件输出流中
                while ((count = is.read(buffer)) > 0) {
                    fos.write(buffer, 0, count); // 向服务端文件写入字节流
                }
                fos.close(); // 关闭FileOutputStream对象
                is.close(); // InputStream对象
            }
            fileMore = filename;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileMore;
    }

    public static void getParam() {
        PropertyResourceBundle prop = (PropertyResourceBundle) ResourceBundle.getBundle(CONFIG_BUNDLE_NAME);
        upfilePath = prop.getString("uploadFilePath");
    }
}
