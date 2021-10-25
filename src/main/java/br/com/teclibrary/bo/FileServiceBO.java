package br.com.teclibrary.bo;

import br.com.teclibrary.handler.storage.StorageHandler;
import br.com.teclibrary.model.data.File;
import br.com.teclibrary.model.request.FileInsertRequest;
import br.com.teclibrary.repository.FileRepository;
import io.quarkus.panache.common.Page;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import java.util.List;

@Singleton
public class FileServiceBO {

    @Inject
    FileRepository fileRepository;

    @Inject
    StorageHandler storageHandler;

    public List<File> findAll() {
        return fileRepository.findAll(Page.of(0, 25));
    }

    public File findById(final Long id) {
        return fileRepository.findById(id);
    }

    public byte[] getStoredFile(final Long id) {
        return this.getStoredFile(this.findById(id));
    }

    public byte[] getStoredFile(final File file) {
        return this.getStoredFile(file.getKey());
    }

    public byte[] getStoredFile(final String key) {
        return storageHandler.retrieve(key);
    }

    @Transactional
    public File insert(final FileInsertRequest request) {
        File file = new File(request, storageHandler.getType());
        storageHandler.save(file.getKey(), request.getType(), request.getData());
        return fileRepository.insert(file);
    }

    @Transactional
    public void delete(final Long id) {
        File file = fileRepository.findById(id);
        storageHandler.remove(file.getKey());
        fileRepository.delete(id);
    }
}
