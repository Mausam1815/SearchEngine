package com.SearchEngine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
//    Static variable to hold the database connection.
    static Connection connection = null;
//    Method to get database connection.
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        if(connection != null) {
//            If a connection already exist, return it;
            return connection;
        }

//        Database credentials.
        String user = "root";
        String password = "sqlworkbench@123";
        String database = "searchengineapp";

        return getConnection(user, password, database);
    }

//    Private method to establish a new database connection.
    private static Connection getConnection(String user, String password, String database ) throws ClassNotFoundException, SQLException {
//        Load the MySQL JDBC driver.
        Class.forName("com.mysql.cj.jdbc.Driver");
//        Create a new database connection using the provided credentials.
        connection = DriverManager.getConnection("jdbc:mysql://localhost/" +database + "?user=" + user + "&password=" + password);
        return connection;
    }
}