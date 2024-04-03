package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Task1 {
    public static void main(String[] args) throws SQLException {
        System.out.println("Hello world!");

        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "123456789";

        Connection connection = DriverManager.getConnection(url, user, password);

        createDatabase(connection);
        useDatabase(connection);
        createTable(connection);





    }

    public static void createDatabase(Connection connection) throws SQLException {
        String createDatabaseSQL = "CREATE DATABASE IF NOT EXISTS schoolDataBase;";
        try (PreparedStatement statement = connection.prepareStatement(createDatabaseSQL)) {
            statement.execute();
        }
    }

    public static void useDatabase(Connection connection) throws SQLException {
        String userDatabaseSQL = "USE schoolDataBase;";
        try (PreparedStatement statement = connection.prepareStatement(userDatabaseSQL)) {
            statement.execute();
        }
    }
    public static void createTable(Connection connection) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS courses (id INT AUTO_INCREMENT PRIMARY KEY,  title VARCHAR(255), duration INT);";

        try (PreparedStatement statement = connection.prepareStatement(createTableSQL)) {
            statement.execute();
        }
    }

}