package com.SearchEngine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    static Connection connection = null;
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        if(connection != null) {
            return connection;
        }

        String user = "root";
        String password = "sqlworkbench@123";
        String database = "searchengineapp";

        return getConnection(user, password, database);
    }
    private static Connection getConnection(String user, String password, String database ) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost/" +database + "?user=" + user + "&password=" + password);
        return connection;
    }
}