<%@ page import="constants.ApplicationConstants" %>
<%@ page import="constants.JspConstants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login page</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
    <jsp:include page="<%=JspConstants.MENU_JSP%>"/>
    <img class="default-image" src="<%=JspConstants.BACKGROUND_IMAGE%>">
    <div class="form-box">
        <h2>Login</h2>
        <form method="post" action="<%=ApplicationConstants.LOGIN_CONTROLLER%>">
            <input name="<%= JspConstants.LOGIN_PARAM%>" placeholder="login">
            <input type="password" name="<%=JspConstants.PASS_PARAM%>" placeholder="Password">
            <input type="submit" value="Login">
        </form>
        <c:if test="${not empty message}">
            <h2 class="error">${message}</h2>
        </c:if>
    </div>
</body>
</html>
