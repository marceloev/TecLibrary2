package br.com.teclibrary.repository;

import br.com.teclibrary.model.data.User;

public interface UserRepository {

    User findById(Long id);

    User findByEmail(String email);

    Long countByEmail(String email);

    User findByActivation(String activation);

    User findByEmailAndActivation(String email, String activation);

    User insert(User user);

    User update(User user);

    void delete(Long id);
}
