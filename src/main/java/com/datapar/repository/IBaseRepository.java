package com.datapar.repository;

import com.datapar.shared.exception.ApiException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IBaseRepository<T> {

    List<T> getAll();
    Optional<T> getById(UUID id);
    T save(@Valid T entity) throws ApiException;
    T update(UUID id, @Valid T entity) throws ApiException;
    void delete(UUID id) throws ApiException;

}
