package org.example;

import org.jsoup.nodes.Document;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Indexer {
    static Connection connection = null;
//    Constructor to index a web page's content and store it in the database.
    Indexer(Document document, String url) {
//        Select important elements of document.
        String title = document.title();
        String link = url;
        String text = document.text();

        try {
//            Get a database connection.
            connection = DatabaseConnection.getConnection();

//            Prepare a SQL statement to insert the page's data into the 'pages' table.
            PreparedStatement preparedStatement = connection.prepareStatement("Insert into pages values(?,?,?);");
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, link);
            preparedStatement.setString(3, text);

//            Execute the SQL statement to save the page's data to the database.
            preparedStatement.executeUpdate();
        }catch (SQLException | ClassNotFoundException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
