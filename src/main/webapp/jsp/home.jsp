<%@ page import="by.itclass.constants.JspConstants" %>
<%@ page import="by.itclass.constants.ApplicationConstants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Home page</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
    <jsp:include page="<%=JspConstants.MENU_JSP%>"/>
    <h2>Hello ${user.name}</h2>
    <h1>Some content will be place here.....i.e. slider</h1>
    <c:if test="${not empty pizzas}">
        <h2>Today we propose next pizzas:</h2>
        <c:forEach var="pizza" items="${pizzas}">
            <div class="food-item-box">
                <img class="small-image" src="/img/${pizza.name}.jpg" alt="pizza">
                <p>Name: ${pizza.name}</p>
                <p>Price: ${pizza.price} BYN</p>
                <form method="post" action="<%=ApplicationConstants.CART_CONTROLLER%>">
                    <input type="hidden" name="<%=JspConstants.CART_ACTION_PARAM%>" value="addToCard">
                    <input type="hidden" name="<%=JspConstants.FOOD_ID_PARAM%>" value="${pizza.id}">
                    <input type="hidden" name="<%=JspConstants.FOOD_TYPE_PARAM%>" value="1">
                    <input type="hidden" name="<%=JspConstants.FOOD_NAME_PARAM%>" value="${pizza.name}">
                    <input type="hidden" name="<%=JspConstants.FOOD_PRICE_PARAM%>" value="${pizza.price}">
                    <input type="number" name="<%=JspConstants.FOOD_QUANTITY_PARAM%>" required>
                    <input type="submit" value="Add to Cart">
                </form>
            </div>
        </c:forEach>
    </c:if>
    <c:if test="${not empty drinks}">
        <h2>Today we propose next drinks:</h2>
        <c:forEach var="drink" items="${drinks}">
            <div class="food-item-box">
                <img class="small-image" src="/img/${drink.name}.jpg" alt="drink">
                <p>Name: ${drink.name}</p>
                <p>Price: ${drink.price} BYN</p>
                <form method="post" action="<%=ApplicationConstants.CART_CONTROLLER%>">
                    <input type="hidden" name="<%=JspConstants.CART_ACTION_PARAM%>" value="addToCard">
                    <input type="hidden" name="<%=JspConstants.FOOD_ID_PARAM%>" value="${drink.id}">
                    <input type="hidden" name="<%=JspConstants.FOOD_TYPE_PARAM%>" value="2">
                    <input type="hidden" name="<%=JspConstants.FOOD_NAME_PARAM%>" value="${drink.name}">
                    <input type="hidden" name="<%=JspConstants.FOOD_PRICE_PARAM%>" value="${drink.price}">
                    <input type="number" name="<%=JspConstants.FOOD_QUANTITY_PARAM%>" required>
                    <input type="submit" value="Add to Cart">
                </form>
            </div>
        </c:forEach>
    </c:if>
</body>
</html>
