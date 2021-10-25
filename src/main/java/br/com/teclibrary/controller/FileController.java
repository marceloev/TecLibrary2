package br.com.teclibrary.controller;

import br.com.teclibrary.bo.FileServiceBO;
import br.com.teclibrary.model.data.File;
import br.com.teclibrary.model.request.FileInsertRequest;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.DELETE;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

@Path("/file")
public class FileController {

    @Inject
    FileServiceBO fileServiceBO;

    @GET
    public List<File> findAll() {
        return fileServiceBO.findAll();
    }

    @GET
    @Path("/{id}")
    @PermitAll
    public Response findByID(@NotNull @PathParam("id") final Long id) throws IOException {
        return Response.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "filename=" + id) //TODO
                .header(HttpHeaders.CONTENT_TYPE, "image/png") //TODO
                .entity(fileServiceBO.getStoredFile(id))
                .build();
    }

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @RolesAllowed("OWNER")
    public Response insert(@Valid @MultipartForm final FileInsertRequest request) throws IOException {
        File file = fileServiceBO.insert(request);
        return this.findByID(file.getId());
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed("MANAGER")
    public void delete(@NotNull final Long id) {
        fileServiceBO.delete(id);
    }
}
