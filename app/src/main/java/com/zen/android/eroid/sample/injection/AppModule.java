package com.zen.android.eroid.sample.injection;

import com.zen.android.weather.WeatherClient;
import com.zen.android.weather.protocol.WeatherApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * AppModule
 * <p>
 *
 * @author zeny
 * @version 2015/11/5
 */
@Module
public class AppModule {

    @Provides
    @Singleton
    public WeatherApi provideAppCenterApi() {
        return WeatherClient.getWeatherApi();
    }
//
//    @Provides
//    @Singleton
//    public AppCenter provideAppCenter() {
//        return new AppCenter();
//    }
}
