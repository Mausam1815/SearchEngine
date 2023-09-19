package com.SearchEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/Search")
public class Search extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        Get the search keyword from the request parameters.
        String keyword = request.getParameter("keyword");
//        Initialize a database connection.
        Connection connection = null;
        try {
            connection = DatabaseConnection.getConnection();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
//            Insert the search keyword and URL into the 'history' table.
            PreparedStatement preparedStatement = connection.prepareStatement("Insert into history values(?, ?);");
            preparedStatement.setString(1, keyword);
            preparedStatement.setString(2, "http://localhost:8080/SearchEngine/Search?keyword=" + keyword);
            preparedStatement.executeUpdate();
//            Execute a SQL query to search for pages containing the keyword.
            ResultSet resultSet = connection.createStatement().executeQuery("select pageTitle, pageLink, (length(lower(pageText))-length(replace(lower(pageText), '"+ keyword.toLowerCase() +"', ''))) / length('"+ keyword.toLowerCase() +"') as countoccurence from pages order by countoccurence desc limit 30;");
            ArrayList<SearchResult> results = new ArrayList<>();
//            Process the search results.
            while(resultSet.next()) {
                SearchResult searchResult = new SearchResult();
                searchResult.setTitle(resultSet.getString("pageTitle"));
                searchResult.setLink(resultSet.getString("pageLink"));
                results.add(searchResult);
            }
//            Display the search results in the console (for debugging).
            for(SearchResult result : results) {
                System.out.println(result.getTitle()+"\n"+result.getLink()+" \n");
            }
//            Set the search results as an attribute and forward the request to the 'Search.jsp' page.
            request.setAttribute("results", results);
            request.getRequestDispatcher("Search.jsp").forward(request, response);
//            Set the content type for the response.
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
        } catch (SQLException | ServletException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
