package com.example.fineweather.model;

/**
 * Created by Administrator on 2016/3/3.
 */
public class Country {
    private int id;
    private String countryName;
    private String countryCode;

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getCountryName(){
        return countryName;
    }
    public void setCountryName(String countryName){
        this.countryName=countryName;

    }
    public String getCountryCode(){
        return countryCode;
    }
    public void setCountryCode(String countryCode){
        this.countryCode=countryCode;
    }
}
