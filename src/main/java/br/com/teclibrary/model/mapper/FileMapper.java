package br.com.teclibrary.model.mapper;

import br.com.teclibrary.domain.FileEntity;
import br.com.teclibrary.model.data.File;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface FileMapper {

    FileMapper MAPPER = Mappers.getMapper(FileMapper.class);

    /**
     * Create a file entity based on a file data
     *
     * @param file {@link File}
     * @return entity saved {@link FileEntity}
     */
    FileEntity toEntity(File file);

    /**
     * Create a file data based on a file entity
     *
     * @param fileEntity {@link FileEntity}
     * @return entity data {@link File}
     */
    File fromEntity(FileEntity fileEntity);

    /**
     * Create a list of file data based on a list of file entity
     *
     * @param fileEntity list of {@link FileEntity}
     * @return list of {@link File}
     */
    List<File> fromEntity(List<FileEntity> fileEntity);
}
