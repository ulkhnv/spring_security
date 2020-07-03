<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Create User</title>
</head>
<body>
<div align="center">
    <h2>New User</h2>
    <form:form action="/admin/add" method="post" modelAttribute="user">
        <table cellpadding="5px">
            <tr>
                <td align="center">Username:</td>
                <td><form:input path="username" /></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><form:input path="password"/></td>
            </tr>
            <tr>
                <td>Role:</td>
                <td><input type="text" name="role" value="ROLE_"></td>
            </tr>
        </table>
        <input type="submit" value="Create" style="margin-top:5px">
    </form:form>

</div>
</body>
</html>
