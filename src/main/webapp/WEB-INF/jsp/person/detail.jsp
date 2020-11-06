<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 9/3/20
  Time: 11:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Person Update</p>
<c:if test="${not empty message}">
    <h1>the massage is : ${message}</h1>
</c:if>
<c:if test="${not empty errors}">
    <c:forEach items="${errors}" var="error">
        ${error.objectName}:${error.defaultMessage}
    </c:forEach>
</c:if>
<form action="/person/update" method="post">
    <input name="firstName" value="${person.firstName}" >
    <input type="hidden" value="${person.id}" name="id">
    <input type="submit" value="submit">
</form>

</body>
</html>
