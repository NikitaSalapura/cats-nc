<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<html>
<head>
    <title>Making</title>
    <h1><a href="/springCats/"><img src="image/logo.png" alt="toWelcomePage"></a></h1>
</head>
<body>
<p>
<form:form action="/springCats/create" method="post" modelAttribute="cat">
<%--    <c:choose>--%>
<%--        <c:when test="${cat.id == 0}">--%>
<%--            <c:set var="id" value="generated"></c:set></c:when>--%>
<%--        <c:otherwise><c:set var="id" value="${cat.id}"></c:set></c:otherwise>--%>
<%--    </c:choose>--%>
    <table>
        <%--                <colgroup style="background-color: #ddd;">--%>
        <%--                    <col>--%>
        <%--                    <col style="background-color: #ccc;">--%>
        <%--                    <col>--%>
        <%--                </colgroup>--%>
        <tbody>
        <tr>
            <td>Id</td>
            <td><input type="text" name="id" value="${cat.id}" readonly class="form-control"/></td>
        </tr>
        <tr>
            <td>Nickname</td>
            <td><form:input type="text" name="nickname" placeholder="nickname" class="form-control" path="nickname"/></td>
        </tr>
        <tr>
            <td>Sex</td>
            <td><%--todo--%>
                <div class="custom-control custom-radio custom-control-inline">
                    <form:radiobutton id="customRadioInline1" name="sex" value="MALE" class="custom-control-input"
                             path="sex"/>
                    <label class="custom-control-label" for="customRadioInline1">Male</label>
                </div>
                <div class="custom-control custom-radio custom-control-inline">
                    <form:radiobutton path="sex" id="customRadioInline2" name="sex" value="FEMALE" class="custom-control-input"/>
                    <label class="custom-control-label" for="customRadioInline2">Female</label>
                </div>
            </td>
        </tr>
        <tr>
            <td>Color</td>
            <td><form:input type="text" name="color" placeholder="color" class="form-control" path="color"/></td>
        </tr>
        <tr>
            <td>Age</td>
            <td><form:input type="text" name="age" placeholder="age" class="form-control" path="age"/></td>
        </tr>
    <%--todo parents--%>
        <tr>
            <td>Mother</td>
        <%--            <td>--%>
        <%--                <select name="motherId">--%>
        <%--                    <option selected value="0">Undefined</option>--%>
        <%--                    <option value="1">2</option>--%>
        <%--                </select>--%>
        <%--            </td>--%>
<%--            <td><form:input type="text" name="motherId" placeholder="motherId" class="form-control" path="mother"/></td>--%>
            <td><input type="text" name="motherId" placeholder="motherId" class="form-control"></td>
        </tr>
        <tr>
            <td>Father</td>
            <td><input type="text" name="fatherId" placeholder="fatherId" class="form-control"></td>
        </tr>
        </tbody>
    </table>

    <button type="submit" name="createButton" class="btn btn-success">Ok</button>
    <%--    <input type="button" name="createButton" value="create">--%>
</form:form>
<button onclick="location.href='/springCats'" class="btn btn-secondary">Cancel</button>
</p>
</body>
</html>