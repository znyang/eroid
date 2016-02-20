package com.zen.android.center.sdk.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * App
 *
 * @author zeny
 * @version 2015.11.04
 */
public class App {

    @JsonProperty("version")
    private String version;
    @JsonProperty("url")
    private String url;
    @JsonProperty("packageName")
    private String packageName;
    @JsonProperty("description")
    private String description;
    @JsonProperty("appName")
    private String appName;
    @JsonProperty("createdAt")
    private String createdAt;
    @JsonProperty("objectId")
    private String objectId;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }
}
