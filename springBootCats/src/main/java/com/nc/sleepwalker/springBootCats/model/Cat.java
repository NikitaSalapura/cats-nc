package com.nc.sleepwalker.springBootCats.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Objects;

@Entity
@Table(name = "cats")
public class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_cat_id")
    private int id;

    @Column(length = 15)
    private String nickname;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private Sex sex;

    @Column(length = 20)
    private String color;

    @Min(0) @Max(20)
    private int age;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "motherId")
    private Cat mother;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fatherId")
    private Cat father;

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

    public Cat getMother() {
        return mother;
    }

    public void setMother(Cat mother) {
        this.mother = mother;
    }

    public Cat getFather() {
        return father;
    }

    public void setFather(Cat father) {
        this.father = father;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return id == cat.id &&
                age == cat.age &&
                Objects.equals(nickname, cat.nickname) &&
                sex == cat.sex &&
                Objects.equals(color, cat.color) &&
                Objects.equals(mother, cat.mother) &&
                Objects.equals(father, cat.father);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nickname, sex, color, age, mother, father);
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
                ", motherId=" + mother.getId() +
                ", fatherId=" + father.getId();
    }
}

