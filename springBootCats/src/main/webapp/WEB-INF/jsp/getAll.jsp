<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<html>
<head>
    <title>All</title>
    <h1><a href="/"><img src="/resources/images/logo.png" alt="toWelcomePage"></a></h1>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
    <!-- Bootstrap core CSS -->
    <link href="/resources/mdb/css/bootstrap.min.css" rel="stylesheet">
    <!-- Material Design Bootstrap -->
    <link href="/resources/mdb/css/mdb.min.css" rel="stylesheet">
    <!-- Your custom styles (optional) -->
    <link href="/resources/mdb/css/style.css" rel="stylesheet">
</head>
<body>
<form method="get">

    <table class="table">
        <thead class="thead-light">
        <tr>
            <%--            <th>Choice</th>--%>
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
            <%--            <td><input type="radio" name="choice" value="${cat.id}" CHECKED></td>--%>
            <td>${cat.id}</td>
            <td>${cat.nickname}</td>
            <td>${cat.sex}</td>
            <td>${cat.color}</td>
            <td>${cat.age}</td>
            <td>${cat.mother != null? cat.mother.nickname + "(id = " + cat.mother.id + ")":"Unknown"}</td>
            <td>${cat.father != null? cat.father.nickname + "(id = " + cat.father.id + ")":"Unknown"}</td>
            <%--            <td>${cat.father != null? {cat.father.nickname}:"Unknown"}</td>--%>
            <td>
                <a href="/update/${cat.id}">
                    <button type="button" class="btn peach-gradient" name="updateButton">Update</button>
                </a>
                <a href="/delete/${cat.id}">
                    <button type="button" class="btn blue-gradient" name="deleteButton">Delete</button>
                </a>
            </td>
            </tr>
        </c:forEach>
    </table>
    <%--    <button type="submit" class="btn btn-primary" name="updateButton">Update</button>--%>
    <%--    <button type="submit" class="btn btn-danger" name="deleteButton">Delete</button>--%>
</form>
<button onclick="location.href='/'" class="btn purple-gradient">Back</button>
</body>
</html>
