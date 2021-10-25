package br.com.teclibrary.model.mapper;

import br.com.teclibrary.domain.BookEntity;
import br.com.teclibrary.model.data.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BookMapper {

    BookMapper MAPPER = Mappers.getMapper(BookMapper.class);

    /**
     * Create a book entity based on a book data
     *
     * @param book {@link Book}
     * @return entity saved {@link BookEntity}
     */
    BookEntity toEntity(Book book);

    /**
     * Create a book data based on a book entity
     *
     * @param bookEntity {@link BookEntity}
     * @return entity data {@link Book}
     */
    Book fromEntity(BookEntity bookEntity);

    /**
     * Create a list of book data based on a list of book entity
     *
     * @param bookEntities a list of {@link BookEntity}
     * @return list of {@link Book}
     */
    List<Book> fromEntity(List<BookEntity> bookEntities);
}
