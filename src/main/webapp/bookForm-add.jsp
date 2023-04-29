<%--
  Created by IntelliJ IDEA.
  User: koszkuld
  Date: 16/04/2023
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add new book</title>
    <style>
        error {

        }
    </style>
</head>
<body>

<form:form action="/bookForm" method="POST" modelAttribute="book">
    <label for="title">Title</label>
    <form:input path="title" id="title"/>
    <form:errors path="title"/>
    </br>

    <label for="rating">Rating</label>
    <form:input path="rating" type="number" id="rating"/></br>

    <label for="description">Description</label>
    <form:input path="description" id="description"/></br>

    <label for="publishers">Publishers</label>
    <form:select path="publisher.id"
                 items="${publishers}"
                 itemLabel="name"
                 itemValue="id"
                 id="publishers"
    />

    <br>
    <form:errors path="*"/>

    <input type="submit">
</form:form>

</body>
</html>
