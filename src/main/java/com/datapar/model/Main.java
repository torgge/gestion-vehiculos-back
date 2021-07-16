package com.datapar.model;

import com.datapar.shared.enums.Situacion;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.json.bind.annotation.JsonbDateFormat;
import java.util.Date;
import java.util.UUID;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class Main {

    @JsonProperty(access = Access.READ_ONLY)
    @EqualsAndHashCode.Include
    private UUID id;
    @JsonProperty(access = Access.READ_ONLY)
    @JsonbDateFormat("dd/MM/yyyy HH:mm:ss ")
    private Date fechaCreacion = new Date();
    @JsonProperty(access = Access.READ_ONLY)
    @JsonbDateFormat("dd/MM/yyyy HH:mm:ss ")
    private Date fechaAlteracion = new Date();
    @JsonProperty(access = Access.READ_ONLY)
    private Situacion situacion;
}
