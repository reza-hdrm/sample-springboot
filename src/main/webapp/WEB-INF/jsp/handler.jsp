<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 9/4/20
  Time: 12:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Error Page</h1>
<p>Application hs encountered an error. Please contact support on ...</p>
Failed URL:${url} <br>
Exception: ${exception.massage}<br>
<c:forEach items="${exception.stackTrace}" var="ste">
    ${ste}
</c:forEach>
</body>
</html>
