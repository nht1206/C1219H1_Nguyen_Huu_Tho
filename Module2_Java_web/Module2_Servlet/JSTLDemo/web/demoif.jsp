<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/25/2020
  Time: 9:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Demo if</title>
</head>
<body>
<c:set var="salary" scope="request" value="${50000}"></c:set>
<c:if test="${salary > 2000}">
    My salary is: ${salary}
</c:if>
</body>
</html>
