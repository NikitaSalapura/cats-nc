package com.nc.minsk.sleepwalker.task1.model.entity;

import java.util.Objects;

public class Cat {

    private int id;
    private String nickname;
    private Sex sex;
    private String color;
    private int age;
    private int motherId;
    private int fatherId;

    public Cat() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMotherId() {
        return motherId;
    }

    public void setMotherId(int motherId) {
        this.motherId = motherId;
    }

    public int getFatherId() {
        return fatherId;
    }

    public void setFatherId(int fatherId) {
        this.fatherId = fatherId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return id == cat.id &&
                age == cat.age &&
                motherId == cat.motherId &&
                fatherId == cat.fatherId &&
                Objects.equals(nickname, cat.nickname) &&
                sex == cat.sex &&
                Objects.equals(color, cat.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nickname, sex, color, age, motherId, fatherId);
    }

    @Override
    public String
    toString() {
        return "Cat: " +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", gender=" + sex +
                ", color='" + color + '\'' +
                ", age=" + age +
                ", motherId=" + motherId +
                ", fatherId=" + fatherId;
    }
}
