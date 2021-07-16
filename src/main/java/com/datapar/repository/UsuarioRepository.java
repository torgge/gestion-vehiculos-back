package com.datapar.repository;

import com.datapar.model.Usuario;
import com.datapar.shared.enums.Situacion;
import com.datapar.shared.enums.TipoUsuario;
import com.datapar.shared.exception.ApiException;

import javax.enterprise.context.ApplicationScoped;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ApplicationScoped
public class UsuarioRepository implements IBaseRepository<Usuario> {

    private final List<Usuario> usuarios;

    public UsuarioRepository() {
        this.usuarios = Stream.of(
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
                .collect(Collectors.toList());
    }

    @Override
    public List<Usuario> getAll() {
        return usuarios.stream()
                .filter(u -> u.getSituacion().equals(Situacion.ACTIVO))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Usuario> getById(UUID id) {
        return usuarios.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst();
    }

    @Override
    public Usuario save(@Valid Usuario entity) throws ApiException {
        Optional<Usuario> usuarioExistente = usuarios.stream()
                .filter(u -> u.getId().equals(entity.getId()) ||
                        u.getLogin().equals(entity.getNombre()))
                .findFirst();

        if (usuarioExistente.isPresent()) throw new ApiException("Usuario con el mismo nobre o id yá existe");

        entity.setId(UUID.randomUUID());
        usuarios.add(entity);

        return entity;
    }

    @Override
    public Usuario update(UUID id, @Valid Usuario entity) throws ApiException {
        Optional<Usuario> usuarioExistente = this.getById(id);

        if (!usuarioExistente.isPresent()) throw new ApiException("Usuario con id:" + id + " no existe para modificar");

        usuarios.removeIf(u -> u.getId().equals(id));

        entity.setId(id);
        usuarios.add(entity);

        return entity;
    }

    @Override
    public void delete(UUID id) throws ApiException {
        Optional<Usuario> usuario = this.getById(id);

        if (!usuario.isPresent()) throw new ApiException("Usuario no existe usuario con id:" + id + " para eliminar");

        usuario.get().setSituacion(Situacion.INACTIVO);
        usuarios.removeIf(u -> u.getId().equals(id));
        usuarios.add(usuario.get());
    }
}
