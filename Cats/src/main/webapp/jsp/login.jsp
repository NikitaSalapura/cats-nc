<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<html>
<head>
    <title>Authorization</title>
</head>
<body>
<%--&lt;%&ndash;<form class="dropdown-menu p-4">&ndash;%&gt;--%>
<%--    <div class="form-group">--%>
<%--        <label for="exampleDropdownFormEmail2">Email address</label>--%>
<%--        <input type="email" class="form-control" id="exampleDropdownFormEmail2" placeholder="login">--%>
<%--    </div>--%>
<%--    <div class="form-group">--%>
<%--        <label for="exampleDropdownFormPassword2">Password</label>--%>
<%--        <input type="password" class="form-control" id="exampleDropdownFormPassword2" placeholder="password">--%>
<%--    </div>--%>
<%--    <div class="form-group">--%>
<%--        <div class="form-check">--%>
<%--            <input type="checkbox" class="form-check-input" id="dropdownCheck2">--%>
<%--            <label class="form-check-label" for="dropdownCheck2">--%>
<%--                Remember me--%>
<%--            </label>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--    <button type="submit" class="btn btn-primary">Sign in</button>--%>
<%--&lt;%&ndash;</form>&ndash;%&gt;--%>
<form method="get">
    <table>
        <tr>
            <td>Login</td>
            <td>
                <input type="text" name="value" placeholder="login" class="form-control">
            </td>
        </tr>
        <tr>
            <td>Password</td>
            <td>
                <input type="text" name="value" placeholder="password" class="form-control">
            </td>
        </tr>
    </table>
    <button type="submit" name="loginButton" class="btn btn-primary">Sign in</button>
</form>
</body>
</html>
