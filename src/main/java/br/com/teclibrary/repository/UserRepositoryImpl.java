package br.com.teclibrary.repository;

import br.com.teclibrary.domain.UserEntity;
import br.com.teclibrary.model.data.User;
import br.com.teclibrary.model.mapper.UserMapper;
import br.com.teclibrary.repository.jpa.UserJpaRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class UserRepositoryImpl implements UserRepository {

    @Inject
    UserJpaRepository userJpaRepository;

    @Override
    public User findById(final Long id) {
        return UserMapper.MAPPER.fromEntity(userJpaRepository.findById(id));
    }

    @Override
    public User findByEmail(final String email) {
        return UserMapper.MAPPER.fromEntity(userJpaRepository.findByEmail(email));
    }

    @Override
    public Long countByEmail(final String email) {
        return userJpaRepository.countByEmail(email);
    }

    @Override
    public User findByActivation(final String activation) {
        return UserMapper.MAPPER.fromEntity(userJpaRepository.findByActivation(activation));
    }

    @Override
    public User findByEmailAndActivation(final String email, final String activation) {
        return UserMapper.MAPPER.fromEntity(userJpaRepository.findByEmailAndActivation(email, activation));
    }

    @Override
    public User insert(final User user) {
        UserEntity userEntity = UserMapper.MAPPER.toEntity(user);
        userEntity.persistAndFlush();
        return UserMapper.MAPPER.fromEntity(userEntity);
    }

    @Override
    public User update(final User user) {
        UserEntity userEntity = UserMapper.MAPPER.toEntity(user);
        userJpaRepository.getEntityManager().merge(userEntity);
        return UserMapper.MAPPER.fromEntity(userEntity);
    }

    @Override
    public void delete(final Long id) {
        userJpaRepository.deleteById(id);
    }
}
