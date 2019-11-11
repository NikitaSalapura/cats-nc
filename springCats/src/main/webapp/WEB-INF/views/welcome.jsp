<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cats repository!</title>
    <h1><a href="/springCats"><img src="/resources/images/logo.png" alt="toWelcomePage"></a></h1>
<%--    <h1><a href="/springCats"><img src="<c:url value='/images/logo.png'/>" alt="toWelcomePage"></a></h1>--%>
</head>
<body>
<!-- header -->
<div>
    <h1>Welcome! Choose your action:</h1>
</div>

<div> <!-- content -->
    <div> <!-- buttons holder -->
        <button onclick="location.href='/springCats/getAll'" class="btn btn-primary">Show all cats</button>
        <button onclick="location.href='/springCats/create'" class="btn btn-success">Create</button>
        <button onclick="location.href='/springCats/search'" class="btn btn-warning">Search cats</button>
    </div>
</div>
</body>
</html>
