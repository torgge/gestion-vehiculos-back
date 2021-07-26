package com.datapar.repository;

import com.datapar.model.Usuario;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UsuarioRepository extends CrudRepository<Usuario> {}
