package com.datapar.resource;

import com.datapar.model.Usuario;
import com.datapar.repository.UsuarioRepository;
import lombok.SneakyThrows;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Path("/api/v1/usuarios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    @Inject
    UsuarioRepository usuarioRepository;

    @Inject
    Logger logger;

    @GET
    public List<Usuario> getAllUsuarios() {
        logger.info("Retorno todo los usuarios");
        return usuarioRepository.getAll();
    }

    @POST
    @SneakyThrows()
    public Response create(Usuario usuario) {
        logger.info("Creacion de usuario");

        Usuario persistentUser;

        try {
            persistentUser = usuarioRepository.save(usuario);
            return Response
                    .status(Response.Status.CREATED)
                    .entity(persistentUser)
                    .build();
        } catch (Exception e) {
            return Response
                    .serverError()
                    .entity(e.getMessage())
                    .build();
        }

    }

    @GET
    @Path("{id}")
    public Optional<Usuario> getUsuario(@PathParam("id") UUID id) {
        logger.info("Retorno el usuario con id " + id);
        return usuarioRepository.getById(id);
    }

    @PUT()
    @Path("{id}")
    @SneakyThrows()
    public Response update(@PathParam("id") UUID id, Usuario usuario) {
        Usuario persistentUser;

        persistentUser = usuarioRepository.update(id, usuario);
        return Response
                .status(Response.Status.CREATED)
                .entity(persistentUser)
                .build();

    }

    @DELETE
    @Path("{id}")
    @SneakyThrows()
    public Response delete(@PathParam("id") UUID id) {
        logger.info("Removendo Usuario" + id);
        usuarioRepository.delete(id);
        return Response
                .noContent()
                .build();
    }

}

