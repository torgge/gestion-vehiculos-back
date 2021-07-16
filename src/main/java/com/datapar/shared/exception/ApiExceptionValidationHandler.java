package com.datapar.shared.exception;

import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ApiExceptionValidationHandler implements ExceptionMapper<ApiException> {

    @Inject
    Logger logger;

    @Override
    public Response toResponse(ApiException e) {
        logger.info("Handle UsuarioValidationException");

        return Response.status(Response.Status.BAD_REQUEST).entity(e.getLocalizedMessage()).build();
    }
}
