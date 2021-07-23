package com.datapar.resource;

import com.datapar.model.Main;
import com.datapar.service.CrudService;
import com.datapar.service.IBaseService;
import com.datapar.shared.exception.ApiException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
public class CrudResource<T extends Main> {

    @Inject
    private IBaseService<T> service;

    @Inject
    Logger logger;

    @GET
    public List<T> getAll() {
        return service.getAll();
    }

    @POST
    public Response create(T entity) throws ApiException {
        logger.info("\n Creando \n" + entity);
        T presistentEntity = service.save(entity);
        return Response
                .status(Response.Status.CREATED)
                .entity(presistentEntity)
                .build();
    }

    @GET
    @Path("{id}")
    public Optional<T> getById(@PathParam("id") UUID id) {
        logger.info("Buscando por id" + id);
        return service.getById(id);
    }

    @PUT()
    @Path("{id}")
    public Response update(@PathParam("id") UUID id, T entity) throws ApiException {
        logger.info("Actualizando" + id);
        T presistentEntity;

        presistentEntity = service.update(id, entity);
        return Response
                .status(Response.Status.CREATED)
                .entity(presistentEntity)
                .build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") UUID id) throws ApiException {
        logger.info("Removendo" + id);
        service.delete(id);
        return Response
                .noContent()
                .build();
    }

}
