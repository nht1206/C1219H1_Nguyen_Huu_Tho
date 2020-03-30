package com.rhyscode.controllers;

import com.rhyscode.models.DatabaseManagement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ServletUser")
public class ServletUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        DatabaseManagement databaseManagement = new DatabaseManagement();
        boolean isLogin = databaseManagement.checkUser(username, password);
        if (isLogin) {
            HttpSession session = request.getSession();
            session.setAttribute("isLogin", isLogin);
            session.setMaxInactiveInterval(10);
            response.sendRedirect("show.jsp");
        } else {
            response.sendRedirect("index.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
