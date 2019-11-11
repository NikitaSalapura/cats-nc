package com.nc.sleepwalker.springcats.dao;

import com.nc.sleepwalker.springcats.model.Cat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CatDAOImpl implements CatDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    //or except with load
    public Cat getById(int id) {
        return getCurrentSession().get(Cat.class, id);
    }

    @Override
    @Transactional
    public List<Cat> getAll() {
        return getCurrentSession().createQuery("from Cat", Cat.class).list();
    }

    @Override
    @Transactional
    public Cat create(Cat entity) {
        getCurrentSession().saveOrUpdate(entity);
        return entity;
    }

    @Override
    @Transactional
    public Cat update(Cat entity) {
        return (Cat) getCurrentSession().merge(entity);
    }

    @Override
    @Transactional
    public void delete(Cat entity) {

        try {
            getCurrentSession().delete(entity);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Cat entity = getById(id);
        delete(entity);
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
