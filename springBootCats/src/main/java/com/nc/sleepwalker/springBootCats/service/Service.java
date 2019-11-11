package com.nc.sleepwalker.springBootCats.service;

import java.util.List;

public interface Service<T> {
    T getById(int id);

    List<T> getAll();

    T create(T entity);

    T update(T entity);

    void delete(T entity);

    void deleteById(int entityId);

}
