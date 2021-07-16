package com.datapar.repository;

import com.datapar.model.Auto;
import com.datapar.shared.enums.Situacion;
import com.datapar.shared.exception.ApiException;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ApplicationScoped
public class AutoRepository implements IBaseRepository<Auto> {

    private List<Auto> autos;

    public AutoRepository() {
        this.autos = Stream.of(
                Auto
                        .builder()
                        .id(UUID.randomUUID())
                        .chapa("ABC-12345")
                        .chassis(UUID.randomUUID().toString())
                        .anoFabricacion(2012)
                        .anoModelo(2013)
                        .fabricante("TOYOTA")
                        .kilometraje(231234.00)
                        .situacion(Situacion.ACTIVO)
                        .descripcion("Buen estado de conservación")
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public List<Auto> getAll() {
        return autos.stream()
                .filter(a -> a.getSituacion().equals(Situacion.ACTIVO))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Auto> getById(UUID id) {
        return autos.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst();
    }

    @Override
    public Auto save(Auto entity) throws ApiException {
        Optional<Auto> autoExistente = autos.stream()
                .filter(u -> u.getId().equals(entity.getId()) || u.getChapa().equals(entity.getChapa()))
                .findFirst();

        if (autoExistente.isPresent()) throw new ApiException("Auto con misma chapa o id yá existe");

        entity.setId(UUID.randomUUID());
        autos.add(entity);

        return entity;
    }

    @Override
    public Auto update(UUID id, Auto entity) throws ApiException {
        Optional<Auto> autoExistente = this.getById(id);

        if (autoExistente.isEmpty()) throw new ApiException("Auto con id:" + id + " no existe para modificar");

        autos.removeIf(a -> a.getId().equals(id));

        entity.setId(id);
        autos.add(entity);

        return entity;
    }

    @Override
    public void delete(UUID id) throws ApiException {
        Optional<Auto> auto = this.getById(id);

        if (auto.isEmpty()) throw new ApiException("Auto no existe con id:" + id + " para eliminar");

        auto.get().setSituacion(Situacion.INACTIVO);
        autos.removeIf(u -> u.getId().equals(id));
        autos.add(auto.get());
    }

    public Optional<Auto> getByChapa(String chapa) {
        return autos.stream()
                .filter(a -> a.getChapa().equals(chapa))
                .findFirst();
    }

    public Auto updateByChapa(String chapa, Auto entity) throws ApiException {
        Optional<Auto> autoExistente = this.getByChapa(chapa);

        if (autoExistente.isEmpty()) throw new ApiException("Auto con chapa:" + chapa + " no existe para modificar");

        autos.removeIf(a -> a.getId().equals(autoExistente.get().getId()));

        entity.setId(autoExistente.get().getId());
        autos.add(entity);

        return entity;
    }

    public void deleteByChapa(String chapa) throws ApiException {
        Optional<Auto> auto = this.getByChapa(chapa);

        if (auto.isEmpty()) throw new ApiException("Auto no existe con chapa:" + chapa + " para eliminar");

        auto.get().setSituacion(Situacion.INACTIVO);
        autos.removeIf(a -> a.getId().equals(auto.get().getId()));
        autos.add(auto.get());
    }


}
