package com.datapar.resource;

import com.datapar.repository.IBaseRepository;
import com.datapar.shared.exception.ApiException;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CRUDResource<T> {

    @Inject
    private IBaseRepository<T> repository;

    @Inject
    Logger logger;

    @GET
    public List<T> getAll(){
        return repository.getAll();
    }

    @POST
    public Response create(T entity) throws ApiException {
        logger.info("\n Creando \n" + entity);
        T presistentEntity = repository.save(entity);
        return Response
                .status(Response.Status.CREATED)
                .entity(presistentEntity)
                .build();
    }

    @GET
    @Path("{id}")
    public Optional<T> getById(@PathParam("id") UUID id){
        logger.info("Buscando por id" + id);
        return repository.getById(id);
    }

    @PUT()
    @Path("{id}")
    public Response update(@PathParam("id") UUID id, T entity) throws ApiException {
        logger.info("Actualizando" + id);
        T presistentEntity;

        presistentEntity = repository.update(id, entity);
        return Response
                .status(Response.Status.CREATED)
                .entity(presistentEntity)
                .build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") UUID id) throws ApiException {
        logger.info("Removendo" + id);
        repository.delete(id);
        return Response
                .noContent()
                .build();
    }

}
