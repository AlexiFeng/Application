package com.example.alexi.demo0851.model;


import java.io.Serializable;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobDate;

/**
 * Created by alexi on 17-10-26.
 */

public class ZanzhuSearch extends BmobObject implements Serializable {
    private club ac_club;
    private Integer ac_size;
    private String ac_provide;
    private String ac_need;
    private String ac_name;
    private BmobDate ac_date;
    private String ac_location;
    private String tel;
    private String qq;
    private Integer ac_kind;
    private Integer verifying;
    private String reason;
    private String other;
    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }



    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
    public Integer getVerifying() {
        return verifying;
    }

    public void setVerifying(Integer verifying) {
        this.verifying = verifying;
    }


    public club getAc_club() {
        return ac_club;
    }

    public void setAc_club(club ac_club) {
        this.ac_club = ac_club;
    }

    public Integer getAc_size() {
        return ac_size;
    }

    public void setAc_size(Integer ac_size) {
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

    public BmobDate getAc_date() {
        return ac_date;
    }

    public void setAc_date(BmobDate ac_date) {
        this.ac_date = ac_date;
    }

    public String getAc_location() {
        return ac_location;
    }

    public void setAc_location(String ac_location) {
        this.ac_location = ac_location;
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

    public Integer getAc_kind() {
        return ac_kind;
    }

    public void setAc_kind(Integer ac_kind) {
        this.ac_kind = ac_kind;
    }
}
