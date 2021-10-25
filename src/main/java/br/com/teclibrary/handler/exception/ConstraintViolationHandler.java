package br.com.teclibrary.handler.exception;

import br.com.teclibrary.model.response.WebExceptionResponse;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.time.LocalDateTime;

@Slf4j
@Provider
public class ConstraintViolationHandler implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(final ConstraintViolationException exception) {
        StringBuilder stringBuilder = new StringBuilder();
        exception.getConstraintViolations().forEach(cv -> {
            String fieldName = cv.getPropertyPath().toString();
            stringBuilder.append(String.format("%s %s.\n", fieldName, cv.getMessage(), System.lineSeparator()));
        });

        WebExceptionResponse webExceptionResponse = WebExceptionResponse.builder()
                .code(Response.Status.BAD_REQUEST.getStatusCode())
                .name(exception.getClass().getName())
                .description(stringBuilder.toString())
                .timestamp(LocalDateTime.now())
                .build();

        return Response.status(Response.Status.BAD_REQUEST)
                .entity(webExceptionResponse)
                .build();
    }
}
