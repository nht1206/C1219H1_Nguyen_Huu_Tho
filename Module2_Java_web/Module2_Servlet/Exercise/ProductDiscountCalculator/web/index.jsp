<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/25/2020
  Time: 9:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Product Discount Calculator</title>
</head>
<body>
<div id="content">
    <h1>Product Discount Calculator</h1>
    <form method="post" action="displayDiscount.jsp">
        <table>
            <tr>
                <th>
                    <label>Product Description:</label>
                </th>
                <th>
                    <input type="text" name="description"/>
                </th>
            </tr>
            <tr>
                <th>
                    <label>List Price:</label>
                </th>
                <th>
                    <input type="text" name="price"/>
                </th>
            </tr>
            <tr>
                <th>
                    <label>Discount Percent(%):</label>
                </th>
                <th>
                    <input type="text" name="discountPercent"/>
                </th>
            </tr>
            <tr>
                <th>
                    <div id="buttons">
                        <label>&nbsp;</label>
                        <input type="submit" value="Calculate Discount"/>
                    </div>
                </th>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
