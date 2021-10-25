package br.com.teclibrary.handler.exception;

import br.com.teclibrary.handler.message.MessageBrokerHandler;
import br.com.teclibrary.model.exception.BusinessException;
import br.com.teclibrary.model.response.WebExceptionResponse;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.time.LocalDateTime;

@Slf4j
@Provider
public class BusinessExceptionHandler implements ExceptionMapper<BusinessException> {

    @Inject
    MessageBrokerHandler messageBrokerHandler;

    @Override
    public Response toResponse(final BusinessException exception) {
        WebExceptionResponse exceptionResponse = WebExceptionResponse.builder()
                .name(exception.getMessage())
                .code(Response.Status.BAD_REQUEST.getStatusCode())
                .description(messageBrokerHandler.translate(exception))
                .timestamp(LocalDateTime.now())
                .build();

        return Response.status(Response.Status.BAD_REQUEST)
                .entity(exceptionResponse)
                .build();
    }
}
