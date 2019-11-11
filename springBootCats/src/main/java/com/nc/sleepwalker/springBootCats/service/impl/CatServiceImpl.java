package com.nc.sleepwalker.springBootCats.service.impl;

import com.nc.sleepwalker.springBootCats.model.Cat;
import com.nc.sleepwalker.springBootCats.model.Sex;
import com.nc.sleepwalker.springBootCats.repository.CatRepository;
import com.nc.sleepwalker.springBootCats.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatServiceImpl implements CatService {

    @Autowired
    private CatRepository repository;

    @Override
    public Cat getById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Cat> getBySex(Sex sex) {
        return repository.findAllBySex(sex);
    }

    @Override
    public List<Cat> getByName(String name) {
        return repository.findAllByName(name);
    }

    @Override
    public List<Cat> getAll() {
        return repository.findAll();
    }

    @Override
    public Cat create(Cat entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    public Cat update(Cat entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    public void delete(Cat entity) {
        repository.delete(entity);
    }

    @Override
    public void deleteById(int entityId) {
        repository.deleteById(entityId);
    }
}
