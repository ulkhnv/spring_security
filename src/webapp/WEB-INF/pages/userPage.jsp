<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>User Page</title>
</head>
<body>
<h1>User name : ${username}</h1>
<a href="<c:url value="/logout"/>">Logout</a>
</body>
</html>

