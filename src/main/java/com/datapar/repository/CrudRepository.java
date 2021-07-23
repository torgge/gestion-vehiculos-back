package com.datapar.repository;

import com.datapar.model.Main;
import com.datapar.shared.enums.Situacion;
import com.datapar.shared.exception.ApiException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
public class CrudRepository<T extends Main> implements IBaseRepository<T> {

    protected List<T> datos;

    @Override
    public List<T> getAll() {
        return this.datos;
    }

    @Override
    public Optional<T> getById(UUID id) {
        return this.datos.stream().filter(item -> item.getId().equals(id)).findFirst();
    }

    @Override
    public T save(@Valid T entity) throws ApiException {
        Optional<T> dato = this.datos.stream()
                .filter(u -> u.getId().equals(entity.getId()))
                .findFirst();

        if (dato.isPresent()) throw new ApiException("dato con el mismo id yá existe");

        entity.setId(UUID.randomUUID());
        this.datos.add(entity);

        return entity;
    }

    @Override
    public T update(UUID id,@Valid T entity) throws ApiException {
        Optional<T> dato = this.getById(id);

        if (dato.isEmpty()) throw new ApiException("Registro con id:" + id + " no existe para modificar");

        datos.removeIf(item -> item.getId().equals(id));

        entity.setId(id);
        datos.add(entity);

        return entity;
    }

    @Override
    public void delete(UUID id) throws ApiException {
        Optional<T> dato = this.getById(id);

        if (dato.isEmpty()) throw new ApiException("Registro no existe con id:" + id + " para eliminar");

        dato.get().setSituacion(Situacion.INACTIVO);
        this.datos.removeIf(u -> u.getId().equals(id));
        this.datos.add(dato.get());
    }
}
