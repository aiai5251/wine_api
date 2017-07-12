package com.chimu.wine.utils;

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
}
