package com.datapar.model;

import com.datapar.shared.enums.TipoUsuario;
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
@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario extends Main {
    @NotNull(message = "El nombre no puede ser nulo")
    private String nombre;
    @NotBlank(message="Login no puede ser vacio")
    private String login;
    @NotBlank(message="Contraseña no puede ser vacio")
    private String contrasena;
    @NotNull(message="Tipo Usuario no puede ser vacio")
    private TipoUsuario tipoUsuario;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "servicioId", foreignKey=@ForeignKey(name="fk_servicio_usuario"))
//    @JsonIgnore
//    private Servicio servicio;
}

