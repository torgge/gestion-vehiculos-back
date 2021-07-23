package com.datapar.service;

import com.datapar.shared.exception.ApiException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IBaseService<T> {

    List<T> getAll();
    Optional<T> getById(UUID id);
    T save(T entity) throws ApiException;
    T update(UUID id, T entity) throws ApiException;
    void delete(UUID id) throws ApiException;

}
