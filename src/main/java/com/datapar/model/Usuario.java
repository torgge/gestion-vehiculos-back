package com.datapar.model;

import com.datapar.shared.enums.TipoUsuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario extends Main {
    @NotNull(message = "El nombre no puede ser nulo")
    private String nombre;
    @NotBlank(message="Login no puede ser vacio")
    private String login;
    @NotBlank(message="Contraseña no puede ser vacio")
    private String contrasena;
    @NotNull(message="Tipo Usuario no puede ser vacio")
    private TipoUsuario tipoUsuario;
}

