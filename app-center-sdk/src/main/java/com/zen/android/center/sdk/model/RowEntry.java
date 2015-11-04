package com.zen.android.center.sdk.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * RowEntry
 *
 * @author zeny
 * @version 2015.11.04
 */
public class RowEntry<T> {

    @JsonProperty("results")
    private List<T> results;

    public List<T> getResults() {
        return results;
    }
}
