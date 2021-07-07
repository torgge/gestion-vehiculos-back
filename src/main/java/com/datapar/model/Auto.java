package com.datapar.model;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class Auto extends Main{
    private String chapa;
    private String chassis;
    private String fabricante;
    private String modelo;
    private Double kilometraje;
    private Integer anoModelo;
    private Integer anoFabricacion;
    private String descripcion;
}
