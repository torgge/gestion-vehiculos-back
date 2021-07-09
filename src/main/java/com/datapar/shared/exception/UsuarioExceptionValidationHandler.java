package com.datapar.shared.exception;

import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class UsuarioExceptionValidationHandler implements ExceptionMapper<CustomException> {

    @Inject
    Logger logger;

    @Override
    public Response toResponse(CustomException e) {
        logger.info("Handle UsuarioValidationException");

        return Response.status(Response.Status.BAD_REQUEST).entity(e.getLocalizedMessage()).build();
    }
}
