package com.zen.android.center.sdk.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BaseModel {

    @JsonProperty("createdAt")
    private String mCreatedAt;
    @JsonProperty("objectId")
    private String mObjectId;

    public String getCreatedAt() {
        return mCreatedAt;
    }

    public String getObjectId() {
        return mObjectId;
    }
}
