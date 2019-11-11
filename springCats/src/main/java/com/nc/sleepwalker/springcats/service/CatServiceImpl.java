package com.nc.sleepwalker.springcats.service;

import com.nc.sleepwalker.springcats.dao.CatDAO;
import com.nc.sleepwalker.springcats.model.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatServiceImpl implements CatService {

    @Autowired
    private CatDAO dao;

    @Override
    public Cat getById(int id) {
        return dao.getById(id);
    }

    @Override
    public List<Cat> getAll() {
        return dao.getAll();
    }

    @Override
    public Cat create(Cat entity) {
        return dao.create(entity);
    }

    @Override
    public Cat update(Cat entity) {
        return dao.update(entity);
    }

    @Override
    public void delete(Cat entity) {
        dao.delete(entity);
    }

    @Override
    public void deleteById(int entityId) {
        dao.deleteById(entityId);
    }
}
