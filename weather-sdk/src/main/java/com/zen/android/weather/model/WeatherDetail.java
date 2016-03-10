package com.zen.android.weather.model;

/**
 * Created by JacksonGenerator on 16-3-10.
 */

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class WeatherDetail {
    @JsonProperty("city")
    private String             city;
    @JsonProperty("today")
    private Today              today;
    @JsonProperty("forecast")
    private List<ForecastItem> forecast;
    @JsonProperty("cityid")
    private String             cityid;
    @JsonProperty("history")
    private List<HistoryItem>  history;

    public String getCity() {
        return city;
    }

    public Today getToday() {
        return today;
    }

    public List<ForecastItem> getForecast() {
        return forecast;
    }

    public String getCityid() {
        return cityid;
    }

    public List<HistoryItem> getHistory() {
        return history;
    }
}