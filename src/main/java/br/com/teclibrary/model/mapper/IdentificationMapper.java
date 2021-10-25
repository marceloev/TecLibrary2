package br.com.teclibrary.model.mapper;

import br.com.teclibrary.domain.IdentificationEntity;
import br.com.teclibrary.model.data.Identification;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IdentificationMapper {

    IdentificationMapper MAPPER = Mappers.getMapper(IdentificationMapper.class);

    /**
     * Create a identification entity based on a identification data
     *
     * @param identification {@link Identification}
     * @return entity saved {@link IdentificationEntity}
     */
    IdentificationEntity toEntity(Identification identification);

    /**
     * Create a identification data based on a identification entity
     *
     * @param identificationEntity {@link IdentificationEntity}
     * @return entity data {@link Identification}
     */
    Identification fromEntity(IdentificationEntity identificationEntity);
}
