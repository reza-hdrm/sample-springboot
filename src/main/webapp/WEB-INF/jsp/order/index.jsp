<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <title>Order Home</title>
</head>
<body>
Welcome reza
<table border="1">

    <tr>
        <th>id</th>
        <th>name</th>
        <th>link</th>
    </tr>


    <c:forEach var="order" items="${orders}">
        <tr>
            <td>${order.id}</td>
            <td>${order.name}</td>
            <td><a href="order/detail?id=${order.id}">show</a></td>
        </tr>
    </c:forEach>

</table>
</body>
</html>