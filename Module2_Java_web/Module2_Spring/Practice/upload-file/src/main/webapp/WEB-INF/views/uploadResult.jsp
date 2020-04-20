<%--
  Created by IntelliJ IDEA.
  User: macbook
  Date: 14/04/2020
  Time: 11:42 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Upload Result</title>
</head>
<body>
<jsp:include page="_menu.jsp"/>

<h3>Uploaded Files:</h3>

Description: ${description}

<br/>

<c:forEach items="${uploadedFiles}" var="file">
    - ${file} <br>
</c:forEach>

</body>
</html>
