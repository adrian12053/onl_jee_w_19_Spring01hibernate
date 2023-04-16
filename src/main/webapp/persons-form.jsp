<%--
  Created by IntelliJ IDEA.
  User: koszkuld
  Date: 16/04/2023
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Form 1</title>
</head>
<body>

<%--<form action="/persons" method="POST">--%>
<%--    Login: <input type="text" name="login"> </br>--%>
<%--    Password: <input type="password" name="password"> </br>--%>
<%--    Email: <input type="email" name="email"> </br>--%>
<%--    <input type="submit">--%>
<%--</form>--%>

<form:form action="/persons" method="POST" modelAttribute="person">
    Login: <form:input path="login"/> </br>
    Password: <form:password path="password"/> </br>
    Email: <form:input path="email"/> </br>
    <input type="submit">
</form:form>


</body>
</html>
