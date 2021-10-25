package br.com.teclibrary.model.mapper;

import br.com.teclibrary.domain.AuthorEntity;
import br.com.teclibrary.model.data.Author;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AuthorMapper {

    AuthorMapper MAPPER = Mappers.getMapper(AuthorMapper.class);

    /**
     * Create a author entity based on a author data
     *
     * @param author {@link Author}
     * @return entity saved {@link AuthorEntity}
     */
    AuthorEntity toEntity(Author author);

    /**
     * Create a author data based on a author entity
     *
     * @param authorEntity {@link AuthorEntity}
     * @return entity data {@link Author}
     */
    Author fromEntity(AuthorEntity authorEntity);

    /**
     * Create a list of author data based on a list of author entity
     *
     * @param authorEntities a list of {@link AuthorEntity}
     * @return list of {@link Author}
     */
    List<Author> fromEntity(List<AuthorEntity> authorEntities);
}
