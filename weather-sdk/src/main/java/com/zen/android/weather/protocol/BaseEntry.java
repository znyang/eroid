package com.zen.android.weather.protocol;

import com.fasterxml.jackson.annotation.JsonProperty;

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
        return retData;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public int getErrNum() {
        return errNum;
    }
}
