package com.datapar.model;

import com.datapar.shared.enums.TipoUsuario;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class Usuario extends Main {
    private String nombre;
    private String login;
    private String contrasena;
    private TipoUsuario tipoUsuario;
}
