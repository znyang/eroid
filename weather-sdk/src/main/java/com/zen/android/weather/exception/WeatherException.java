package com.zen.android.weather.exception;

/**
 * @author zen
 * @version 2016/3/16
 */
public class WeatherException extends RuntimeException {

    public WeatherException() {
    }

    public WeatherException(String detailMessage) {
        super(detailMessage);
    }

    public WeatherException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public WeatherException(Throwable throwable) {
        super(throwable);
    }
}
