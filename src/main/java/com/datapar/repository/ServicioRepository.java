package com.datapar.repository;

import com.datapar.model.Auto;
import com.datapar.model.Servicio;
import com.datapar.model.Usuario;
import com.datapar.shared.enums.Situacion;
import com.datapar.shared.enums.TipoServicio;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ApplicationScoped
public class ServicioRepository extends CrudRepository<Servicio> {

    public ServicioRepository() {
        super(Stream.of(
                Servicio
                        .builder()
                        .id(UUID.randomUUID())
                        .tipoServicio(TipoServicio.ABASTECIMIENTO)
                        .usuario(Usuario.builder().id(UUID.fromString("c8618e55-447b-4e7e-b539-b37c2063381c")).build())
                        .auto(Auto.builder().id(UUID.fromString("c8618e55-447c-4e7e-c539-c37c2063381c")).build())
                        .kmFinal(3200.00)
                        .kmInicial(301.11)
                        .situacion(Situacion.ACTIVO)
                        .descripcion("Buen estado de conservación")
                        .build())
                .collect(Collectors.toList()));
    }

}
