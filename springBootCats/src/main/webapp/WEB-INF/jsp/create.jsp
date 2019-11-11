<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<html>
<head>
    <title>Making</title>
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
<p>
    <form:form action="/create" method="post" modelAttribute="cat" class="needs-validation" novalidate="novalidate">
        <%--    <c:choose>--%>
        <%--        <c:when test="${cat.id == 0}">--%>
        <%--            <c:set var="id" value="generated"></c:set></c:when>--%>
        <%--        <c:otherwise><c:set var="id" value="${cat.id}"></c:set></c:otherwise>--%>
        <%--    </c:choose>--%>
<table>
    <tbody>
    <c:if test="${cat.id != 0}">
        <tr>
            <td>Id</td>
            <td><input type="text" name="id" value="${cat.id}" readonly class="form-control"/></td>
        </tr>
    </c:if>
    <tr>
        <td>Nickname</td>
        <td>
            <div>
                <form:input type="text" name="nickname" placeholder="nickname" class="form-control"
                            path="nickname" pattern="^[a-zA-Z]+$" required="required"/>
                <div class="invalid-feedback">
                    Fill nickname(only Latin), please
                </div>
            </div>
                <%--            <div>--%>
                <%--                <form:input type="text" name="nickname" placeholder="nickname" class="form-control"--%>
                <%--                            path="nickname" pattern="^[a-zA-Z]+$" required="required"--%>
                <%--                            oninvalid="this.setCustomValidity('Fill nickname(only Latin), please')"--%>
                <%--                            oninput="setCustomValidity('')"/>--%>
                <%--                --%>
                <%--            </div>--%>
        </td>
    </tr>
    <tr>
        <td>Sex</td>
        <td>
            <div>
                <div class="custom-control custom-radio custom-control-inline">
                    <form:radiobutton id="customRadioInline1" name="sex" value="MALE" class="custom-control-input"
                                      path="sex" required="required"/>
                    <label class="custom-control-label" for="customRadioInline1">Male</label>
                </div>
                <div class="custom-control custom-radio custom-control-inline">
                    <form:radiobutton path="sex" id="customRadioInline2" name="sex" value="FEMALE"
                                      class="custom-control-input" required="required"/>
                    <label class="custom-control-label" for="customRadioInline2">Female</label>
                </div>
                <div class="invalid-feedback">
                    Choose sex, please
                </div>
            </div>
        </td>
    </tr>
    <tr>
        <td>Color</td>
        <td>
            <div>
                <form:input type="text" name="color" placeholder="color" class="form-control" path="color"
                            pattern="^[a-zA-Z]+$" required="required"/>
                <div class="invalid-feedback">
                    Fill color(only Latin), please
                </div>
            </div>
        </td>
    </tr>
    <tr>
        <td>Age</td>
        <td>
            <div><form:input type="text" name="age" placeholder="age" class="form-control" path="age"
                             pattern="^[ 0-9]+$" required="required"/>
                <div class="invalid-feedback">
                    Fill integer age, please
                </div>
            </div>
        </td>
    </tr>
        <%--todo parents--%>
    <tr>
            <%--            <td>--%>
            <%--                <select name="motherId">--%>
            <%--                    <option selected value="0">Undefined</option>--%>
            <%--                    <option value="1">2</option>--%>
            <%--                </select>--%>
            <%--            </td>--%>
            <%--            <td><form:input type="text" name="motherId" placeholder="motherId" class="form-control" path="mother"/></td>--%>
        <div class="input-group mb-3">
            <td>
                <div class="input-group-prepend">
                    <label class="input-group-text" for="inputGroupSelectMother">Mother</label>
                </div>
            </td>
            <td>
                <select class="custom-select" id="inputGroupSelectMother">
                    <option selected>Choose</option>
                    <c:forEach var="mother" items="${mothers}">
                        <option>${mother.nickname}(id = ${mother.id})</option>
                    </c:forEach>
                </select>
                    <%--                <form:select class="custom-select" id="inputGroupSelectMother" path="mother">--%>
                    <%--                <option selected>Choose</option>--%>
                    <%--                <c:forEach var="mother" items="${mothers}">--%>
                    <%--                <option>${mother.nickname}(id = ${mother.id})</option>--%>
                    <%--                </c:forEach>--%>
                    <%--                </form:select>--%>
        </div>
        </td>
            <%--        <td><input type="text" name="motherId" placeholder="motherId" class="form-control"></td>--%>
    </tr>
    <tr>
        <div class="input-group mb-3">
            <td>
                <div class="input-group-prepend">
                    <label class="input-group-text" for="inputGroupSelectFather">Father</label>
                </div>
            </td>
            <td>
                <select class="custom-select" id="inputGroupSelectFather">
                    <option selected>Choose</option>
                    <c:forEach var="father" items="${fathers}">
                        <option>${father.nickname}(id = ${father.id})</option>
                    </c:forEach>
                </select>
        </div>
        </td>
    </tr>
    </tbody>
</table>
<div>
    <button type="submit" name="createButton" class="btn aqua-gradient">Ok</button>
        <%--    <input type="button" name="createButton" value="create">--%>
    </form:form>
    <button onclick="location.href='/'" class="btn purple-gradient">Cancel</button>
</div>
</body>

<script type="text/javascript">
    (function () {
        'use strict';
        window.addEventListener('load', function () {
// Fetch all the forms we want to apply custom Bootstrap validation styles to
            var forms = document.getElementsByClassName('needs-validation');
// Loop over them and prevent submission
            var validation = Array.prototype.filter.call(forms, function (form) {
                form.addEventListener('submit', function (event) {
                    if (form.checkValidity() === false) {
                        event.preventDefault();
                        event.stopPropagation();
                    }
                    form.classList.add('was-validated');
                }, false);
            });
        }, false);
    })();

</script>
</html>