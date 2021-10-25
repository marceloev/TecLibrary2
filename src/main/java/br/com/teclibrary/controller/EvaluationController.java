package br.com.teclibrary.controller;

import br.com.teclibrary.bo.EvaluationServiceBO;
import br.com.teclibrary.handler.authentication.AuthenticationHandler;
import br.com.teclibrary.model.data.Evaluation;
import br.com.teclibrary.model.request.EvaluationInsertRequest;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;

@Path("/evaluation")
public class EvaluationController {

    @Inject
    EvaluationServiceBO evaluationServiceBO;

    @Inject
    AuthenticationHandler authenticationHandler;

    @GET
    @RolesAllowed("MANAGER")
    public List<Evaluation> findAll() {
        return evaluationServiceBO.findAll();
    }

    @GET
    @Path("/user")
    @RolesAllowed("CUSTOMER")
    public List<Evaluation> findByUser() {
        return evaluationServiceBO.findByUserId(authenticationHandler.getCurrentUser().getId());
    }

    @POST
    @RolesAllowed("CUSTOMER")
    public Evaluation insert(@Valid @NotNull final EvaluationInsertRequest request) {
        return evaluationServiceBO.insert(authenticationHandler.getCurrentUser(), request);
    }
}
