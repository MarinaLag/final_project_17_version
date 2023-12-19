
<%@ page import="by.itclass.constants.JspConstants" %>
<%@ page import="by.itclass.constants.ApplicationConstants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Cart page</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
    <jsp:include page="<%=JspConstants.MENU_JSP%>"/>
    <h2>Hello ${user.name}</h2>
    <c:choose>
        <c:when test="${not empty orderItems}">
            <h2>Yours order items: </h2>
            <c:forEach var="orderItem" items="${orderItems}">
                <div class="cart-item-container">
                    <img class="cart-img" src="/img/${orderItem.foodItem.name}.jpg">
                    <h3 class="cart-text">
                        You ordered ${orderItem.quantity}
                        ${orderItem.foodItem.name} by
                        ${orderItem.foodItem.price} BYN.
                        Amount is ${orderItem.quantity * orderItem.foodItem.price} BYN.
                    </h3>
                            <form method="post" action="<%=ApplicationConstants.CART_CONTROLLER%>">
                                <input type="hidden" name="<%=JspConstants.CART_ACTION_PARAM%>" value="removeFromCart">
                                <input type="hidden" name="<%=JspConstants.FOOD_ID_PARAM%>" value="${orderItem.foodItem.id}">
                                <input type="hidden" name="<%=JspConstants.FOOD_TYPE_PARAM%>" value="${orderItem.foodItem.type}">
                                <input type="hidden" name="<%=JspConstants.FOOD_NAME_PARAM%>" value="${orderItem.foodItem.name}">
                                <input type="hidden" name="<%=JspConstants.FOOD_PRICE_PARAM%>" value="${orderItem.foodItem.price}">
                                <input type="hidden" name="<%=JspConstants.FOOD_QUANTITY_PARAM%>" value="${orderItem.quantity}">
                                <input type="submit" value="Remove from Cart">
                            </form>
                </div>
            </c:forEach>
            Сюда добавить order
        </c:when>
        <c:otherwise>
            <p>You have no items in the order</p>
        </c:otherwise>
    </c:choose>
</body>
</html>
