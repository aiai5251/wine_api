package com.chimu.utils.tools;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * Created by leiliang on 2017/7/12.
 */
public class CMString {

    /// 是否是有效字符串
    public static boolean isValid(String str) {
        return str != null && (str.length() > 0);
    }

    public static boolean isValidInt(Integer count) {
        return count != null && count > 0;
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

    /// MD5加密
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

    private final static String[] hexDigits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    public static String Encode(String origin) throws Exception{
        String resultString = origin;
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(resultString.getBytes("UTF-8"));
        resultString = ByteArrayToHexString(md.digest());
        return resultString;
    }

    private static String ByteArrayToHexString(byte[] b){
        StringBuilder resultSb = new StringBuilder();
        for(byte aB : b)
            resultSb.append(ByteToHexString(aB));
        return resultSb.toString();
    }

    private static String ByteToHexString(byte b){
        int n = b;
        if (n < 0)
            n = 256 + n;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }
}
