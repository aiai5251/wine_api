package com.chimu.wine.bean;

import java.util.Date;

/**
 * Created by didi on 2017/7/10.
 */
public class BannerBean {
    private int id;
    private String imgurl;  //图片地址
    private String url;     //跳转url
    private String title;   //标题
    private Date create_time;
    private Date modify_time;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getImgurl() { return imgurl; }
    public void setImgurl(String imgurl) { this.imgurl = imgurl; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Date getCreate_time() {
        return create_time;
    }
    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getModify_time() {
        return modify_time;
    }
    public void setModify_time(Date modify_time) {
        this.modify_time = modify_time;
    }
}
