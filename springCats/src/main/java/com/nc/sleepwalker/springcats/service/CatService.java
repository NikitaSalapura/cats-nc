package com.nc.sleepwalker.springcats.service;

import com.nc.sleepwalker.springcats.model.Cat;

import java.util.List;

public interface CatService extends Service<Cat> {

    void deleteById(int entityId);
}
