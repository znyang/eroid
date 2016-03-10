package com.zen.android.weather.model;

/**
 * Created by JacksonGenerator on 16-3-10.
 */

import com.fasterxml.jackson.annotation.JsonProperty;


public class IndexItem {
    @JsonProperty("code")
    private String code;
    @JsonProperty("name")
    private String name;
    @JsonProperty("index")
    private String index;
    @JsonProperty("details")
    private String details;
    @JsonProperty("otherName")
    private String otherName;

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getIndex() {
        return index;
    }

    public String getDetails() {
        return details;
    }

    public String getOtherName() {
        return otherName;
    }
}