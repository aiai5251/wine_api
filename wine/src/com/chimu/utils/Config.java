package com.chimu.utils;

import java.net.InetAddress;

/**
 * Created by leiliang on 2017/7/14.
 */
public class Config {

    /// MARK: - Constant Attributes
    private enum Env {
        Dev,  // 开发环境
        Rel   // 线上环境
    }

    /// 在这里切换环境
    private static final Env currentEnv = Env.Dev;

    // 开发环境
    private static final String DevImagePath = "d:\\uploadImage\\";
    private static final String DevVideoPath = "d:\\upvideo\\";

    // 线上环境
    private static final String RelHostAdd = "47.94.5.150";
    private static final String RelImagePath = "c:\\uploadImage\\";
    private static final String RelVideoPath = "c:\\upvideo\\";

    /// MARK: - Info Methods
    /// 图片路径
    public static String imagePath() {
        if (currentEnv == Env.Dev) {
            return DevImagePath;
        }
        return RelImagePath;
    }

    /// 音视频路径
    public static String videoPath() {
        if (currentEnv == Env.Dev) {
            return DevVideoPath;
        }
        return RelVideoPath;
    }

    /// host、port地址
    public static String host() {
        if (currentEnv == Env.Dev) {
            InetAddress inetAddress = null;
            String localIp = null;
            try {
                inetAddress = InetAddress.getLocalHost();
                localIp = inetAddress.getHostAddress();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return localIp + ":8080";
        }
        return RelHostAdd;
    }
}
