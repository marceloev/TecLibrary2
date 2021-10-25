package br.com.teclibrary.model.exception;

import lombok.Data;

@Data
public class BusinessException extends RuntimeException {
    private final Enum error;
    private final Object[] params;

    public BusinessException(final Enum error, final Object... params) {
        super(error.name());
        this.error = error;
        this.params = params;
    }
}
