package com.datapar.repository;

import com.datapar.model.Auto;
import com.datapar.shared.enums.Situacion;
import com.datapar.shared.exception.ApiException;
import io.quarkus.panache.common.Parameters;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class AutoRepository extends CrudRepository<Auto> {

    public Optional<Auto> getByChapa(String chapa) {
        return this.find("chapa = :chapa", Parameters.with("chapa", chapa))
                .stream()
                .findFirst();
    }

    public Auto updateByChapa(String chapa, Auto entity) throws ApiException {
        Optional<Auto> dato = this.getByChapa(chapa);

        if (dato.isEmpty()) throw new ApiException("Registro con chapa:" + chapa + " no existe para modificar");

        this.persistAndFlush(entity);

        return this.getByChapa(chapa).orElseThrow();
    }

    public void deleteByChapa(String chapa) throws ApiException {
        Optional<Auto> dato = this.getByChapa(chapa);

        if (dato.isEmpty()) throw new ApiException("Registro no existe con chapa:" + chapa + " para eliminar");

        dato.get().setSituacion(Situacion.INACTIVO);

        this.persistAndFlush(dato.get());
    }
}
