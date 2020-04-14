<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/25/2020
  Time: 9:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List customer</title>
</head>
<body>
<%!
    public class Customer {
        private String name;
        private String address;
        private String birthday;
        private String urlImage;

        public Customer(String name, String address, String birthday, String urlImage) {
            this.name = name;
            this.address = address;
            this.birthday = birthday;
            this.urlImage = urlImage;
        }

        public String getName() {
            return name;
        }

        public String getAddress() {
            return address;
        }

        public String getBirthday() {
            return birthday;
        }

        public String getUrlImage() {
            return urlImage;
        }
    }
%>
<%
    List<Customer> customerList = new ArrayList<>();
    customerList.add(new Customer("Nguyen Huu Tho", "Quang Tri", "12/06/1999", "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSUzh9GTCoXmTxQPcC-SFTxW_cM9czO0QZCoRFaOS7plnDO9vdX"));
    customerList.add(new Customer("Nguyen Huu Tho", "Quang Tri", "12/06/1999", "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSUzh9GTCoXmTxQPcC-SFTxW_cM9czO0QZCoRFaOS7plnDO9vdX"));
    customerList.add(new Customer("Nguyen Huu Tho", "Quang Tri", "12/06/1999", "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSUzh9GTCoXmTxQPcC-SFTxW_cM9czO0QZCoRFaOS7plnDO9vdX"));
    customerList.add(new Customer("Nguyen Huu Tho", "Quang Tri", "12/06/1999", "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSUzh9GTCoXmTxQPcC-SFTxW_cM9czO0QZCoRFaOS7plnDO9vdX"));
    customerList.add(new Customer("Nguyen Huu Tho", "Quang Tri", "12/06/1999", "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSUzh9GTCoXmTxQPcC-SFTxW_cM9czO0QZCoRFaOS7plnDO9vdX"));
    request.setAttribute("customers", customerList);
%>
<table style="width:500px">
    <tr>
        <th>Name</th>
        <th>Address</th>
        <th>Birthday</th>
        <th>Img</th>
    </tr>
    <c:out value=""></c:out>
    <c:forEach items="${customers}" var="customer">
        <tr>
            <td>${customer.name}</td>
            <td>${customer.address}</td>
            <td>${customer.birthday}</td>
            <td><img style="width: 50px; height: 50px" src="<c:out value="${customer.urlImage}"></c:out>" alt="profile"></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
