package br.com.teclibrary.handler.util;

import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    public static final boolean isEmpty(final CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    public static final boolean isNotEmpty(final CharSequence cs) {
        return !isEmpty(cs);
    }

    public static final String buildOf(final byte[] value) {
        return Objects.nonNull(value) ? new String(value, StandardCharsets.UTF_8) : null;
    }

    public static final void replaceAll(final StringBuilder sb, String find, String replace) {
        Pattern p = Pattern.compile(find);
        Matcher m = p.matcher(sb);
        while (m.find()) {
            sb.replace(m.start(), m.end(), replace);
        }
    }
}
