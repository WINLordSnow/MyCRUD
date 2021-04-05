<%@ page import="java.util.List" %>
<%@ page import="CRUD.model.User" %>
<%@ page import="org.springframework.context.ApplicationContext" %><%--
  Created by IntelliJ IDEA.
  User: WIN_LordSnow
  Date: 04.04.2021
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%

%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
<html lang="en">
<head>
    <title>All users</title>
    <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>

<input id="back" type="button" name="back" value=${users}>

<input id="toAllUsers" type="button" name="page" value="All Users">
<div>
    <th:block th:each="msg : ${users}">
        <h1 th:text="${msg}"></h1>
    </th:block>
</div>
</body>
</html>
