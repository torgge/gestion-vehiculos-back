package com.datapar.service;

import com.datapar.model.Servicio;
import com.datapar.repository.AutoRepository;
import com.datapar.repository.UsuarioRepository;
import com.datapar.shared.exception.ApiException;
import org.jboss.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;

@RequestScoped
public class ServicioService extends CrudService<Servicio> {

    @Inject
    UsuarioRepository usuarioRepository;
    @Inject
    AutoRepository autoRepository;

    @Inject
    Logger logger;

    @Override
    public List<Servicio> getAll() {
        logger.info("Get All Servicio Service!!!");
        List<Servicio> servicioList = repository.getAll();

        servicioList.stream().forEach(s -> {
            s.setUsuario(usuarioRepository.getById(s.getUsuario().getId()).get());
            s.setAuto(autoRepository.getById(s.getAuto().getId()).get());
        });

        return servicioList;
    }

    @Override
    public Servicio save(@Valid Servicio entity) throws ApiException {
        logger.info("Save Servicio Service!!!");
        Servicio servicio = repository.save(entity);

        servicio.setAuto(autoRepository.getById(servicio.getAuto().getId()).get());
        servicio.setUsuario(usuarioRepository.getById(servicio.getUsuario().getId()).get());

        return servicio;
    }
}
