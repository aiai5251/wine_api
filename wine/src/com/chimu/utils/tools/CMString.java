package com.chimu.utils.tools;

import java.math.BigInteger;
import java.security.MessageDigest;

public class CMString {

    /// 是否是有效字符串
    public static boolean isValid(String str) {
        return str != null && (str.length() > 0);
    }

    public static boolean isValidInt(Integer count) {
        return count != null && count > 0;
    }

    public static String getSerializeJson(String value){
        if(!isValid(value))
            value = value.replace("\r", "");
        if(!isValid(value))
            value = value.replace("\b", "");
        if(!isValid(value))
            value = value.replace("\f", "");
        if(!isValid(value))
            value = value.replace("\t", "");

        value = DeserializeJson(value);

        if(!isValid(value))
            value = value.replace("\\", "\\\\");
        if(!isValid(value))
            value = value.replace("\"", "\\\"");
        if(!isValid(value))
            value = value.replace("\n", "\\n");

        return value;
    }

    private static String DeserializeJson(String value){
        if(!isValid(value))
            value = value.replace("\\n", "\n");
        if(!isValid(value))
            value = value.replace("\\\"", "\"");
        if(!isValid(value))
            value = value.replace("\\\\", "\\");

        return value;
    }


    /**
     * MD5编码
     * @param origin 原始字符串
     * @return 经过MD5加密之后的结果
     */
    public static String MD5Encode(String origin) {
        String resultString = null;
        try {
            resultString = origin;
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(resultString.getBytes("UTF-8"));
            resultString = byteArrayToHexString(md.digest());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultString;
    }

    private final static String[] hexDigits = {"0", "1", "2", "3", "4", "5", "6", "7",
            "8", "9", "a", "b", "c", "d", "e", "f"};
    /**
     * 转换字节数组为16进制字串
     * @param b 字节数组
     * @return 16进制字串
     */
    private static String byteArrayToHexString(byte[] b) {
        StringBuilder resultSb = new StringBuilder();
        for (byte aB : b) {
            resultSb.append(byteToHexString(aB));
        }
        return resultSb.toString();
    }

    /**
     * 转换byte到16进制
     * @param b 要转换的byte
     * @return 16进制格式
     */
    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n = 256 + n;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
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
