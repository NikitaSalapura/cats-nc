<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<html>
<head>
    <title>All</title>
    <h1><a href="/cats/welcome"><img src="image/logo.png" alt="toWelcomePage"></a></h1>
</head>
<body>
<form action="/cats/getAll" method="post">

    <table class="table">
        <thead class="thead-light">
        <tr>
            <th>Choice</th>
            <th>Id</th>
            <th>Nickname</th>
            <th>Sex</th>
            <th>Color</th>
            <th>Age</th>
            <th>MotherId</th>
            <th>FatherId</th>
        </thead>
        <c:forEach var="cat" items="${container}">

            </tr>
            <td><input type="radio" name="choice" value="${cat.id}" CHECKED></td>
            <td><c:out value="${cat.id}"></c:out></td>
            <td><c:out value="${cat.nickname}"></c:out></td>
            <td><c:out value="${cat.sex}"></c:out></td>
            <td><c:out value="${cat.color}"></c:out></td>
            <td><c:out value="${cat.age}"></c:out></td>
            <td><c:out value="${cat.motherId}"></c:out></td>
            <td><c:out value="${cat.fatherId}"></c:out></td>
            </tr>
        </c:forEach>
    </table>
    <button type="submit" class="btn btn-primary" name="updateButton">Update</button>
    <button type="submit" class="btn btn-danger" name="deleteButton">Delete</button>
</form>
<button onclick="location.href='/cats'" class="btn btn-secondary">Cancel</button>
</body>
</html>
