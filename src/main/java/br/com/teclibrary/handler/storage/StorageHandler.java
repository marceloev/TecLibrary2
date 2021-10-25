package br.com.teclibrary.handler.storage;

import br.com.teclibrary.model.data.enums.FileType;
import br.com.teclibrary.model.data.enums.StorageType;

public interface StorageHandler {
    StorageType getType();

    byte[] retrieve(String key);

    byte[] save(String key, FileType type, byte[] data);

    byte[] update(String key, FileType type, byte[] data);

    void remove(String key);
}
