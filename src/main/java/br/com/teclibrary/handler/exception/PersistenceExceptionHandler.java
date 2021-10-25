package br.com.teclibrary.handler.exception;

import br.com.teclibrary.model.response.WebExceptionResponse;

import javax.persistence.PersistenceException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDateTime;

@Provider
public class PersistenceExceptionHandler implements ExceptionMapper<PersistenceException> {

    @Override
    public Response toResponse(final PersistenceException exception) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        exception.printStackTrace(pw);

        WebExceptionResponse webExceptionResponse = WebExceptionResponse.builder()
                .code(Response.Status.BAD_REQUEST.getStatusCode())
                .name(exception.getClass().getName())
                .description(exception.getMessage())
                .timestamp(LocalDateTime.now())
                .stack(sw.toString())
                .build();

        return Response.status(Response.Status.BAD_REQUEST)
                .entity(webExceptionResponse)
                .build();
    }
}
