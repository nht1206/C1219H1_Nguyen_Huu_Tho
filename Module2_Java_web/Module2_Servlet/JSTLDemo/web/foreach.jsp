<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/25/2020
  Time: 9:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Demo foreach</title>
</head>
<body>
<c:forEach var="i" begin="1" end="5">
    <p>Item : ${i}</p>
</c:forEach>
<c:forTokens items="Nguyen Huu Tho" delims=" " var="item">
    ${item}<br/>
</c:forTokens>
</body>
</html>
