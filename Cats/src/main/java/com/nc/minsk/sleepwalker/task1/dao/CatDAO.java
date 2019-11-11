package com.nc.minsk.sleepwalker.task1.dao;

import com.nc.minsk.sleepwalker.task1.model.entity.Cat;
import com.nc.minsk.sleepwalker.task1.model.entity.Container;

import java.sql.SQLException;

public interface CatDAO extends DAO<Cat> {

    void change(Cat cat) throws SQLException;

    boolean changeName(int id, String name) throws SQLException;

    boolean changeFather(int childId, int fatherId) throws SQLException;

    boolean changeMother(int childId, int motherId) throws SQLException;

    Container<Cat> getByAge(int age) throws SQLException;

    Container<Cat> getByColor(String color) throws SQLException;

    Container<Cat> getByName(String name) throws SQLException;

}
