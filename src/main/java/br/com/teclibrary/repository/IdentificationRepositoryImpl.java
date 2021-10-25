package br.com.teclibrary.repository;

import br.com.teclibrary.domain.IdentificationEntity;
import br.com.teclibrary.model.data.Identification;
import br.com.teclibrary.model.data.enums.AppIdentifier;
import br.com.teclibrary.model.mapper.IdentificationMapper;
import br.com.teclibrary.repository.jpa.IdentificationJpaRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class IdentificationRepositoryImpl implements IdentificationRepository {

    @Inject
    IdentificationJpaRepository identificationJpaRepository;

    @Override
    public Identification insert(final Identification identification) {
        IdentificationEntity entity = IdentificationMapper.MAPPER.toEntity(identification);
        entity.persistAndFlush();
        return IdentificationMapper.MAPPER.fromEntity(entity);
    }

    @Override
    public Identification update(Identification identification) {
        IdentificationEntity entity = IdentificationMapper.MAPPER.toEntity(identification);
        entity.persistAndFlush();
        return IdentificationMapper.MAPPER.fromEntity(entity);
    }

    @Override
    public Identification findByUserIdAndAppIdentifier(final Long userId, final AppIdentifier appIdentifier) {
        return IdentificationMapper.MAPPER.fromEntity(identificationJpaRepository.findByUserIdAndAppIdentifier(userId, appIdentifier));
    }
}
