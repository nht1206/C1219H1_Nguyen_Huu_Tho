<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/9/2020
  Time: 11:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Product</title>
</head>
<body>
<h1>PRODUCTS</h1>
<p>
    <a href="/product?action=create">Create new product</a>
</p>
<p>
    <a href="/product?action=findById">Find By Id</a>
</p>
<p>
    <a href="/product?action=search">Find By Name</a>
</p>
<table border="1">
    <tr>
        <th>Name</th>
        <th>Price</th>
        <th>Description</th>
        <th>Producer</th>
        <th></th>
        <th></th>
    </tr>
    <c:forEach items='${requestScope["products"]}' var="product">
        <tr>
            <td><a href="product?action=view&id=${product.getId()}">${product.getName()}</a></td>
            <td>${product.getPrice()}</td>
            <td>${product.getDescription()}</td>
            <td>${product.getProducer()}</td>
            <td><a href="product?action=update&id=${product.getId()}">Update</a> </td>
            <td><a href="product?action=delete&id=${product.getId()}">Delete</a> </td>
        </tr>

    </c:forEach>

</table>
</body>
</html>