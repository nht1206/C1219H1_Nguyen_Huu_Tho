<%@include file="common.jsp"%>
<html>
<head>
    <title>c:catch</title>
</head>
<body>
<c:catch var="ex">
    <%
        int a = 100/0;
    %>
</c:catch>
<c:if test="${ex != null}">
    Exception : ${ex}
    <br />
    Message: ${ex.message}
</c:if>
</body>
</html>
