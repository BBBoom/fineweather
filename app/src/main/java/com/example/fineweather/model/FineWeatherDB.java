package com.example.fineweather.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.fineweather.db.FineWeatherOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/3/3.
 */
public class FineWeatherDB {
    /**
     * 数据库名称
     */
    public static final String DB_NAME="fine_weather";
    /**
     * 数据库版本
     */
    public static final int VERSION=1;
    private static FineWeatherDB fineWeatherDB;
    private SQLiteDatabase db;
    /**
     * 将构造方法私有化
     */
    private FineWeatherDB(Context context){
        FineWeatherOpenHelper dbHelper = new FineWeatherOpenHelper(context,DB_NAME,null,VERSION);
        db=dbHelper.getWritableDatabase();
    }
    /**
     * 获取FineWeatherDB实例
     */
    public synchronized static FineWeatherDB getInstance(Context context){
        if (fineWeatherDB!=null){
            fineWeatherDB = new FineWeatherDB(context);
        }
        return fineWeatherDB;
    }
    /**
     * 将Province实例存储到数据库
     */
    public void saveProvince(Province province){
        if(province !=null){
            ContentValues values = new ContentValues();
            values.put("province_name",province.getProvinceName());
            values.put("province_code",province.getProvinceCode());
            db.insert("Province",null,values);
        }
    }
    /**
     * 从数据库读取全国所有的省份信息
     */
    public List<Province> loadProvinces(){
        List<Province> list = new ArrayList<Province>();
        Cursor cursor = db
                .query("Province",null,null,null,null,null,null);
        if (cursor.moveToFirst()){
            do{
                Province province= new Province();
                province.setId(cursor.getInt(cursor.getColumnIndex("id")));
                province.setProvinceName(cursor.getString(cursor.getColumnIndex("province_name")));
                province.setProvinceCode(cursor.getString(cursor.getColumnIndex("province_code")));
                list.add(province);
            }while (cursor.moveToNext());
        }
        if (cursor!=null){
            cursor.close();
        }
        return list;
    }
    /**
     * 将city实例存储到数据库
     */
    public void saveCity(City city){
        if(city !=null){
            ContentValues values = new ContentValues();
            values.put("city_name",city.getCityName());
            values.put("city_code",city.getCityCode());
            db.insert("City", null, values);
        }
    }
    /**
     * 从数据库读取全国所有的城市信息
     */
    public List<City> loadCities(){
        List<City> list = new ArrayList<City>();
        Cursor cursor = db
                .query("City",null,null,null,null,null,null);
        if (cursor.moveToFirst()){
            do{
                City City= new City();
                City.setId(cursor.getInt(cursor.getColumnIndex("id")));
                City.setCityName(cursor.getString(cursor.getColumnIndex("city_name")));
                City.setCityCode(cursor.getString(cursor.getColumnIndex("city_code")));
                list.add(City);
            }while (cursor.moveToNext());
        }
        if (cursor!=null){
            cursor.close();
        }
        return list;
    }
    /**
     * 将country实例存储到数据库
     */
    public void saveCountry(Country country){
        if(country !=null){
            ContentValues values = new ContentValues();
            values.put("country_name",country.getCountryName());
            values.put("country_code",country.getCountryCode());
            db.insert("Country", null, values);
        }
    }
    /**
     * 从数据库读取全国所有的县信息
     */
    public List<Country> loadCountries(){
        List<Country> list = new ArrayList<Country>();
        Cursor cursor = db
                .query("Country", null, null, null, null, null, null);
        if (cursor.moveToFirst()){
            do{
                Country Country= new Country();
                Country.setId(cursor.getInt(cursor.getColumnIndex("id")));
                Country.setCountryName(cursor.getString(cursor.getColumnIndex("country_name")));
                Country.setCountryCode(cursor.getString(cursor.getColumnIndex("country_code")));
                list.add(Country);
            }while (cursor.moveToNext());
        }
        if (cursor!=null){
            cursor.close();
        }
        return list;
    }
}


