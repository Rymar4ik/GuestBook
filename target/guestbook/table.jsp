<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <meta charset="utf-8"/>
    <title>Таблица с данными</title>
    <meta name="viewport" content="initial-scale=1.0; maximum-scale=1.0; width=device-width;">

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          crossorigin="anonymous">

    <link href="http://fonts.googleapis.com/css?family=Roboto:400,500,700,300,100" rel="stylesheet">

    <!--Font Awesome (added because you use icons in your prepend/append)-->
    <link rel="stylesheet" href="https://formden.com/static/cdn/font-awesome/4.4.0/css/font-awesome.min.css"/>


    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js" crossorigin="anonymous"></script>

    <style> <%@include file="/resources/css/style.css" %> </style>
    <style> <%@include file="/resources/css/table.css" %> </style>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="navbar-header">
        <a href="#" class="navbar-brand"><img src="resources/logo.png"></a>
    </div>
    <!-- Содержимое меню (коллекция навигационных ссылок, формы и др.) -->
    <div class="collapse navbar-collapse" id="main-menu">
        <!-- Список ссылок, расположенных слева -->
        <ul class="nav navbar-nav">
            <!--Элемент с классом active отображает ссылку подсвеченной -->
            <li><a href="\">Главная</a></li>
            <li><a href="\ShowInfo">Таблица с данными гостей</a></li>
        </ul>
    </div>
</nav>

<div class="table-title">
    <h3>Информация о пользователях</h3>
</div>
<table class="table-fill">
    <thead>
    <tr>
        <th class="text-left">Имя</th>
        <th class="text-left">Фамилия</th>
        <th class="text-left">Дата рождения</th>
        <th class="text-left">Номер телефона</th>
        <th class="text-left">Email</th>
        <th class="text-left">Страна</th>
        <th class="text-left">Город\Область</th>
    </tr>
    </thead>
    <tbody class="table-hover">
    <tr>
        <c:forEach items="${rows}" var="row">
    <tr>
        <td class="text-left">${row.name}</td>
        <td class="text-left">${row.surname}</td>
        <td class="text-left">${row.birthday}</td>
        <td class="text-left">${row.number}</td>
        <td class="text-left">${row.email}</td>
        <td class="text-left">${row.country}</td>
        <td class="text-left">${row.region}</td>
    </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
