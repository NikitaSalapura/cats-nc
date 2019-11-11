package com.nc.sleepwalker.springBootCats.repository;

import com.nc.sleepwalker.springBootCats.model.Cat;
import com.nc.sleepwalker.springBootCats.model.Sex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CatRepository extends JpaRepository<Cat, Integer> {

    @Query("select c from Cat c where nickname = :name")
    List<Cat> findAllByName(@Param("name") String name);

    @Query("select c from Cat c where sex = :sex")
    List<Cat> findAllBySex(@Param("sex") Sex sex);
}
