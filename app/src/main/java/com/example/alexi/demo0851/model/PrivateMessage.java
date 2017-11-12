package com.example.alexi.demo0851.model;

import cn.bmob.v3.BmobObject;

/**
 * Created by alexi on 17-11-10.
 */

public class PrivateMessage extends BmobObject {
    private MyUser from;
    private MyUser to;
    private String content;

    public MyUser getFrom() {
        return from;
    }

    public void setFrom(MyUser from) {
        this.from = from;
    }

    public MyUser getTo() {
        return to;
    }

    public void setTo(MyUser to) {
        this.to = to;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
