package com.zen.android.center.sdk.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserSession extends BaseModel {
    @JsonProperty("sessionToken")
    private String mSessionToken;

    public String getSessionToken() {
        return mSessionToken;
    }
}