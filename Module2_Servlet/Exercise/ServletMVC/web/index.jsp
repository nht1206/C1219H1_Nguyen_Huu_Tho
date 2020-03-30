<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/26/2020
  Time: 9:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Login</title>
  </head>
  <body>
  <form action="user" style="margin: 0 auto;" method="post">
    <table>
      <tr>
        <th>Username: </th>
        <td><input name="username" type="text"></td>
      </tr>
      <tr>
        <th>Password: </th>
        <td><input name="password" type="password"></td>
      </tr>
      <tr>
        <td><button type="submit">Login</button></td>
      </tr>
    </table>
  </form>
  </body>
</html>
