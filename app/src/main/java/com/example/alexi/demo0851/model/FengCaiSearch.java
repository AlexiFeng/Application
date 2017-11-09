package com.example.alexi.demo0851.model;

import com.example.alexi.demo0851.model.club;

import cn.bmob.v3.datatype.BmobDate;



import java.io.Serializable;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobDate;

/**
 * Created by alexi on 17-10-26.
 */

public class FengCaiSearch extends BmobObject implements Serializable {
    private club fc_club;
    private Integer fc_size;
    private String fc_name;
    private BmobDate fc_date;
    private String fc_location;
    private String tel;
    private String qq;
    private Integer fc_kind;
    public club getFc_club() {
        return fc_club;
    }

    public void setFc_club(club fc_club) {
        this.fc_club = fc_club;
    }

    public Integer getFc_size() {
        return fc_size;
    }

    public void setFc_size(Integer fc_size) {
        this.fc_size = fc_size;
    }

    public String getFc_name() {
        return fc_name;
    }

    public void setFc_name(String fc_name) {
        this.fc_name = fc_name;
    }

    public BmobDate getFc_date() {
        return fc_date;
    }

    public void setFc_date(BmobDate fc_date) {
        this.fc_date = fc_date;
    }

    public String getFc_location() {
        return fc_location;
    }

    public void setFc_location(String fc_location) {
        this.fc_location = fc_location;
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

    public Integer getFc_kind() {
        return fc_kind;
    }

    public void setFc_kind(Integer fc_kind) {
        this.fc_kind = fc_kind;
    }




}
