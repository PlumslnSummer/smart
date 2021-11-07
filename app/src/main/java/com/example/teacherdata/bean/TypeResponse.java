/**
 * Copyright 2021 ab173.com
 */
package com.example.teacherdata.bean;
import java.util.List;

/**
 * Auto-generated: 2021-10-20 9:38:47
 *
 * @author ab173.com (info@ab173.com)
 * @website http://www.ab173.com/json/
 */
public class TypeResponse {

    private List<DataType> data;
    private int page;
    private int page_count;
    private int status;
    private int total_counts;

    public List<DataType> getData() {
        return data;
    }

    public void setData(List<DataType> data) {
        this.data = data;
    }

    public void setPage(int page) {
        this.page = page;
    }
    public int getPage() {
        return page;
    }

    public void setPage_count(int page_count) {
        this.page_count = page_count;
    }
    public int getPage_count() {
        return page_count;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    public int getStatus() {
        return status;
    }

    public void setTotal_counts(int total_counts) {
        this.total_counts = total_counts;
    }
    public int getTotal_counts() {
        return total_counts;
    }

    @Override
    public String toString() {
        return "TypeResponse{" +
                "data=" + data +
                ", page=" + page +
                ", page_count=" + page_count +
                ", status=" + status +
                ", total_counts=" + total_counts +
                '}';
    }
}