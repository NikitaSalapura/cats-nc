package com.nc.minsk.sleepwalker.task1.model.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Container<T> extends ArrayList<Cat> {
//    private List<T> catList;
//
//    public Container() {
//        catList = new ArrayList<>();
//    }
//
//    public void add(T entity) {
//        checkForNull(entity);
//        catList.add(entity);
//    }
//
//    public T get(int id) {
//        return catList.get(id);
//    }
//
//    public int getSize() {
//        return catList.size();
//    }
//
//    //TODO
//    private void checkForNull(Object o) {
//        if (o == null) throw new NullPointerException();
//    }
//
//    @Override
//    public String toString() {
//        StringBuilder stringBuilder = new StringBuilder();
//        for (T entity : catList) {
//            stringBuilder.append(entity).append("\n");
//        }
//        return stringBuilder.toString();
//    }
}
