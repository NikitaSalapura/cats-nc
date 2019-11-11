<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cats repository!</title>
    <h1><a href="/"><img src="/resources/images/logo.png" alt="toWelcomePage"></a></h1>

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
<!-- header -->
<div>
    <h1>Welcome! Choose your action:</h1>
</div>

<div> <!-- content -->
    <div> <!-- buttons holder -->
        <button onclick="location.href='/getAll'" class="btn aqua-gradient  ">Show all cats</button>
        <button onclick="location.href='/create'" class="btn peach-gradient">Create</button>
        <button onclick="location.href='/search'" class="btn purple-gradient" disabled>Search cats</button>
    </div>
</div>
</body>
</html>
