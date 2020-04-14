<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/25/2020
  Time: 7:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Demo JSTL</title>
</head>
<body>
<h2>c:out example</h2>
<c:out value="Hello Jstl"></c:out>
<br/>
<c:out value="${'This is true: 10 > 1 '}"/>
<br/>
Tag: <c:out value="${'<atag> , &'}"/>
<br/>
<c:set value="Hello from c:set" var="greeting"></c:set>
<c:out value="${greeting}"></c:out>
<br/>
<c:set scope="session" var="salary" value="${2000*2}"></c:set>
<c:out value="${salary}"></c:out>
<c:remove var="salary" scope="session"></c:remove>
<c:remove var="greeting"></c:remove>
<bt/>
<c:out value="${greeting}"></c:out>
<br/>
<c:out value="${salary}"></c:out>

</body>
</html>
