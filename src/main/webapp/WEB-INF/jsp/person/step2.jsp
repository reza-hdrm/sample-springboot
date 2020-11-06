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
<p>Person Step2</p>

<input name="firstName" value="${sessionScope.person.firstName}">
<input type="hidden" value="${sessionScope.person}" name="id">

</body>
</html>
