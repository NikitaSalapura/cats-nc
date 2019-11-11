package com.nc.sleepwalker.springcats.service;

import java.util.List;

public interface Service<T> {
    T getById(int id);

    List<T> getAll();

    T create(T entity);

    T update(T entity);

    void delete(T entity);

}
