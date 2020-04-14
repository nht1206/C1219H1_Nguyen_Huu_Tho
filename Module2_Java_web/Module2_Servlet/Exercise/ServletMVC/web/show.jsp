<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/26/2020
  Time: 9:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Yasuo</title>
</head>
<body>
    <%
        boolean isLogin = false;
        if (session.getAttribute("isLogin") != null)
            isLogin = (boolean) session.getAttribute("isLogin");
        if (!isLogin)
            response.sendRedirect("index.jsp");
        String adminname = "";
        if (session.getAttribute("adminname") != null) {
            adminname += (String) session.getAttribute("adminname");
        }
        session.setAttribute("admin", adminname);
    %>
    <img src="images/yasuo.jpg" width="500px" alt="This is yasuo">
    <span>${admin}</span>
</body>
</html>
