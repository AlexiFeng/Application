package com.example.alexi.demo0851.model;

import cn.bmob.v3.BmobObject;

/**
 * Created by alexi on 17-11-8.
 */

public class Post extends BmobObject {
    private String title;
    private String content;
    private String summary;
    private MyUser author;
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public MyUser getAuthor() {
        return author;
    }

    public void setAuthor(MyUser author) {
        this.author = author;
    }
}
