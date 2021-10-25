package br.com.teclibrary.repository;

import br.com.teclibrary.model.data.Identification;
import br.com.teclibrary.model.data.enums.AppIdentifier;

public interface IdentificationRepository {
    Identification insert(Identification identification);
    Identification update(Identification identification);
    Identification findByUserIdAndAppIdentifier(Long userId, AppIdentifier appIdentifier);
}
