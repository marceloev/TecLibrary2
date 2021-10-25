package br.com.teclibrary.controller;

import br.com.teclibrary.bo.AuthenticationServiceBO;
import br.com.teclibrary.model.data.User;
import br.com.teclibrary.model.request.IdentificationUpdateRequest;
import br.com.teclibrary.model.request.UserAuthenticationRequest;
import br.com.teclibrary.model.request.UserInsertRequest;
import br.com.teclibrary.model.request.IdentificationRecoverRequest;
import br.com.teclibrary.model.response.UserAuthenticationResponse;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/auth")
public class AuthController {

    @Inject
    AuthenticationServiceBO authenticationServiceBO;

    @POST
    @PermitAll
    public UserAuthenticationResponse auth(@Valid @NotNull final UserAuthenticationRequest request) {
        return authenticationServiceBO.authenticate(request);
    }

    @POST
    @Path("/register")
    @PermitAll
    public User insert(@Valid @NotNull final UserInsertRequest request) {
        return authenticationServiceBO.register(request);
    }

    @POST
    @Path("/recover")
    @PermitAll
    public void recover(@Valid @NotNull final IdentificationRecoverRequest request) {
        authenticationServiceBO.requestRecoverPassword(request);
    }

    @GET
    @Path("/activate")
    @PermitAll
    public User activate(@Valid @NotNull @QueryParam("activation") final String activation) {
        return authenticationServiceBO.activateUser(activation);
    }

    @PUT
    @PermitAll
    public User update(@Valid @NotNull final IdentificationUpdateRequest request) {
        return authenticationServiceBO.updateIdentification(request);
    }
}
