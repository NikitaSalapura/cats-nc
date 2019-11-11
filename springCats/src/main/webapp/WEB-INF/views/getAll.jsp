<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<html>
<head>
    <title>All</title>
    <h1><a href="/springCats/"><img src="../images/logo.png" alt="toWelcomePage"></a></h1>
</head>
<body>
<form method="get">

    <table class="table">
        <thead class="thead-light">
        <tr>
            <th>Choice</th>
            <th>Id</th>
            <th>Nickname</th>
            <th>Sex</th>
            <th>Color</th>
            <th>Age</th>
            <th>Mother</th>
            <th>Father</th>
            <th>Action</th>
        </thead>
        <c:forEach var="cat" items="${cats}">

            </tr>
            <td><input type="radio" name="choice" value="${cat.id}" CHECKED></td>
            <td>${cat.id}</td>
            <td>${cat.nickname}</td>
            <td>${cat.sex}</td>
            <td>${cat.color}</td>
            <td>${cat.age}</td>
            <td>${cat.mother.nickname}</td>
            <td>${cat.father.nickname}</td>
            <td>
                <a href="/springCats/update/${cat.id}">
                    <button type="button" class="btn btn-primary" name="updateButton">Update</button>
                </a>
                <a href="/springCats/delete/${cat.id}">
                    <button type="button" class="btn btn-danger" name="deleteButton">Delete</button>
                </a>
            </td>
            </tr>
        </c:forEach>
    </table>
    <%--    <button type="submit" class="btn btn-primary" name="updateButton">Update</button>--%>
    <%--    <button type="submit" class="btn btn-danger" name="deleteButton">Delete</button>--%>
</form>
<button onclick="location.href='/springCats'" class="btn btn-secondary">Cancel</button>
</body>
</html>
