package com.datapar.repository;

import com.datapar.model.Main;
import com.datapar.shared.enums.Situacion;
import com.datapar.shared.exception.ApiException;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import lombok.NoArgsConstructor;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@NoArgsConstructor
public class CrudRepository<T extends Main> implements PanacheRepository<T> {

    public List<T> getAll() {
        return this.find("situacion = :situacion",
                Parameters.with("situacion", Situacion.ACTIVO))
                .list();
    }

    public Optional<T> getById(UUID id) {

        if (id == null) return Optional.empty();

        return this.find("id = id", Parameters.with("id", id))
                .stream()
                .findFirst();
    }

    @Transactional
    public T save(@Valid T entity) throws ApiException {
        Optional<T> dato = this.getById(entity.getId());

        if (dato.isPresent()) throw new ApiException("dato con el mismo id yá existe");

        entity.setId(UUID.randomUUID());
        this.persistAndFlush(entity);

        return entity;
    }

    @Transactional
    public T update(UUID id, @Valid T entity) throws ApiException {
        Optional<T> dato = this.getById(id);

        if (dato.isEmpty()) throw new ApiException("Registro con id:" + id + " no existe para modificar");

        this.persistAndFlush(entity);

        return this.getById(id).orElseThrow();
    }

    @Transactional
    public void delete(UUID id) throws ApiException {
        Optional<T> dato = this.getById(id);

        if (dato.isEmpty()) throw new ApiException("Registro no existe con id:" + id + " para eliminar");

        dato.get().setSituacion(Situacion.INACTIVO);

        this.persistAndFlush(dato.get());
    }
}
