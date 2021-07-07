package com.datapar.resource;

import com.datapar.model.Usuario;
import com.datapar.repository.UsuarioRepository;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.*;


@Path("/api/v1/usuarios")
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    @Inject
    UsuarioRepository usuarioRepository;

    @Inject
    Logger logger;

    @GET
    public List<Usuario> getAllUsuarios() {
        logger.info("Retorno todo los usuarios");
        return usuarioRepository.getAllUsuarios();
    }

    @GET
    @Path("{id}")
    public Optional<Usuario> getUsuario(@PathParam("id") UUID id) {
        logger.info("Retorno el usuario con id " + id);
        return usuarioRepository.getUsuario(id);
    }
}
