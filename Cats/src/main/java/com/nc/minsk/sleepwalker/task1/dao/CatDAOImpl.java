package com.nc.minsk.sleepwalker.task1.dao;

import static com.nc.minsk.sleepwalker.task1.dao.constants.MySQLConnectionData.*;

import com.nc.minsk.sleepwalker.task1.model.entity.Cat;
import com.nc.minsk.sleepwalker.task1.model.entity.Container;
import com.nc.minsk.sleepwalker.task1.model.entity.Sex;

import java.sql.*;

public class CatDAOImpl implements CatDAO {

    private Connection connection;

    public CatDAOImpl() throws SQLException {
        // TODO
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
    }

    @Override
    public void save(Cat entity) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO `cats_data` (`nickname`, `sex`, `color`, " +
                        "`age`, `mother_id`, `father_id`) " +
                        "VALUES " + "(?, ?, ?, ?, ?, ?);")) {
            setCatExceptId(entity, preparedStatement);
            preparedStatement.execute();
        }
    }

    @Override
    public boolean remove(int id) throws SQLException {
        boolean isDeleted = false;
        if (getById(id) != null) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM cats_data WHERE pk_cat_id = ?")) {
                preparedStatement.setInt(1, id);
                preparedStatement.execute();
            }
            isDeleted = true;
        }
        return isDeleted;
    }

    @Override
    public void change(Cat cat) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE `cats_data` SET nickname = ?, sex = ?, color = ?, " +
                        "age = ?, mother_id = ?, father_id = ? WHERE pk_cat_id = ? ")) {
            setCatExceptId(cat, preparedStatement);
            preparedStatement.setInt(7, cat.getId());
            preparedStatement.execute();
        }
    }

    private void setCatExceptId(Cat cat, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, cat.getNickname());
        preparedStatement.setString(2, cat.getSex().name());
        preparedStatement.setString(3, cat.getColor());
        preparedStatement.setInt(4, cat.getAge());
        preparedStatement.setInt(5, cat.getMotherId());
        preparedStatement.setInt(6, cat.getFatherId());
    }

    @Override
    public boolean changeName(int id, String name) throws SQLException {
        boolean isChanged = false;
        if (getById(id) != null) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE cats_data SET nickname = ? WHERE pk_cat_id = ?")) {
                preparedStatement.setString(1, name);
                preparedStatement.setInt(2, id);
                preparedStatement.execute();
            }
            isChanged = true;
        }
        return isChanged;
    }

    @Override
    public boolean changeFather(int childId, int fatherId) throws SQLException {
        boolean isChanged = false;
        if (getById(childId) != null) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE cats_data SET father_id = ? WHERE pk_cat_id = ?")) {
                preparedStatement.setInt(1, fatherId);
                preparedStatement.setInt(2, childId);
                preparedStatement.execute();
            }
            isChanged = true;
        }
        return isChanged;
    }

    @Override
    public boolean changeMother(int childId, int motherId) throws SQLException {
        boolean isChanged = false;
        if (getById(childId) != null) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE cats_data SET mother_Id = ? WHERE pk_cat_id = ?")) {
                preparedStatement.setInt(1, motherId);
                preparedStatement.setInt(2, childId);
                preparedStatement.execute();
            }
            isChanged = true;
        }
        return isChanged;
    }

    @Override
    public Cat getById(int id) throws SQLException {
        Cat cat = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT `pk_cat_id`, `nickname`, `sex`," +
                        " `color`, `age`, `mother_id`, `father_id` " +
                        "FROM cats_data WHERE pk_cat_id = ?")) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    cat = makeCat(resultSet);
                }
            }
        }
        return cat;
    }

    @Override
    public Container<Cat> getAll() throws SQLException {
        Container<Cat> catContainer = new Container<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM cats_data")) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    catContainer.add(makeCat(resultSet));
                }
            }
        }
        return catContainer;
    }

    private Cat makeCat(ResultSet resultSet) throws SQLException {
        Cat cat = new Cat();
        cat.setId(resultSet.getInt(1));
        cat.setNickname(resultSet.getString(2));
        cat.setSex(Sex.valueOf(resultSet.getString(3)));
        cat.setColor(resultSet.getString(4));
        cat.setAge(resultSet.getInt(5));
        cat.setMotherId(resultSet.getInt(6));
        cat.setFatherId(resultSet.getInt(7));
        return cat;
    }

    @Override
    public Container<Cat> getByAge(int age) throws SQLException {
        Container<Cat> catContainer = new Container<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT `pk_cat_id`, `nickname`, `sex`," +
                        " `color`, `age`, `mother_id`, `father_id` " +
                        "FROM cats_data WHERE age = ?")) {
            preparedStatement.setInt(1, age);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    catContainer.add(makeCat(resultSet));
                }
            }
        }
        return catContainer;
    }

    @Override
    public Container<Cat> getByColor(String color) throws SQLException {
        Container<Cat> catContainer = new Container<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT `pk_cat_id`, `nickname`, `sex`," +
                        " `color`, `age`, `mother_id`, `father_id` " +
                        "FROM cats_data WHERE color = ?")) {
            preparedStatement.setString(1, color);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    catContainer.add(makeCat(resultSet));
                }
            }
        }
        return catContainer;
    }

    @Override
    public Container<Cat> getByName(String name) throws SQLException {
        Container<Cat> catContainer = new Container<>();
        //костылище/TODO FIX
        if (name.isEmpty()) {
            return catContainer;
        }
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT `pk_cat_id`, `nickname`, `sex`," +
                        " `color`, `age`, `mother_id`, `father_id` " +
                        "FROM cats_data " +
                        "WHERE nickname LIKE ? OR nickname LIKE ?")) {

            String nameFirstBig = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
            String nameFullLow = name.toLowerCase();
            preparedStatement.setString(1, getPattern(nameFirstBig));
            preparedStatement.setString(2, getPattern(nameFullLow));
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    catContainer.add(makeCat(resultSet));
                }
            }
        }
        return catContainer;
    }

    private String getPattern(String name) {
        return "%" + name + "%";
    }

    @Override
    public void close() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
