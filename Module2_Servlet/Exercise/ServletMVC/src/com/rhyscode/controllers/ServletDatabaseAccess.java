package com.rhyscode.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "ServletDatabaseAccess", urlPatterns = "/database")
public class ServletDatabaseAccess extends HttpServlet {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    //  Database credentials
    static final String USER = "root";
    static final String PASS = "toor";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title = "Database Result";
        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor = \"#f0f0f0\">\n" +
                "<h1 align = \"center\">" + title + "</h1>\n");
        try {
            //Register driver
            Class.forName(JDBC_DRIVER);
            //Open a connection
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            //Execute SQL Query
            Statement statement = connection.createStatement();
            String sqlQuery = "SELECT id, first, last, age FROM Employees";
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                //Retrieve by column name
                int id  = resultSet.getInt("id");
                int age = resultSet.getInt("age");
                String first = resultSet.getString("first");
                String last = resultSet.getString("last");

                //Display values
                out.println("ID: " + id);
                out.println(", Age: " + age);
                out.println(", First: " + first);
                out.println(", Last: " + last);
                out.println("<br/>");
            }
            out.println("</body></html>");

            // Clean-up environment
            resultSet.close();
            statement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            //finally block used to close resources
        }
    }
}
