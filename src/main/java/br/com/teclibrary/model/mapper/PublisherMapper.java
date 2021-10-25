package br.com.teclibrary.model.mapper;

import br.com.teclibrary.domain.PublisherEntity;
import br.com.teclibrary.model.data.Publisher;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PublisherMapper {

    PublisherMapper MAPPER = Mappers.getMapper(PublisherMapper.class);

    /**
     * Create a publisher entity based on a publisher data
     *
     * @param publisher {@link Publisher}
     * @return entity saved {@link PublisherEntity}
     */
    PublisherEntity toEntity(Publisher publisher);

    /**
     * Create a publisher data based on a publisher entity
     *
     * @param publisherEntity {@link PublisherEntity}
     * @return entity data {@link Publisher}
     */
    Publisher fromEntity(PublisherEntity publisherEntity);

    /**
     * Create a list of publisher data based on a list of publisher entity
     *
     * @param publishers a list of {@link PublisherEntity}
     * @return list of {@link Publisher}
     */
    List<Publisher> fromEntity(List<PublisherEntity> publishers);
}
