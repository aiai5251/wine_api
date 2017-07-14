package com.chimu.utils.tools;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * Created by leiliang on 2017/7/12.
 */
public class CMString {

    /// 是否是有效字符串
    public static boolean isValid(String str) {
        if (str == null) {
            return false;
        }
        return (str.length() > 0);
    }

    /// 字符串保护
    public static String safeString(String str) {
        if (str == null) {
            return "";
        }
        if (str instanceof String) {
            return str;
        }
        return "";
    }

    public static String MD5(String str) {
        if (!CMString.isValid(str)) {
            return "";
        }
        try {
            // 生成MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            System.out.print("MD5加密错误");
            return "";
        }
    }
}
