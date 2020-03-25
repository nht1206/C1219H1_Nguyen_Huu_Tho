<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/25/2020
  Time: 9:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Display Discount</title>
</head>
<body>
<h1>Product Discount Calculator</h1>
<form method="post" action="displayDiscount.jsp">
    <%
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));
        int discountPercent = Integer.parseInt(request.getParameter("discountPercent"));
        double discountAmount = price * discountPercent/100;
        double newPrice = price - discountAmount;
    %>
    <table>
        <tr>
            <th>
                <label>Product Description:</label>
            </th>
            <th>
                <%=description%>
            </th>
        </tr>
        <tr>
            <th>
                <label>List Price:</label>
            </th>
            <th>
                <%=price%>$
            </th>
        </tr>
        <tr>
            <th>
                <label>Discount Percent(%):</label>
            </th>
            <th>
                <%=discountPercent%>%
            </th>
        </tr>
        <tr>
            <th>
                <label>Discount Amount:</label>
            </th>
            <th>
                <%=discountAmount%>$
            </th>
        </tr>
        <tr>
            <th>
                <label>Discount Price:</label>
            </th>
            <th>
                <%=newPrice%>$
            </th>
        </tr>
    </table>
</form>
</div>
</body>
</html>
