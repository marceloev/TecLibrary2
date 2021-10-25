package br.com.teclibrary.model.mapper;

import br.com.teclibrary.domain.GenderEntity;
import br.com.teclibrary.model.data.Gender;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface GenderMapper {

    GenderMapper MAPPER = Mappers.getMapper(GenderMapper.class);

    /**
     * Create a gender entity based on a gender data
     *
     * @param gender {@link Gender}
     * @return entity saved {@link GenderEntity}
     */
    GenderEntity toEntity(Gender gender);

    /**
     * Create a gender data based on a gender entity
     *
     * @param genderEntity {@link GenderEntity}
     * @return entity data {@link Gender}
     */
    Gender fromEntity(GenderEntity genderEntity);

    /**
     * Create a list of gender data based on a list of gender entity
     *
     * @param genders a list of {@link GenderEntity}
     * @return list of {@link Gender}
     */
    List<Gender> fromEntity(List<GenderEntity> genders);
}
