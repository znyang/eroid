package com.zen.android.center.sdk.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginSession extends UserSession {
    @JsonProperty("username")
    private String mUsername;
    @JsonProperty("updatedAt")
    private String mUpdatedAt;

    public String getUsername() {
        return mUsername;
    }

    public String getUpdatedAt() {
        return mUpdatedAt;
    }
}