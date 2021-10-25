package br.com.teclibrary.bo;

import br.com.teclibrary.repository.PublisherRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class PublisherServiceBO {

    @Inject
    PublisherRepository publisherRepository;
}
