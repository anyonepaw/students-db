<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <title>Create student</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/font-awesome.min.css">
</head>
<body>
<%@include file="_navbar.jspf" %>
<div class="container">
    <form method="post" action="${actionUrl}">
<br>
    <br>
    <br>
    <div class="form-group row">
        <label for="Name" class="col-sm-2 col-form-label">Name </label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="Name" name="Name" value="Иван">
        </div>
    </div>
    <div class="form-group row">
        <label for="Middle_name" class="col-sm-2 col-form-label">Middle name </label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="Middle_name" name="Middle_name" value="Иванович">
        </div>
    </div>
    <div class="form-group row">
        <label for="Surname" class="col-sm-2 col-form-label">Surname </label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="Surname" name="Surname" value="Иванов">
        </div>
    </div>
    <div class="form-group row">
        <label for="Date_of_birth" class="col-sm-2 col-form-label">Date of birth </label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="Date_of_birth" name="Date_of_birth" value="DD/MM/YYYY">
        </div>
    </div>

    <div class="form-group row">
        <label for="Group" class="col-sm-2 col-form-label">Group </label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="Group" name="Group" value="ИТ1801">
        </div>
    </div>

    <input type="submit" class="btn btn-primary" value="Create student">
    </form>
</div>
</body>
</html>