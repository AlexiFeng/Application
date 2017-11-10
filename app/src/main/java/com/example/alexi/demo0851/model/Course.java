package com.example.alexi.demo0851.model;

import cn.bmob.v3.BmobObject;

/**
 * Created by alexi on 17-11-8.
 */

public class Course extends BmobObject {
    private String name;
    private String time;
    private Integer price;
    private String school;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

}
