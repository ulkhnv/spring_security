<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<div align="center">
    <h1><c:out value="Update user with id : ${id}"/> </h1>
    <form action="/admin/update" method="post">
        <table cellspacing="5px">
            <input type="hidden" name="id" value=${id}>
            <tr>
                <td>Name :</td>
                <td><input type="text" name="username" value=${username}></td>
            </tr>
            <tr>
                <td>Surname :</td>
                <td><input type="text" name="password" value=${password}></td>
            </tr>

        </table>
        <input type="submit" value="Save" style="margin-top:5px">
    </form>
</div>

</body>
</html>
