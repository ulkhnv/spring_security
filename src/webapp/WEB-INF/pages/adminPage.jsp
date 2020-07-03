<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Users</title>
</head>
<body>
<h3 align="center"><a href="/admin/add">New User</a> </h3>
<table border="1px" align="center">
    <tr>
        <th width="80">#ID</th>
        <th width="120">Username</th>
        <th width="120">Password</th>
        <th width="60"></th>
        <th width="60"></th>

    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td align="center">${user.id}</td>
            <td align="center">${user.username}</td>
            <td align="center">${user.password}</td>
            <td>
                <form action="/admin/update" method="get">
                    <input type="hidden" name="id" value="${user.id}">
                    <input type="submit" value="Edit">
                </form>
            </td>
            <td>
                <form action="/admin/delete" method="post">
                    <input type="hidden" name="id" value="${user.id}">
                    <input type="submit" value="Delete">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<div align="center">
<a href="<c:url value="/logout"/>">Logout</a>
</div>



</body>
</html>
