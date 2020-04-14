<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/25/2020
  Time: 9:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="common.jsp"%>
<html>
<head>
    <title>Choose with param</title>
</head>
<body>
<c:choose>
    <c:when test="${param.color == 'red'}">
        <p style="color:red;">RED COLOR</p>
    </c:when>
    <c:when test="${param.color == 'blue'}">
        <p style="color:blue;">BLUE COLOR</p>
    </c:when>
    <c:otherwise>
        <b>Other color</b>
    </c:otherwise>
</c:choose>
</body>
</html>
