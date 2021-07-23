package com.datapar.repository;

import com.datapar.model.Auto;
import com.datapar.shared.enums.Situacion;
import com.datapar.shared.exception.ApiException;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ApplicationScoped
public class AutoRepository extends CrudRepository<Auto> {

    public AutoRepository() {
        super(Stream.of(
                Auto
                        .builder()
                        .id(UUID.fromString("c8618e55-447c-4e7e-c539-c37c2063381c"))
                        .chapa("ABC-12345")
                        .chassis(UUID.randomUUID().toString())
                        .anoFabricacion(2012)
                        .anoModelo(2013)
                        .fabricante("TOYOTA")
                        .kilometraje(231234.00)
                        .situacion(Situacion.ACTIVO)
                        .descripcion("Buen estado de conservación")
                        .build())
                .collect(Collectors.toList()));
    }

    public Optional<Auto> getByChapa(String chapa) {
        return datos.stream()
                .filter(a -> a.getChapa().equals(chapa))
                .findFirst();
    }

    public Auto updateByChapa(String chapa, Auto entity) throws ApiException {
        Optional<Auto> autoExistente = this.getByChapa(chapa);

        if (autoExistente.isEmpty()) throw new ApiException("Auto con chapa:" + chapa + " no existe para modificar");

        datos.removeIf(a -> a.getId().equals(autoExistente.get().getId()));

        entity.setId(autoExistente.get().getId());
        datos.add(entity);

        return entity;
    }

    public void deleteByChapa(String chapa) throws ApiException {
        Optional<Auto> auto = this.getByChapa(chapa);

        if (auto.isEmpty()) throw new ApiException("Auto no existe con chapa:" + chapa + " para eliminar");

        auto.get().setSituacion(Situacion.INACTIVO);
        datos.removeIf(a -> a.getId().equals(auto.get().getId()));
        datos.add(auto.get());
    }
}
