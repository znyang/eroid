package com.zen.android.eroid.data;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * ObjectMapperFactory
 *
 * @author zeny
 * @version 2015.10.26
 */
public class ObjectMapperFactory {

    private static final ObjectMapper OBJECT_MAPPER = createDefaultObjectMapper();

    public static ObjectMapper createDefaultObjectMapper() {
        return new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
    }

    public static ObjectMapper getDefault() {
        return OBJECT_MAPPER;
    }

}
