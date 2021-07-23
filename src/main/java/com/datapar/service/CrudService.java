package com.datapar.service;

import com.datapar.model.Main;
import com.datapar.repository.IBaseRepository;
import com.datapar.shared.exception.ApiException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
public class CrudService<T extends Main> implements IBaseService<T> {

    @Inject
    protected IBaseRepository<T> repository;

    @Override
    public List<T> getAll() {
        return repository.getAll();
    }

    @Override
    public Optional<T> getById(UUID id) {
        return repository.getById(id);
    }

    @Override
    public T save(T entity) throws ApiException {
        return repository.save(entity);
    }

    @Override
    public T update(UUID id, T entity) throws ApiException {
        return repository.update(id, entity);
    }

    @Override
    public void delete(UUID id) throws ApiException {
        repository.delete(id);
    }
}
