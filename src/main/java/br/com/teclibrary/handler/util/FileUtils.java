package br.com.teclibrary.handler.util;

import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class FileUtils {

    private static final String RESOURCE_PATH = "/META-INF/resources/";

    public static String getFileAsStringFromResource(String path) {
        try {
            InputStream inputStream = FileUtils.class.getResourceAsStream(RESOURCE_PATH.concat(path));
            return IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
