/**
 * Copyright 2021 ab173.com
 */
package com.example.teacherdata.bean;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Auto-generated: 2021-10-20 15:19:50
 *
 * @author ab173.com (info@ab173.com)
 * @website http://www.ab173.com/json/
 */
public class Data {

    private String _id;
    private String coverImageUrl;
    private String desc;
    private String title;
    private String type;

    public Data(String title, String coverImageUrl) {
    }

    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_id() {
        return _id;
    }

    public void setCoverImageUrl(String coverImageUrl) {
        this.coverImageUrl = coverImageUrl;
    }
    public String getCoverImageUrl() {
        return coverImageUrl;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    public String getDesc() {
        return desc;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Data{" +
                "_id='" + _id + '\'' +
                ", coverImageUrl='" + coverImageUrl + '\'' +
                ", desc='" + desc + '\'' +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}