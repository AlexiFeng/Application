package com.example.alexi.demo0851.model;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobFile;

/**
 * Created by alexi on 17-10-25.
 */

public class MyUser extends BmobUser {
    private Boolean sex;
    private String nick;
    private Integer age;
    private Integer status;
    private club club_belong;
    private BmobFile icon;
    /*
    * 0:Admin
    * 1:Manager
    * 2.Student
    * 3.Society
    * */
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public club getClub_belong() {
        return club_belong;
    }

    public void setClub_belong(club club_belong) {
        this.club_belong = club_belong;
    }


    public BmobFile getIcon() {
        return icon;
    }

    public void setIcon(BmobFile icon) {
        this.icon = icon;
    }


}
