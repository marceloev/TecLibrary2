package br.com.teclibrary.bo;

import br.com.teclibrary.model.data.Gender;
import br.com.teclibrary.model.request.GenderInsertRequest;
import br.com.teclibrary.model.request.GenderUpdateRequest;
import br.com.teclibrary.repository.GenderRepository;
import io.quarkus.panache.common.Page;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import java.util.List;

@Singleton
public class GenderServiceBO {

    @Inject
    GenderRepository genderRepository;

    public List<Gender> findAll() {
        return genderRepository.findAll(Page.of(0, 25));
    }

    @Transactional
    public Gender insert(final GenderInsertRequest request) {
        Gender gender = new Gender(request);
        return genderRepository.insert(gender);
    }

    @Transactional
    public Gender update(final GenderUpdateRequest request) {
        Gender gender = genderRepository.findById(request.getId());
        gender.update(request);
        return genderRepository.update(gender);
    }

    @Transactional
    public void delete(final Long id) {
        genderRepository.delete(id);
    }


}
