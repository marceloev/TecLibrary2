package br.com.teclibrary.controller;

import br.com.teclibrary.bo.BookServiceBO;
import br.com.teclibrary.model.data.Book;
import br.com.teclibrary.model.request.BookInsertRequest;
import br.com.teclibrary.model.request.BookUpdateRequest;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.DELETE;
import javax.ws.rs.PathParam;
import java.util.List;

@Path("/book")
public class BookController {

    @Inject
    BookServiceBO bookServiceBO;

    @GET
    @PermitAll
    public List<Book> findAll() {
        return bookServiceBO.findAll();
    }

    @GET
    @Path("/suggestion/{id}")
    @PermitAll
    public List<Book> findLookALike(@Valid @NotNull @PathParam("id") final Long id) {
        return bookServiceBO.findSuggestion(id);
    }

    @POST
    @RolesAllowed("EMPLOYEE")
    public Book insert(@Valid @NotNull final BookInsertRequest request) {
        return bookServiceBO.insert(request);
    }

    @PUT
    @RolesAllowed("EMPLOYEE")
    public Book save(@Valid @NotNull final BookUpdateRequest request) {
        return bookServiceBO.save(request);
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed("MANAGER")
    public void delete(@NotNull @PathParam("id") final Long id) {
        bookServiceBO.delete(id);
    }
}
