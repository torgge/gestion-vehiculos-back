package com.datapar.repository;

import com.datapar.model.Auto;
import com.datapar.shared.enums.Situacion;

import javax.enterprise.context.ApplicationScoped;
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
}
