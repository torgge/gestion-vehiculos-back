package com.datapar.service;

import com.datapar.model.Auto;
import com.datapar.repository.AutoRepository;
import com.datapar.shared.enums.Situacion;
import com.datapar.shared.exception.ApiException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.util.Optional;

@RequestScoped
public class AutoService extends CrudService<Auto> {

    @Inject
    AutoRepository autoRepository;

    public Optional<Auto> getByChapa(String chapa){
        return autoRepository.getByChapa(chapa);
    }

    public Auto updateByChapa(String chapa, Auto entity) throws ApiException {
        return autoRepository.updateByChapa(chapa, entity);
    }

    public void delete(String chapa) throws ApiException {
        autoRepository.deleteByChapa(chapa);
    }
}
