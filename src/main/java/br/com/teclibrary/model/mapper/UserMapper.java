package br.com.teclibrary.model.mapper;

import br.com.teclibrary.domain.UserEntity;
import br.com.teclibrary.model.data.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

    /**
     * Create a user entity based on a user data
     *
     * @param user {@link User}
     * @return entity saved {@link UserEntity}
     */
    UserEntity toEntity(User user);

    /**
     * Create a user data based on a user entity
     *
     * @param userEntity {@link UserEntity}
     * @return entity data {@link User}
     */
    User fromEntity(UserEntity userEntity);

    /**
     * Create a list of user data based on a list of user entity
     *
     * @param users a list of {@link UserEntity}
     * @return list of {@link User}
     */
    List<User> fromEntity(List<UserEntity> users);
}
