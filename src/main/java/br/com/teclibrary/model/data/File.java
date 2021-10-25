package br.com.teclibrary.model.data;

import br.com.teclibrary.model.data.enums.FileType;
import br.com.teclibrary.model.data.enums.StorageType;
import br.com.teclibrary.model.request.FileInsertRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class File {

    private Long id;
    @JsonIgnore
    private String key;
    @JsonIgnore
    private FileType type;
    @JsonIgnore
    private StorageType storage;

    public File(final FileInsertRequest request, final StorageType storageType) {
        this.key = UUID.randomUUID().toString();
        this.type = request.getType();
        this.storage = storageType;
    }

}
