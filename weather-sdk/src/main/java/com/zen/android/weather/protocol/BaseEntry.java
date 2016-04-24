package com.zen.android.weather.protocol;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zen.android.weather.exception.WeatherException;

/**
 * @author zen
 * @version 2016/3/10
 */
public class BaseEntry<T> {

    @JsonProperty("errNum")
    private int    errNum;
    @JsonProperty("errMsg")
    private String errMsg;
    @JsonProperty("retData")
    private T      retData;

    public T getRetData() {
        if (errNum != 0) {
            throw new WeatherException(errMsg);
        }
        return retData;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public int getErrNum() {
        return errNum;
    }
}
