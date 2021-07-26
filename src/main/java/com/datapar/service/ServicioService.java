package com.datapar.service;

import com.datapar.model.Servicio;
import com.datapar.repository.AutoRepository;
import com.datapar.repository.UsuarioRepository;
import com.datapar.shared.exception.ApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;

@RequestScoped
public class ServicioService extends CrudService<Servicio> {

    private static final Logger logger = LoggerFactory.getLogger("ServicioService");

    @Inject
    UsuarioRepository usuarioRepository;
    @Inject
    AutoRepository autoRepository;

    @Override
    public List<Servicio> getAll() {
        logger.info("Get All Servicio Service!!!");
        List<Servicio> servicioList = repository.getAll();

        servicioList.forEach(s -> {
            s.setUsuario(usuarioRepository.getById(s.getUsuario().getId()).orElseThrow());
            s.setAuto(autoRepository.getById(s.getAuto().getId()).orElseThrow());
        });

        return servicioList;
    }

    @Override
    public Servicio save(@Valid Servicio entity) throws ApiException {
        logger.info("Save Servicio Service!!!");
        Servicio servicio = repository.save(entity);

        servicio.setAuto(autoRepository.getById(servicio.getAuto().getId()).orElseThrow());
        servicio.setUsuario(usuarioRepository.getById(servicio.getUsuario().getId()).orElseThrow());

        return servicio;
    }
}
