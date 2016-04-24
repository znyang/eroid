package com.zen.android.weather.model;

/**
 * Created by JacksonGenerator on 16-3-10.
 */

import com.fasterxml.jackson.annotation.JsonProperty;


public class CityWeather {
    @JsonProperty("date")
    private String date;
    @JsonProperty("altitude")
    private String altitude;
    @JsonProperty("temp")
    private String temp;
    @JsonProperty("sunrise")
    private String sunrise;
    @JsonProperty("city")
    private String city;
    @JsonProperty("h_tmp")
    private String hTmp;
    @JsonProperty("latitude")
    private Double latitude;
    @JsonProperty("WD")
    private String wD;
    @JsonProperty("pinyin")
    private String pinyin;
    @JsonProperty("citycode")
    private String citycode;
    @JsonProperty("sunset")
    private String sunset;
    @JsonProperty("weather")
    private String weather;
    @JsonProperty("postCode")
    private String postCode;
    @JsonProperty("l_tmp")
    private String lTmp;
    @JsonProperty("time")
    private String time;
    @JsonProperty("WS")
    private String wS;
    @JsonProperty("longitude")
    private Double longitude;

    public String getDate() {
        return date;
    }

    public String getAltitude() {
        return altitude;
    }

    public String getTemp() {
        return temp;
    }

    public String getSunrise() {
        return sunrise;
    }

    public String getCity() {
        return city;
    }

    public String gethTmp() {
        return hTmp;
    }

    public Double getLatitude() {
        return latitude;
    }

    public String getwD() {
        return wD;
    }

    public String getPinyin() {
        return pinyin;
    }

    public String getCitycode() {
        return citycode;
    }

    public String getSunset() {
        return sunset;
    }

    public String getWeather() {
        return weather;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getlTmp() {
        return lTmp;
    }

    public String getTime() {
        return time;
    }

    public String getwS() {
        return wS;
    }

    public Double getLongitude() {
        return longitude;
    }
}