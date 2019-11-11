package com.nc.sleepwalker.springBootCats.service;

import com.nc.sleepwalker.springBootCats.model.Cat;
import com.nc.sleepwalker.springBootCats.model.Sex;

import java.util.List;

public interface CatService extends Service<Cat> {
    List<Cat> getByName(String name);

    List<Cat> getBySex(Sex sex);
}
