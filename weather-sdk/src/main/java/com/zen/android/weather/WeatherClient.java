package com.zen.android.weather;

import com.zen.android.weather.protocol.WeatherApi;


import retrofit.RestAdapter;
import retrofit.converter.JacksonConverter;

/**
 * @author zen
 * @version 2016/3/10
 */
public class WeatherClient {

    private static WeatherApi sWeatherApi = createWeatherServer();

    private static WeatherApi createWeatherServer() {
        return new RestAdapter.Builder()
                .setEndpoint("http://apis.baidu.com/apistore/")
                .setConverter(new JacksonConverter())
                .build()
                .create(WeatherApi.class);
    }

    public static WeatherApi getWeatherApi() {
        return sWeatherApi;
    }

}
