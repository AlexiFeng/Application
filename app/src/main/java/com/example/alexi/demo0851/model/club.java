package com.example.alexi.demo0851.model;

import cn.bmob.v3.BmobObject;

/**
 * Created by alexi on 17-10-26.
 */

public class club extends BmobObject {
    private String tel;
    private String qq;
    private Integer club_size;
    private String club_name;
    private MyUser club_manager;

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public Integer getClub_size() {
        return club_size;
    }

    public void setClub_size(Integer club_size) {
        this.club_size = club_size;
    }

    public String getClub_name() {
        return club_name;
    }

    public void setClub_name(String club_name) {
        this.club_name = club_name;
    }

    public MyUser getClub_manager() {
        return club_manager;
    }

    public void setClub_manager(MyUser club_manager) {
        this.club_manager = club_manager;
    }


}
