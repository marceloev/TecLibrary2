package br.com.teclibrary.model.data.enums;

import br.com.teclibrary.handler.util.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum FileType {
    PDF("pdf"),
    JPEG("jpeg");

    @Getter
    private final String value;

    public static FileType buildOf(final String value) {
        if (StringUtils.isNotEmpty(value)) {
            switch (value) {
                case "jpeg":
                case "image/jpeg":
                    return JPEG;
                case "pdf":
                case "application/pdf":
                    return PDF;
                default:
                    return null;
            }
        }

        return null;
    }
}
