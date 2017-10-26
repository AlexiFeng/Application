package com.example.alexi.demo0851.model;


import cn.bmob.v3.BmobObject;

/**
 * Created by alexi on 17-10-26.
 */

public class ZanzhuSearch extends BmobObject {
    private Club ac_club;
    private String ac_size;
    private String ac_provide;
    private String ac_need;
    private String ac_name;
    private String ac_date;
    private String ac_loaction;
    private String tel;
    private String qq;
    public Club getAc_club() {
        return ac_club;
    }

    public void setAc_club(Club ac_club) {
        this.ac_club = ac_club;
    }

    public String getAc_size() {
        return ac_size;
    }

    public void setAc_size(String ac_size) {
        this.ac_size = ac_size;
    }

    public String getAc_provide() {
        return ac_provide;
    }

    public void setAc_provide(String ac_provide) {
        this.ac_provide = ac_provide;
    }

    public String getAc_need() {
        return ac_need;
    }

    public void setAc_need(String ac_need) {
        this.ac_need = ac_need;
    }

    public String getAc_name() {
        return ac_name;
    }

    public void setAc_name(String ac_name) {
        this.ac_name = ac_name;
    }

    public String getAc_date() {
        return ac_date;
    }

    public void setAc_date(String ac_date) {
        this.ac_date = ac_date;
    }

    public String getAc_loaction() {
        return ac_loaction;
    }

    public void setAc_loaction(String ac_loaction) {
        this.ac_loaction = ac_loaction;
    }

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


}
