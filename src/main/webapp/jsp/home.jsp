<%@ page import="constants.ApplicationConstants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home page</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
    <p>
        <a href="<%=ApplicationConstants.LOGOUT_CONTROLLER%>">Logout</a>
    </p>
    <h2>User info</h2>
    <p>login: ${user.login}</p>
    <p>Name: ${user.name}</p>
    <p>Email: ${user.email}</p>
</body>
</html>
