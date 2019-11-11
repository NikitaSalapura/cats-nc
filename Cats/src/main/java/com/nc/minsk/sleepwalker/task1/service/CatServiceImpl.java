package com.nc.minsk.sleepwalker.task1.service;

import com.nc.minsk.sleepwalker.task1.model.entity.Cat;
import com.nc.minsk.sleepwalker.task1.model.entity.Container;
import com.nc.minsk.sleepwalker.task1.dao.CatDAOImpl;
import com.nc.minsk.sleepwalker.task1.dao.CatDAO;

import java.sql.SQLException;

public class CatServiceImpl implements CatService {
    private CatDAO catDAO;

    //    private CatService catService;

    public CatServiceImpl() {
        try {
            catDAO = new CatDAOImpl();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public CatService getEntity() {
//        if (catService == null) {
//            catService = new CatServiceImpl();
//        }
//        return catService;
//    }

    @Override
    public void save(Cat cat) {
        try {
            catDAO.save(cat);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void change(Cat cat) {
        try {
            catDAO.change(cat);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean remove(int id) {
        boolean isRemoved = false;
        try {
            isRemoved = catDAO.remove(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isRemoved;
    }

    @Override
    public Cat getById(int id) {
        Cat cat = null;
        try {
            cat = catDAO.getById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cat;
    }

    @Override
    public Container<Cat> getByName(String name) {
        Container<Cat> catContainer = new Container<>();
        try {
            catContainer = catDAO.getByName(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return catContainer;
    }

    @Override
    public Container<Cat> getByColor(String color) {
        Container<Cat> catContainer = new Container<>();
        try {
            catDAO.getByColor(color);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return catContainer;
    }

    @Override
    public Container<Cat> getByAge(int age) {
        Container<Cat> catContainer = new Container<>();
        try {
            catContainer = catDAO.getByAge(age);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return catContainer;
    }

    @Override
    public Container<Cat> getAll() {
        Container<Cat> catContainer = new Container<>();
        try {
            catContainer = catDAO.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return catContainer;
    }

    @Override
    public boolean changeName(int id, String name) {
        boolean isChanged = false;
        try {
            isChanged = catDAO.changeName(id, name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isChanged;
    }

    @Override
    public boolean changeFather(int childId, int fatherId) {
        boolean isChanged = false;
        try {
            isChanged = catDAO.changeFather(childId, fatherId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isChanged;
    }

    @Override
    public boolean changeMother(int childId, int motherId) {
        boolean isChanged = false;
        try {
            isChanged = catDAO.changeMother(childId, motherId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isChanged;
    }

    @Override
    public void close() {
        if (catDAO != null) {
            try {
                catDAO.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
