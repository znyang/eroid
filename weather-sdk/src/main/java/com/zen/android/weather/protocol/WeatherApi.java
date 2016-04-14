package com.zen.android.weather.protocol;

import com.zen.android.weather.model.City;
import com.zen.android.weather.model.CityWeather;
import com.zen.android.weather.model.WeatherDetail;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * @author zen
 * @version 2016/3/10
 */
public interface WeatherApi {

    @GET("/weatherservice/citylist")
    Observable<BaseEntry<List<City>>> getCityList(@Query("cityname") String cityName);

    /**
     * 历史七天天气
     *
     * @param cityName
     * @param cityId
     * @return
     */
    @GET("/weatherservice/recentweathers")
    Observable<BaseEntry<WeatherDetail>> getWeatherDetail(@Query("cityname") String cityName,
                                                          @Query("cityid") String cityId);

    @GET("/weatherservice/cityname")
    Observable<BaseEntry<CityWeather>> getWeatherByName(@Query("cityname") String cityName);

}
