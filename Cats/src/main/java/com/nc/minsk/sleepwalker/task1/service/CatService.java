package com.nc.minsk.sleepwalker.task1.service;

import com.nc.minsk.sleepwalker.task1.model.entity.Cat;
import com.nc.minsk.sleepwalker.task1.model.entity.Container;

import java.io.Closeable;
import java.sql.SQLException;

public interface CatService extends Service{


    void save(Cat entity);

    boolean remove(int id);

    Cat getById(int id);

    Container<Cat> getAll();

    void change(Cat cat);

    boolean changeName(int id, String name);

    boolean changeFather(int childId, int fatherId);

    boolean changeMother(int childId, int motherId);

    Container<Cat> getByAge(int age);

    Container<Cat> getByColor(String color);

    Container<Cat> getByName(String name);

}
