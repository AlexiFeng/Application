package com.example.alexi.demo0851.model;

import cn.bmob.v3.BmobObject;

/**
 * Created by alexi on 17-11-8.
 */

public class Comment extends BmobObject {
    private String content;
    private Post post;
    private MyUser author;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public MyUser getAuthor() {
        return author;
    }

    public void setAuthor(MyUser author) {
        this.author = author;
    }

}
