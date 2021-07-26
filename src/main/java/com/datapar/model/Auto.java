package com.datapar.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Entity
@Table(name = "auto")
public class Auto extends Main{
    @NotNull(message="Chapa no puede ser vacio")
    private String chapa;
    private String chassis;
    private String fabricante;
    private String modelo;
    @NotNull(message="Kilometrage no puede ser vacio")
    private Double kilometraje;
    private Integer anoModelo;
    private Integer anoFabricacion;
    private String descripcion;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "servicioId", foreignKey=@ForeignKey(name="fk_servicio_auto"))
//    @JsonIgnore
//    private Servicio servicio;
}
