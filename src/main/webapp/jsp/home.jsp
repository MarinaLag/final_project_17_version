<%@ page import="constants.ApplicationConstants" %>
<%@ page import="constants.JspConstants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home page</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
<jsp:include page="<%=JspConstants.MENU_JSP%>"/>
<h2>Hello ${user.name}</h2>
<h1>Some content will be place here.....i.e. slider</h1
<c:if test="${not empty pizzas}">
    <h2>Today we propose next pizzas:</h2>
    <c:forEach var="pizza" items="${pizzas}">
        <div class="food-item-box">
            <img class="small-image" src="/img/${pizza.name}.jpg" alt="pizza">
            <p>Name: ${pizza.name}</p>
            <p>Price: ${pizza.price}</p>
        </div>
    </c:forEach>
</c:if>
<c:if test="${not empty drinks}">
    <h2>Today we propose next drinks:</h2>
    <c:forEach var="drink" items="${drinks}">
        <div class="food-item-box">
            <img class="small-image" src="/img/${drink.name}.jpg" alt="drink">
            <p>Name: ${drink.name}</p>
            <p>Price: ${drink.price}</p>
        </div>
    </c:forEach>
</c:if>
</body>
</html>
