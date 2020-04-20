<%--
  Created by IntelliJ IDEA.
  User: macbook
  Date: 13/04/2020
  Time: 11:32 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Calculator</h1>
<form method="post" action="/calculated">
    <table>
        <tr>
            <td colspan="2"><input name="value1" value="${value1}"/></td>
            <td colspan="2"><input name="value2" value="${value2}"/></td>
        </tr>
        <tr>
            <td><input type="submit" name="operator" value="+"></td>
            <td><input type="submit" name="operator" value="-"></td>
            <td><input type="submit" name="operator" value="*"></td>
            <td><input type="submit" name="operator" value="/"></td>
        </tr>
    </table>
</form>
<h2>${value1} ${operator} ${value2} = ${result}</h2>
</body>
</html>
