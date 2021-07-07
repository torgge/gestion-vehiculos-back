package com.datapar.model;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.UUID;

@Data
@SuperBuilder
public abstract class Main {
    private UUID id;
    private Date dCreacion;
    private Date dAlteracion;
}
