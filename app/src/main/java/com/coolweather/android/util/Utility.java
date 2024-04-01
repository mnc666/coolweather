package com.coolweather.android.util;

import android.text.TextUtils;

import com.coolweather.android.db.City;
import com.coolweather.android.db.County;
import com.coolweather.android.db.Province;

import org.json.JSONArray;
import org.json.JSONObject;

public class Utility {
    //解析和处理服务器的省级数据
    public static boolean handleProvinceRespone(String respone){
        if(!TextUtils.isEmpty(respone)){
            try {
                JSONArray allProvinces = new JSONArray(respone);
                for (int i = 0; i <allProvinces.length() ; i++) {
                    JSONObject provinceObject = allProvinces.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();
                }
                return true;

            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return false;
    }
    public static boolean handleCityRespone(String respone,int provinceId){
        if(!TextUtils.isEmpty(respone)){
            try {
                JSONArray allCities= new JSONArray(respone);
                for (int i = 0; i <allCities.length() ; i++) {
                    JSONObject cityObject = allCities.getJSONObject(i);
                   City city = new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCitycode(cityObject.getInt("id"));
                   city.save();
                }
                return true;

            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return false;
    }
    public static boolean handleCountyRespone(String respone,int cityId){
        if(!TextUtils.isEmpty(respone)){
            try {
                JSONArray allCounties = new JSONArray(respone);
                for (int i = 0; i <allCounties.length() ; i++) {
                    JSONObject countyObject = allCounties.getJSONObject(i);
                    County county = new County();
                    county.setCountyName(countyObject.getString("name"));
                    county.setWeatherId(countyObject.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                }
                return true;

            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return false;
    }
}
