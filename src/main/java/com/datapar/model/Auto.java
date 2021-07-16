package com.datapar.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
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
