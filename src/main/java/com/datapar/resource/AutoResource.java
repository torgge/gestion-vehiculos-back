package com.datapar.resource;

import com.datapar.model.Auto;
import com.datapar.repository.AutoRepository;
import com.datapar.service.AutoService;
import com.datapar.shared.exception.ApiException;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/api/v1/autos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AutoResource extends CrudResource<Auto> {

    @Inject
    AutoService autoService;

    @GET
    @Path("{chapa}")
    public Optional<Auto> getByChapa(@PathParam("chapa") String chapa){
        logger.info("Buscando por chapa" + chapa);
        return autoService.getByChapa(chapa);
    }

    @PUT()
    @Path("{chapa}")
    public Response updateByChapa(@PathParam("chapa") String chapa, Auto entity) throws ApiException {
        logger.info("Actualizando por " + chapa);
        Auto presistentEntity;

        presistentEntity = autoService.updateByChapa(chapa, entity);

        return Response
                .status(Response.Status.CREATED)
                .entity(presistentEntity)
                .build();
    }

    @DELETE
    @Path("{chapa}")
    public Response delete(@PathParam("chapa") String chapa) throws ApiException {
        logger.info("Removendo por chapa" + chapa);
        autoService.delete(chapa);
        return Response
                .noContent()
                .build();
    }
}
