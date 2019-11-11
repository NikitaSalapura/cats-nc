package com.nc.minsk.sleepwalker.task1.dao;

import com.nc.minsk.sleepwalker.task1.model.entity.Container;

import java.sql.SQLException;

public interface DAO<T> extends AutoCloseable {
    void save(T entity) throws SQLException;

    boolean remove(int id) throws SQLException;

    T getById(int id) throws SQLException;

    Container<T> getAll() throws SQLException;

    @Override
    void close() throws SQLException;
}