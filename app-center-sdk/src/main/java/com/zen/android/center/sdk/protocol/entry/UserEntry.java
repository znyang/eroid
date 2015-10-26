package com.zen.android.center.sdk.protocol.entry;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class UserEntry implements Serializable {

    @JsonProperty("username")
    private String username;
    @JsonProperty("password")
    private String password;

    public UserEntry(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
