<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/9/2020
  Time: 10:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product</title>
</head>
<body>
<p>
    <a href="product">Back to customer list</a>
</p>
<table>
    <c:if test='${requestScope["products"] == null }'>
        <c:out value="Khong tim thay"></c:out>
    </c:if>
    <c:forEach items='${requestScope["products"]}' var="product" >
        <tr>
            <td>Name: </td>
            <td>${product.getName()}</td>
        </tr>
        <tr>
            <td>Price: </td>
            <td>${product.getPrice()}</td>
        </tr>
        <tr>
            <td>Description: </td>
            <td>${product.getDescription()}</td>
        </tr>
        <tr>
            <td>Producer:</td>
            <td>${product.getProducer()}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>