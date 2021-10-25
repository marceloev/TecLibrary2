package br.com.teclibrary.handler.util;

import com.cronutils.utils.StringUtils;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JsonUtils {

    /**
     * Convert a object instance to JSON String
     * @param object Instance to convert
     * @return JSON String with content
     */
    public static String toJSON(final Object object) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            JavaTimeModule dateModule = new JavaTimeModule();
            mapper.registerModule(dateModule);
            return mapper.writeValueAsString(object);
        } catch (Exception e) {
            return StringUtils.EMPTY;
        }
    }

    /**
     * Convert JSON String to instance of object <T>
     * @param json {@link String}
     * @param clazz {@link Class<T>}
     * @return T {@link <T>}
     */
    public static <T> T toObject(final String json, final Class<T> clazz) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE);
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.setSerializationInclusion(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL);
            return mapper.readValue(json, clazz);
        } catch (Exception e) {
            return null;
        }
    }
}
