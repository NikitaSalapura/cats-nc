<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<head>
    <title>Searching</title>
    <h1><a href="/"><img src="/resources/images/logo.png" alt="toWelcomePage"></a></h1>
</head>
<body>
<form method="get">
    <table>
        <tr>
            <td><input type="text" name="value" placeholder="Enter a value" class="form-control"></td>

            <%--            TODO beautiful--%>
            <td>
                <%--                <div class="btn-group">--%>
                <%--                    <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown"--%>
                <%--                            aria-haspopup="true" aria-expanded="false">--%>
                <%--                        Action--%>
                <%--                    </button>--%>
                <%--                    <div class="dropdown-menu">--%>
                <%--                        <a class="dropdown-item" href="#">Action</a>--%>
                <%--                        <a class="dropdown-item" href="#">Another action</a>--%>
                <%--                        <a class="dropdown-item" href="#">Something else here</a>--%>
                <%--                        <div class="dropdown-divider"></div>--%>
                <%--                        <a class="dropdown-item" href="#">Separated link</a>--%>
                <%--                    </div>--%>
                <%--                </div>--%>
                <%--            </td>--%>

            <td><select name="field" class="browser-default custom-select">
                <option selected value="id">Id</option>
                <option value="nickname">Nickname</option>
                <option value="color">Color</option>
                <option value="age">Age</option>
            </select></td>
        </tr>
    </table>
    <%--    <button type="submit" class="btn btn-primary" name="searchButton">Search</button>--%>
    <a href="/search/${}">
        <button type="submit" class="btn btn-primary" name="searchButton" >Search</button></a>
</form>
<table class="table">
    <thead class="thead-light">
    <tr>
        <%--        <td></td>--%>
        <th>Id</th>
        <th>Nickname</th>
        <th>Sex</th>
        <th>Color</th>
        <th>Age</th>
        <th>MotherId</th>
        <th>FatherId</th>
    </thead>
    <c:forEach var="cat" items="${cats}">

        </tr>
        <%--        <td><input type="radio" name="choice" value="${cat.id}" CHECKED></td>--%>
        <td>${cat.id}</td>
        <td>${cat.nickname}></td>
        <td>${cat.sex}</td>
        <td>${cat.color}</td>
        <td>${cat.age}</td>
        <td>${cat.mother.nickname}</td>
        <td>${cat.father.nickname}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
