<%--
  Created by IntelliJ IDEA.
  User: WIN_LordSnow
  Date: 03.04.2021
  Time: 9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавляем пользователя</title>
    <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>

<p class="text-center">
    <input id="nameUser" type="text" class="form-control">
</p>
<p class="text-center">
    <input id="lastNameUser" type="text" class="form-control">
</p>


<input id="addUser" type="button" name="addUser" value="Добавить пользователя">
<input id="back" type="button" name="back" value="Назад">
<script>
    $('#nameUser').val('Имя пользователя');

    $('#nameUser').focus(function () {
        $(this).select()
    })
    $('#lastNameUser').val('Фамилия пользователя');

    $('#lastNameUser').focus(function () {
        $(this).select()
    })
    $('#addUser').click( function () {
        $.get("add", {name: $('#nameUser').val(), lastName: $('#lastNameUser').val()})
        .done(function (data) {
            alert(data)
        })
    })
    $('#back').click(function () {
        $(location).attr("href", "/")
    })
</script>
</body>
</html>
