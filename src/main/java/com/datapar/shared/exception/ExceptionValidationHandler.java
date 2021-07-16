package com.datapar.shared.exception;

import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.List;
import java.util.stream.Collectors;

@Provider
public class ExceptionValidationHandler implements ExceptionMapper<ConstraintViolationException> {

    @Inject
    Logger logger;

    @Override
    public Response toResponse(ConstraintViolationException e) {
        logger.info(e.getLocalizedMessage());

        List<String> errors = e.getConstraintViolations()
                .stream()
                .map(p -> p.getMessage())
                .collect(Collectors.toList());

        return Response.status(Response.Status.BAD_REQUEST).entity(errors).build();
    }

}
