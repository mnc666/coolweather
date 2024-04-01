package com.coolweather.android.db;

import org.litepal.crud.LitePalSupport;

public class City extends LitePalSupport {
    private int id;
    private String cityName;
    private int citycode;
    private int provinceId;

    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    private String getCityName(){
        return cityName;
    }
    public int getCitycode(){
        return citycode;
    }

    public void setCitycode(int citycode) {
        this.citycode = citycode;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }
}
