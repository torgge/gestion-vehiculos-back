create table if not exists auto
(
    id uuid not null
        constraint auto_pkey
            primary key,
    fechaalteracion timestamp,
    fechacreacion timestamp,
    situacion integer,
    anofabricacion integer,
    anomodelo integer,
    chapa varchar(255),
    chassis varchar(255),
    descripcion varchar(255),
    fabricante varchar(255),
    kilometraje double precision,
    modelo varchar(255)
);

alter table auto owner to postgres;

grant delete, insert, references, select, trigger, truncate, update on auto to anon;

grant delete, insert, references, select, trigger, truncate, update on auto to authenticated;

grant delete, insert, references, select, trigger, truncate, update on auto to service_role;

create table if not exists servicio
(
    id uuid not null
        constraint servicio_pkey
            primary key,
    fechaalteracion timestamp,
    fechacreacion timestamp,
    situacion integer,
    descripcion varchar(255),
    fechaservicio timestamp,
    kmfinal double precision,
    kminicial double precision,
    tiposervicio integer,
    valorservicio numeric(19,2),
    autoid uuid
        constraint fk_auto_servicio
            references auto,
    usuarioid uuid
);

alter table servicio owner to postgres;

grant delete, insert, references, select, trigger, truncate, update on servicio to anon;

grant delete, insert, references, select, trigger, truncate, update on servicio to authenticated;

grant delete, insert, references, select, trigger, truncate, update on servicio to service_role;

create table if not exists usuario
(
    id uuid not null
        constraint usuario_pkey
            primary key,
    fechaalteracion timestamp,
    fechacreacion timestamp,
    situacion integer,
    contrasena varchar(255),
    login varchar(255),
    nombre varchar(255),
    tipousuario integer
);

alter table usuario owner to postgres;

alter table servicio
    add constraint fk_usuario_servicio
        foreign key (usuarioid) references usuario;

grant delete, insert, references, select, trigger, truncate, update on usuario to anon;

grant delete, insert, references, select, trigger, truncate, update on usuario to authenticated;

grant delete, insert, references, select, trigger, truncate, update on usuario to service_role;

