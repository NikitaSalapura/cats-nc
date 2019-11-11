package com.nc.minsk.sleepwalker.task1.controller;

import static com.nc.minsk.sleepwalker.task1.util.UserInput.*;

import com.nc.minsk.sleepwalker.task1.model.entity.Cat;
import com.nc.minsk.sleepwalker.task1.model.entity.Container;
import com.nc.minsk.sleepwalker.task1.model.entity.Sex;
import com.nc.minsk.sleepwalker.task1.dao.CatDAOImpl;
import com.nc.minsk.sleepwalker.task1.view.Printer;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        try (CatDAOImpl catRepository = new CatDAOImpl()) {
            boolean isEnd = false;
            while (!isEnd) {
                String answer = inputString("Enter an action:" +
                        "\n0 - exit" +
                        "\n1 - print all cats" +
                        "\n2 - print a cat by id " +
                        "\n3 - print cats by age" +
                        "\n4 - print cats by Name" +
                        "\n5 - print cats by color" +
                        "\n6 - remove a cat by id" +
                        "\n7 - create a cat" +
                        "\n8 - change name" +
                        "\n9 - change mother" +
                        "\n10 - change father" +
                        "\n");
                switch (answer) {
                    case "0":
                        Printer.println("\nBye!");
                        isEnd = true;
                        break;
                    case "1":
                        printAll(catRepository);
                        break;
                    case "2":
                        printById(catRepository);
                        break;
                    case "3":
                        printByAge(catRepository);
                        break;
                    case "4":
                        printByName(catRepository);
                        break;
                    case "5":
                        printByColor(catRepository);
                        break;
                    case "6":
                        printRemoving(catRepository);
                        break;
                    case "7":
                        printCreating(catRepository);
                        break;
                    case "8":
                        printChangingName(catRepository);
                        break;
                    case "9":
                        printChangingMother(catRepository);
                        break;
                    case "10":
                        printChangingFather(catRepository);
                        break;
                    default:
                        Printer.println("Wrong input. Try again!");
                }
                Printer.println("\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void printChangingFather(CatDAOImpl catRepository) throws SQLException {
        Integer childId = inputInteger("Enter child's id: ");
        Integer fatherId = inputInteger("Enter father's id: ");
        catRepository.changeFather(childId, fatherId);
        Printer.println(catRepository.getById(childId).toString());
    }

    private static void printChangingMother(CatDAOImpl catRepository) throws SQLException {
        Integer childId = inputInteger("Enter child's id: ");
        Integer motherId = inputInteger("Enter mother's id: ");
        catRepository.changeMother(childId, motherId);
        Printer.println(catRepository.getById(childId).toString());
    }

    private static void printChangingName(CatDAOImpl catRepository) throws SQLException {
        Integer id = inputInteger("Enter cat's id: ");
        String name = inputString("Enter a new name: ");
        catRepository.changeName(id, name);
        Printer.println(catRepository.getById(id).toString());
    }

    private static void printCreating(CatDAOImpl catRepository) throws SQLException {
        Cat cat = createCat(catRepository);
        if (cat != null) {
            catRepository.save(cat);
            Printer.println("Cat was created");
        } else {
            Printer.println("Cat wasn't created");
        }
    }

    private static void printRemoving(CatDAOImpl catRepository) throws SQLException {
        Integer id = inputInteger("Enter id: ");
        boolean isRemoved = catRepository.remove(id);
        Printer.println(isRemoved ? "Cat(" + id + ") was removed"
                : "There is no cat with id = " + id);
    }

    private static void printByColor(CatDAOImpl catRepository) throws SQLException {
        String color = inputString("Enter a color: ");
        Container<Cat> cats = catRepository.getByColor(color);
        Printer.println(cats.size() != 0 ? cats.toString()
                : " There are no cats with " + " color");
    }

    private static void printByName(CatDAOImpl catRepository) throws SQLException {
        String name = inputString("Enter a nickname: ");
        Container<Cat> cats = catRepository.getByName(name);
        Printer.println(cats.size() != 0 ? cats.toString()
                : "There are no cats with " + name + " in name");
    }

    private static void printByAge(CatDAOImpl catRepository) throws SQLException {
        Integer age = inputInteger("Enter age: ");
        if (age != null) {
            Container<Cat> cats = catRepository.getByAge(age);
            Printer.println(cats.size() != 0 ? cats.toString()
                    : "There are no cats with age = " + age);
        } else {
            Printer.println("Wrong input");
        }
    }

    private static void printById(CatDAOImpl catRepository) throws SQLException {
        Integer id = inputInteger("Enter id: ");
        if (id != null) {
            Cat cat = catRepository.getById(id);
            Printer.println(cat != null ? cat.toString() : "there is no cat with id = " + id);
        } else {
            Printer.println("Wrong input!");
        }
    }

    private static void printAll(CatDAOImpl catRepository) throws SQLException {
        Printer.println(catRepository.getAll().toString());
    }

    private static Cat createCat(CatDAOImpl catRepository) throws SQLException {
        final int maxLength = 29;

        String nickname = inputString("Enter a nickname: ");
        if ("".equals(nickname) || nickname.length() > maxLength) {
            Printer.println("Wrong name input.");
            return null;
        }

        String sexChoice = inputString("Select sex(1 - MALE, 2 - FEMALE): ");
        Sex sex;
        switch (sexChoice) {
            case "1":
                sex = Sex.MALE;
                break;
            case "2":
                sex = Sex.FEMALE;
                break;
            default:
                Printer.println("Wrong input!");
                return null;
        }

        String color = inputString("Enter a color: ");
        if ("".equals(color) || color.length() > maxLength) {
            Printer.println("Wrong color input.");
            return null;
        }

        int age = inputInteger("Enter age: ");
        if (age < 0 || age >= 30) {
            Printer.println("Wrong input! Age must be [0;30]");
            return null;
        }

        int motherId = inputInteger("Enter mother's id: ");
        Cat motherCat = catRepository.getById(motherId);
        if (motherCat == null) {
            Printer.println("There is no cat with id = " + motherId);
            return null;
        } else if (motherCat.getSex() != Sex.FEMALE) {
            Printer.println("Mother must be FEMALE!");
            return null;
        } else if (motherCat.getAge() <= age) {
            Printer.println("Mother's age must be > child's!");
            return null;
        }

        int fatherId = inputInteger("Enter father's id: ");
        Cat fatherCat = catRepository.getById(motherId);
        if (fatherCat == null) {
            Printer.println("There is no cat with id = " + motherId);
            return null;
        } else if (fatherCat.getSex() != Sex.MALE) {
            Printer.println("Father must be MALE!");
            return null;
        } else if (fatherCat.getAge() <= age) {
            Printer.println("Father's age must be > child's!");
            return null;
        }

        Cat cat = new Cat();
        cat.setNickname(nickname);
        cat.setSex(sex);
        cat.setColor(color);
        cat.setAge(age);
        cat.setMotherId(motherId);
        cat.setFatherId(fatherId);
        return cat;
    }
}
