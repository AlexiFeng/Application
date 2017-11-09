package com.example.alexi.demo0851.model;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

/**
 * Created by alexi on 17-11-8.
 */

public class School extends BmobObject {
    private String name;
    private String place;
    private String information;
    private String tel;
    private BmobFile banner;
    public BmobFile getBanner() {
        return banner;
    }

    public void setBanner(BmobFile banner) {
        this.banner = banner;
    }


    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }


}
