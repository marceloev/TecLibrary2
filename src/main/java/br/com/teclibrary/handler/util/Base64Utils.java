package br.com.teclibrary.handler.util;

import br.com.teclibrary.model.data.enums.FileType;
import br.com.teclibrary.model.response.FileUnwrapResponse;

import java.util.Base64;

public class Base64Utils {

    public static final FileUnwrapResponse unwrap(final String base64) {
        if (StringUtils.isNotEmpty(base64)) {
            int fileTypeInitIndex = base64.indexOf(":") + 1;
            int fileTypeEndIndex = base64.indexOf(";");
            FileType fileType = FileType.buildOf(base64.substring(fileTypeInitIndex, fileTypeEndIndex));

            int contentInitIndex = base64.indexOf(",") + 1;
            String content = base64.substring(contentInitIndex);

            return FileUnwrapResponse.builder()
                    .fileType(fileType)
                    .content(Base64.getDecoder().decode(content))
                    .build();
        }

        return null;
    }
}
