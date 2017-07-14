package com.chimu.utils;

import com.chimu.utils.tools.CMString;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leiliang on 2017/7/14.
 */
public class CMImagePath {
    /// 传进来逗号分隔的图片名字符串，返回带链接的逗号分割图片字符串
    /// 原函数名：getimageList
    public static String imagesURLPath(String imageStr) {
        if (CMString.isValid(imageStr)) {
            String arr[] = imageStr.split(",");
            String string = "";
            for (String tmp: arr) {
                string = string + "http://" + Config.host() + "/Student_maven/user/image.do?fileName=" + tmp + ",";
            }
            return string.substring(0, string.length() - 1);
        }
        return "http://" + Config.host() + "/Student_maven/user/image.do?fileName=" + imageStr;
    }

    /// 传进来图片名数组，返回逗号分隔的图片字符串
    /// 原函数名：path_images
    public static String imagesPath(List<String> arr, String path) {
        String imageStr = "";
        for (String tmp: arr) {
            imageStr = imageStr + path + tmp + ",";
        }
        imageStr = imageStr.substring(0, imageStr.length() - 1);
        return imageStr;
    }

    /// 传进来多个逗号分隔的图片名字符串，返回带有http链接的图片地址数组
    /// 原函数名：Array_images
    public static List<String> imagesPathToArray(String imagesPath) {
        List<String> imagesArray = new ArrayList<>();
        String arr[] = imagesURLPath(imagesPath).split(",");
        for (String tmp: arr) {
            imagesArray.add(tmp);
        }
        return imagesArray;
    }
}
