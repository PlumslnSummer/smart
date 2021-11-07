/**
 * Copyright 2021 ab173.com
 */
package com.example.teacherdata.bean;
import java.util.Date;
import java.util.List;

/**
 * Auto-generated: 2021-10-20 18:33:23
 *
 * @author ab173.com (info@ab173.com)
 * @website http://www.ab173.com/json/
 */
public class DataType {

    private String _id;
    private String author;
    private String category;
    private String createdAt;
    private String desc;
    private List<String> images;
    private int likeCounts;
    private Date publishedAt;
    private int stars;
    private String title;
    private String type;
    private String url;
    private int views;
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_id() {
        return _id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public String getAuthor() {
        return author;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    public String getCategory() {
        return category;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    public String getDesc() {
        return desc;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
    public List<String> getImages() {
        return images;
    }

    public void setLikeCounts(int likeCounts) {
        this.likeCounts = likeCounts;
    }
    public int getLikeCounts() {
        return likeCounts;
    }

    public void setPublishedAt(Date publishedAt) {
        this.publishedAt = publishedAt;
    }
    public Date getPublishedAt() {
        return publishedAt;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
    public int getStars() {
        return stars;
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

    public void setUrl(String url) {
        this.url = url;
    }
    public String getUrl() {
        return url;
    }

    public void setViews(int views) {
        this.views = views;
    }
    public int getViews() {
        return views;
    }

    @Override
    public String toString() {
        return "DataType{" +
                "_id='" + _id + '\'' +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", desc='" + desc + '\'' +
                ", images=" + images +
                ", likeCounts=" + likeCounts +
                ", publishedAt=" + publishedAt +
                ", stars=" + stars +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", views=" + views +
                '}';
    }
}