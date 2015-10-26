package com.zen.android.center.sdk.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorEntry {
    @JsonProperty("code")
    private Integer code;
    @JsonProperty("error")
    private String  error;

    public Integer getCode() {
        return code;
    }

    public String getError() {
        return error;
    }
}