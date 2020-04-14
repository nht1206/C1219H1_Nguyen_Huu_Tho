<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/9/2020
  Time: 11:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Product</title>
</head>
<body>
<p>
    <c:if test='${requestScope["message"] != null}'>
        ${requestScope["message"]}
    </c:if>
</p>
<p>
    <a href="product" > Back to list product </a>
</p>
<form method="post" >
    <table>
        <tr>
            <th>Name</th>
            <td><input type="text" name="name" value="${requestScope["product"].getName()}"></td>
        </tr>
        <tr>
            <th>Price</th>
            <td><input type="text" name="price" value="${requestScope["product"].getPrice()}"></td>
        </tr>
        <tr>
            <th>Description</th>
            <td><input type="text" name="description" value="${requestScope["product"].getDescription()}"></td>
        </tr>
        <tr>
            <th>Producer</th>
            <td><input type="text" name="producer" value="${requestScope["product"].getProducer()}"></td>
        </tr>
        <td></td>
        <td><input type="submit" value="Update Product"></td>
    </table>
</form>
</body>
</html>
