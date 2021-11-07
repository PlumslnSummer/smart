/**
 * Copyright 2021 ab173.com
 */
package com.example.teacherdata.bean;
import java.util.List;

/**
 * Auto-generated: 2021-10-20 15:19:50
 *
 * @author ab173.com (info@ab173.com)
 * @website http://www.ab173.com/json/
 */
public class HomeClassBean {

    private List<Data> dataList;
    private int status;

    public List<Data> getDataList() {
        return dataList;
    }

    public void setDataList(List<Data> dataClass) {
        this.dataList =dataClass;

    }

    public void setStatus(int status) {
        this.status = status;
    }
    public int getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "HomeClassBean{" +
                "data=" + dataList +
                ", status=" + status +
                '}';
    }
}