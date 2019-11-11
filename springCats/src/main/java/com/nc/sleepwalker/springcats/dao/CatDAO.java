package com.nc.sleepwalker.springcats.dao;

import com.nc.sleepwalker.springcats.model.Cat;

public interface CatDAO extends DAO<Cat> {
    void deleteById(int id);
}
