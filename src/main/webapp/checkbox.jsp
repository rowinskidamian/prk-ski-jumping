<%--
  Created by IntelliJ IDEA.
  User: damian
  Date: 04.05.2021
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>CheckBox</title>
</head>
<body>

<form method="post">
    Opcje:<br>
    <c:forEach items="${options}" var="option">
        <input lang="option" type="checkbox" name="options" value="${option}"> ${option}
    </c:forEach>
    <input type="submit" value="Send">
</form>

</body>
</html>
