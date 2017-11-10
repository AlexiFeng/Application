package com.example.alexi.demo0851.model;


import java.io.Serializable;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobDate;
import cn.bmob.v3.datatype.BmobFile;

/**
 * Created by alexi on 17-10-26.
 */

public class ZanzhuSJSearch extends BmobObject implements Serializable {
    private String introduction;
    private String time;
    private String require;
    private String provide;
    private String details;
    private String name;
    private BmobFile banner;
    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRequire() {
        return require;
    }

    public void setRequire(String require) {
        this.require = require;
    }

    public String getProvide() {
        return provide;
    }

    public void setProvide(String provide) {
        this.provide = provide;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BmobFile getBanner() {
        return banner;
    }

    public void setBanner(BmobFile banner) {
        this.banner = banner;
    }

}
