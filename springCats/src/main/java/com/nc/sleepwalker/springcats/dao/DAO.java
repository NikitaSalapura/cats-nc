package com.nc.sleepwalker.springcats.dao;


import java.util.List;

public interface DAO<T> {
    T getById(int id);

    List<T> getAll();

    T create(T entity);

    T update(T entity);

    void delete(T entity);
}
