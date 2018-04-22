<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>students</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/font-awesome.min.css">
    <style>
        .pageInput {
            width: 4em;
            text-align: center;
        }
    </style>
</head>


<body>
<%@include file="_navbar.jspf" %>
<div class="container">
    <div class="row">
<table  class = "table table-striped">
    <thead class="thead-dark">
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Name</th>
        <th scope="col">Middle Name</th>
        <th scope="col">Surname</th>
        <th scope="col">Date of birth</th>
        <th scope="col">Group</th>
        <th scope="col"></th>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${students}" var="it">
    <tr title="Students">
        <td title="ID">${it.id}</td>
        <td title="NAME">${it.name}</td>
        <td title="MIDDLE_NAME">${it.middle_name}</td>
        <td title="SURNAME">${it.surname}</td>
        <td title="DATE_OF_BIRTH">${it.date_of_birth}</td>
        <td title="GROUP">${it.group_name}</td>
        <td>
            <a class="btn btn-danger" onclick="deleteIt(${it.id})">Delete</a>
        </td>
    </tr>
    </c:forEach>
    </tbody>
</table>
<br>
    </div>
    <div class="row justify-content-center">
        <button id="prev" class="btn btn-secondary" onclick="prevPage()" ${ page == 0 ? "disabled" : "" }> &lt;</button>
        <input type="text" class="pageInput form-control" onchange="onChange(this)" value="${page+1} ">

        <input type="text" class="pageInput form-control" value="${allPages}" disabled/>
        <button onclick="nextPage()" id="next" class="btn btn-secondary" ${ page == allPages - 1 ? "disabled" : "" }>&gt;</button>
    </div>
</div>


<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>

<script>
    var page = ${page};
    var allPages = ${allPages};
</script>
<script src="/js/app.js"></script>




</body>
</html>