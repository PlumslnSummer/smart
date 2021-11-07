/**
 * Copyright 2021 ab173.com
 */
package com.example.teacherdata.utils;
import com.example.teacherdata.bean.DataBanner;

import java.util.List;

/**
 * Auto-generated: 2021-10-21 11:1:16
 *
 * @author ab173.com (info@ab173.com)
 * @website http://www.ab173.com/json/
 */
public class BannersBean {

    private List<DataBanner> data;
    private int status;
    public void setData(List<DataBanner> data) {
        this.data = data;
    }
    public List<DataBanner> getData() {
        return data;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    public int getStatus() {
        return status;
    }

}