package com.datapar.repository;

import com.datapar.model.Usuario;
import com.datapar.shared.enums.Situacion;
import com.datapar.shared.enums.TipoUsuario;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ApplicationScoped
public class UsuarioRepository extends CrudRepository<Usuario> {

    public UsuarioRepository() {
        super(Stream.of(
                Usuario
                        .builder()
                        .id(UUID.fromString("c8618e55-447b-4e7e-b539-b37c2063381c"))
                        .nombre("Pedro")
                        .tipoUsuario(TipoUsuario.USUARIO)
                        .situacion(Situacion.ACTIVO)
                        .build(),
                Usuario
                        .builder()
                        .id(UUID.fromString("92584397-9225-4b14-84f5-18c554a861da"))
                        .nombre("Juan")
                        .tipoUsuario(TipoUsuario.USUARIO)
                        .situacion(Situacion.ACTIVO)
                        .build(),
                Usuario
                        .builder()
                        .id(UUID.fromString("f152bcd0-1cb1-4c4d-8d56-57db3fa55d47"))
                        .nombre("Caballero")
                        .tipoUsuario(TipoUsuario.ADMINISTRADOR)
                        .situacion(Situacion.ACTIVO)
                        .build())
                .collect(Collectors.toList()));
    }
}
