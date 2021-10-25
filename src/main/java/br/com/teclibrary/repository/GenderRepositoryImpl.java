package br.com.teclibrary.repository;

import br.com.teclibrary.domain.GenderEntity;
import br.com.teclibrary.model.data.Gender;
import br.com.teclibrary.model.mapper.GenderMapper;
import br.com.teclibrary.repository.jpa.GenderJpaRepository;
import io.quarkus.panache.common.Page;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class GenderRepositoryImpl implements GenderRepository {

    @Inject
    GenderJpaRepository genderJpaRepository;

    @Override
    public Gender findById(final Long id) {
        return GenderMapper.MAPPER.fromEntity(genderJpaRepository.findById(id));
    }

    @Override
    public Gender insert(final Gender gender) {
        GenderEntity genderEntity = GenderMapper.MAPPER.toEntity(gender);
        genderJpaRepository.persistAndFlush(genderEntity);
        return GenderMapper.MAPPER.fromEntity(genderEntity);
    }

    @Override
    public Gender update(final Gender gender) {
        GenderEntity genderEntity = GenderMapper.MAPPER.toEntity(gender);
        genderJpaRepository.persistAndFlush(genderEntity);
        return GenderMapper.MAPPER.fromEntity(genderEntity);
    }

    @Override
    public List<Gender> findAll(final Page page) {
        return GenderMapper.MAPPER.fromEntity(genderJpaRepository.listAll());
    }

    @Override
    public void delete(final Long id) {
        genderJpaRepository.deleteById(id);
    }
}
