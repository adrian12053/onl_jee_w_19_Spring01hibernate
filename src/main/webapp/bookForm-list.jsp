<%--
  Created by IntelliJ IDEA.
  User: koszkuld
  Date: 16/04/2023
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List all books</title>
</head>
<body>

<c:forEach items="${books}" var="book">
    ${book.title} </br>
</c:forEach>

</body>
</html>
