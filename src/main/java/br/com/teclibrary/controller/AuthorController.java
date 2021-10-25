package br.com.teclibrary.controller;

import br.com.teclibrary.bo.AuthorServiceBO;
import br.com.teclibrary.model.data.Author;
import br.com.teclibrary.model.request.AuthorInsertRequest;
import br.com.teclibrary.model.request.AuthorUpdateRequest;
import io.quarkus.panache.common.Page;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

@Path("/author")
public class AuthorController {

    @Inject
    AuthorServiceBO authorServiceBO;

    @GET
    @PermitAll
    public List<Author> findAll() {
        return authorServiceBO.findAll(Page.of(0, 25));
    }

    @POST
    @RolesAllowed("EMPLOYEE")
    public Author insert(@Valid @NotNull final AuthorInsertRequest request) {
        return authorServiceBO.insert(request);
    }

    @PUT
    @RolesAllowed("EMPLOYEE")
    public Author update(@Valid @NotNull final AuthorUpdateRequest request) {
        return authorServiceBO.update(request);
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed("MANAGER")
    public void delete(@Valid @NotNull @PathParam("id") final Long id) {
        authorServiceBO.delete(id);
    }
}
