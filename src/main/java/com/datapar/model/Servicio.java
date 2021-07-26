package com.datapar.model;

import com.datapar.shared.enums.TipoServicio;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "servicio")
public class Servicio extends Main {
    @NotNull(message="Usuario no puede ser vacio")
    @ManyToOne
    @JoinColumn(name = "usuarioId", foreignKey=@ForeignKey(name="fk_usuario_servicio"))
    private Usuario usuario;
    @NotNull(message="Auto no puede ser vacio")
    @ManyToOne
    @JoinColumn(name = "autoId", foreignKey=@ForeignKey(name="fk_auto_servicio"))
    private Auto auto;
    private TipoServicio tipoServicio;
    @Min(message="Valor Servicio debe ser mayor que cero", value=0)
    private BigDecimal valorServicio;
    private Date fechaServicio;
    @Min(message="KM inicial no puede ser vacio", value=0)
    private Double kmInicial;
    @Min(message="KM inicial no puede ser vacio", value=0)
    private Double kmFinal;
    private String descripcion;
}
