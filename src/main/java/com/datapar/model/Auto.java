package com.datapar.model;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;

@Data
@SuperBuilder
public class Auto extends Main{
    @NotBlank(message="Chapa no puede ser vacio")
    private String chapa;
    private String chassis;
    private String fabricante;
    private String modelo;
    @NotBlank(message="Kilometrage no puede ser vacio")
    private Double kilometraje;
    private Integer anoModelo;
    private Integer anoFabricacion;
    private String descripcion;
}
