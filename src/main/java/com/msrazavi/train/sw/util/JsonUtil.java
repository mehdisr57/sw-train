package com.msrazavi.train.sw.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public final class JsonUtil {

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    private JsonUtil() {
    }
}
