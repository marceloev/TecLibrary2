package br.com.teclibrary.model.response;

import br.com.teclibrary.model.data.enums.FileType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FileUnwrapResponse {
    private FileType fileType;
    private byte[] content;
}

