package com.lv297.travel_agency.database.jdbc.utils;

import java.sql.*;

public class JdbcUtil {
    private static boolean initialized;

    private static final String DB_NAME = "pranksters_db";
    private static final String URL = "jdbc:mysql://localhost:3306/"+DB_NAME;
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";

    private static void initDriver(String driver){
        if(!initialized) {
            try {
                Class.forName(driver);
                initialized = true;
            } catch (ClassNotFoundException e) {
                System.out.println("Can`t load driver class");
            }
        }
    }

    public static Connection getConnection() throws SQLException {
        initDriver(DRIVER);
        Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);
        return connection;
    }

    public static void closeConnectionQuietly(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            //NOP
        }
    }

    public static void closeStatementQuietly(Statement statement) {
        try {
            statement.close();
        } catch (SQLException e) {
            //NOP
        }
    }

    public static void closeResultSetQuietly(ResultSet resultSet) {
        try {
            resultSet.close();
        } catch (SQLException e) {
            //NOP
        }
    }
}
