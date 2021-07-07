package com.datapar.repository;

import com.datapar.model.Usuario;
import com.datapar.shared.enums.TipoUsuario;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class UsuarioRepository {

    private List<Usuario> usuarios;

    public List<Usuario> getAllUsuarios() {
        return usuarios;
    }

    public Optional<Usuario> getUsuario(UUID id) {
        return usuarios.stream()
                .filter(u -> u.getId().equals(id)).findFirst();
    }

    public UsuarioRepository() {
        this.usuarios = List.of(
                Usuario
                        .builder()
                        .id(UUID.fromString("c8618e55-447b-4e7e-b539-b37c2063381c"))
                        .nombre("Pedro")
                        .tipoUsuario(TipoUsuario.USUARIO)
                        .build(),
                Usuario
                        .builder()
                        .id(UUID.fromString("92584397-9225-4b14-84f5-18c554a861da"))
                        .nombre("Juan")
                        .tipoUsuario(TipoUsuario.USUARIO)
                        .build(),
                Usuario
                        .builder()
                        .id(UUID.fromString("f152bcd0-1cb1-4c4d-8d56-57db3fa55d47"))
                        .nombre("Caballero")
                        .tipoUsuario(TipoUsuario.ADMINISTRADOR)
                        .build());
    }
}
