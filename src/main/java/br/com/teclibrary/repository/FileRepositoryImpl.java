package br.com.teclibrary.repository;

import br.com.teclibrary.domain.FileEntity;
import br.com.teclibrary.model.data.File;
import br.com.teclibrary.model.mapper.FileMapper;
import br.com.teclibrary.repository.jpa.FileJpaRepository;
import io.quarkus.panache.common.Page;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class FileRepositoryImpl implements FileRepository {

    @Inject
    FileJpaRepository fileJpaRepository;

    @Override
    public List<File> findAll(final Page page) {
        return FileMapper.MAPPER.fromEntity(fileJpaRepository.listAll());
    }

    @Override
    public File findById(final Long id) {
        return FileMapper.MAPPER.fromEntity(fileJpaRepository.findById(id));
    }

    @Override
    public File insert(final File file) {
        FileEntity fileEntity = FileMapper.MAPPER.toEntity(file);
        fileJpaRepository.persistAndFlush(fileEntity);
        return FileMapper.MAPPER.fromEntity(fileEntity);
    }

    @Override
    public File update(final File file) {
        FileEntity fileEntity = FileMapper.MAPPER.toEntity(file);
        fileJpaRepository.persistAndFlush(fileEntity);
        return FileMapper.MAPPER.fromEntity(fileEntity);
    }

    @Override
    public void delete(final Long id) {
        fileJpaRepository.deleteById(id);
    }
}
