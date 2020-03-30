<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/25/2020
  Time: 9:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="common.jsp"%>
<html>
<head>
    <title>Demo choose</title>
</head>
<body>
<c:set var = "salary" scope = "session" value = "${2000*2}"/>
<p>Your salary is : <c:out value = "${salary}"/></p>
<c:choose>
    <c:when test = "${salary <= 0}">
        Salary is very low to survive.
    </c:when>
    <c:when test = "${salary > 1000}">
        Salary is very good.
    </c:when>
    <c:otherwise>
        No comment sir...
    </c:otherwise>
</c:choose>
</body>
</html>
