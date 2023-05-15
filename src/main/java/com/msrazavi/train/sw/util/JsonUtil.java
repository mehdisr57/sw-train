package com.msrazavi.train.sw.util;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author <a href="mailto:mehdisr57@gmail.com">Mehdi.S.Razavi</a>
 */
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
