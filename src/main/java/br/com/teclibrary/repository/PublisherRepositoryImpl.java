package br.com.teclibrary.repository;

import br.com.teclibrary.domain.PublisherEntity;
import br.com.teclibrary.model.data.Publisher;
import br.com.teclibrary.model.mapper.PublisherMapper;
import br.com.teclibrary.repository.jpa.PublisherJpaRepository;
import io.quarkus.panache.common.Page;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class PublisherRepositoryImpl implements PublisherRepository {

    @Inject
    PublisherJpaRepository publisherJpaRepository;

    @Override
    public Publisher findById(final Long id) {
        return PublisherMapper.MAPPER.fromEntity(publisherJpaRepository.findById(id));
    }

    @Override
    public List<Publisher> findAll(final Page page) {
        return PublisherMapper.MAPPER.fromEntity(publisherJpaRepository.listAll());
    }

    @Override
    public Publisher insert(final Publisher publisher) {
        PublisherEntity entity = PublisherMapper.MAPPER.toEntity(publisher);
        publisherJpaRepository.persistAndFlush(entity);
        return PublisherMapper.MAPPER.fromEntity(entity);
    }

    @Override
    public Publisher update(final Publisher publisher) {
        PublisherEntity entity = PublisherMapper.MAPPER.toEntity(publisher);
        publisherJpaRepository.persistAndFlush(entity);
        return PublisherMapper.MAPPER.fromEntity(entity);
    }

    @Override
    public void delete(final Long id) {
        publisherJpaRepository.deleteById(id);
    }
}
