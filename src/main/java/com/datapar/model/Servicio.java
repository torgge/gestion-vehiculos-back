package com.datapar.model;

import com.datapar.shared.enums.TipoServicio;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
public class Servicio {
    private Usuario usuario;
    private Auto auto;
    private TipoServicio tipoServicio;
    private BigDecimal valorServicio;
    private Date fechaServicio;
    private Double kmInicial;
    private Double kmFinal;
    private String descripcion;
}
