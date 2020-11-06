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
<p>Person Step1</p>
<form action="/person/step2" method="post">
    <input name="firstName" value="${person.firstName}" >
    <input type="hidden" value="${person.id}" name="id">
    <input type="submit" value="submit">
</form>

</body>
</html>
