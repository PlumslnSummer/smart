/**
 * Copyright 2021 ab173.com
 */
package com.example.teacherdata.bean;

/**
 * Auto-generated: 2021-10-21 11:1:16
 *
 * @author ab173.com (info@ab173.com)
 * @website http://www.ab173.com/json/
 */
public class DataBanner {

    private String image;
    private String title;
    private String url;
    public void setImage(String image) {
        this.image = image;
    }
    public String getImage() {
        return image;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "DataBanner{" +
                "image='" + image + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}