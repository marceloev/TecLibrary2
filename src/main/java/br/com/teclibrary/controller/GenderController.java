package br.com.teclibrary.controller;

import br.com.teclibrary.bo.GenderServiceBO;
import br.com.teclibrary.model.data.Gender;
import br.com.teclibrary.model.request.GenderInsertRequest;
import br.com.teclibrary.model.request.GenderUpdateRequest;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import java.util.List;

@Path("/gender")
public class GenderController {

    @Inject
    GenderServiceBO genderServiceBO;

    @GET
    @PermitAll
    public List<Gender> findAll() {
        return genderServiceBO.findAll();
    }

    @POST
    @RolesAllowed("EMPLOYEE")
    public Gender insert(@NotNull @Valid final GenderInsertRequest request) {
        return genderServiceBO.insert(request);
    }

    @PUT
    @Path("/{id}")
    @RolesAllowed("EMPLOYEE")
    public Gender update(@NotNull @Valid final GenderUpdateRequest request) {
        return genderServiceBO.update(request);
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed("EMPLOYEE")
    public void delete(@NotNull @PathParam("id") final Long id) {
        genderServiceBO.delete(id);
    }
}
