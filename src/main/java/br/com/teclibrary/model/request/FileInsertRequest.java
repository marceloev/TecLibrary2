package br.com.teclibrary.model.request;

import br.com.teclibrary.model.data.enums.FileType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FileInsertRequest {
    private byte[] data;
    private String name;
    private FileType type;
}
