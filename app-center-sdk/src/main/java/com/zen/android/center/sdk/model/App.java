package com.zen.android.center.sdk.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * App
 *
 * @author zeny
 * @version 2015.11.04
 */
public class App extends BaseModel {

    @JsonProperty("version")
    private String mVersion;
    @JsonProperty("url")
    private String mUrl;
    @JsonProperty("packageName")
    private String mPackageName;
    @JsonProperty("description")
    private String mDescription;
    @JsonProperty("appName")
    private String mAppName;

    public String getVersion() {
        return mVersion;
    }

    public String getUrl() {
        return mUrl;
    }

    public String getPackageName() {
        return mPackageName;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getAppName() {
        return mAppName;
    }
}
