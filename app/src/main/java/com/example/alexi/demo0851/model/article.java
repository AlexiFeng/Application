package com.example.alexi.demo0851.model;

import cn.bmob.v3.datatype.BmobDate;

/**
 * Created by alexi on 17-10-24.
 */

public class article {
    private String title;
    private String article;

    public BmobDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(BmobDate createdAt) {
        this.createdAt = createdAt;
    }

    private BmobDate createdAt;
    public String getTitle() {
        return title;
    }
    public String getArticle() {
        return article;
        //其他方法，见上面的代码
    }
}
