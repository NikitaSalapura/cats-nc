package com.nc.minsk.sleepwalker.task1.dao.constants;

public final class MySQLConnectionData {
    public static final String URL = "jdbc:mysql://localhost:3306/cats?Timezone=true&serverTimezone=UTC";
    public static final String USER = "root";
    public static final String PASSWORD = "password";

    private MySQLConnectionData() {
    }
}
