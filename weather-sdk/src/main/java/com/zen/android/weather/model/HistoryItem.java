package com.zen.android.weather.model;

/**
 * Created by JacksonGenerator on 16-3-10.
 */

import com.fasterxml.jackson.annotation.JsonProperty;


public class HistoryItem {
    @JsonProperty("date")
    private String date;
    @JsonProperty("week")
    private String week;
    @JsonProperty("fengli")
    private String fengli;
    @JsonProperty("fengxiang")
    private String fengxiang;
    @JsonProperty("lowtemp")
    private String lowtemp;
    @JsonProperty("aqi")
    private String aqi;
    @JsonProperty("type")
    private String type;
    @JsonProperty("hightemp")
    private String hightemp;

    public String getDate() {
        return date;
    }

    public String getWeek() {
        return week;
    }

    public String getFengli() {
        return fengli;
    }

    public String getFengxiang() {
        return fengxiang;
    }

    public String getLowtemp() {
        return lowtemp;
    }

    public String getAqi() {
        return aqi;
    }

    public String getType() {
        return type;
    }

    public String getHightemp() {
        return hightemp;
    }
}