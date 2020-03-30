package com.rhyscode.controllers;

import com.rhyscode.models.DatabaseManagement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletAuthentication")
public class ServletAuthentication extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = getServletContext().getInitParameter("username");
        String password = getServletContext().getInitParameter("password");
        DatabaseManagement databaseManagement = new DatabaseManagement();
        boolean isLogin = databaseManagement.checkUser(username, password);
        if (isLogin) {
            request.setAttribute("isLogin", isLogin);
            System.out.println(getServletConfig().getInitParameter("adminname"));
            request.setAttribute("adminname", getServletConfig().getInitParameter("adminname"));
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("show.jsp");
            requestDispatcher.forward(request, response);
        } else {
            response.sendRedirect("index.jsp");
        }
    }
}
