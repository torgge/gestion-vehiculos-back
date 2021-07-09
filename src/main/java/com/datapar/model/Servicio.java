package com.datapar.model;

import com.datapar.shared.enums.TipoServicio;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
public class Servicio {
    @NotBlank(message="Usuario no puede ser vacio")
    private Usuario usuario;
    @NotBlank(message="Auto no puede ser vacio")
    private Auto auto;
    private TipoServicio tipoServicio;
    @NotBlank(message="Auto no puede ser vacio")
    private BigDecimal valorServicio;
    private Date fechaServicio;
    @Min(message="KM inicial no puede ser vacio", value=0)
    private Double kmInicial;
    @Min(message="KM inicial no puede ser vacio", value=0)
    private Double kmFinal;
    private String descripcion;
}
