<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
             Køb
    </jsp:attribute>


    <jsp:body>

        <h3>Kurv</h3>

        <c:forEach var="cartItem" items="${sessionScope.cart.cartItemList}">
            bottom: ${cartItem.bottomId}} - <br>
            hej: ${cartItem.bottom}
            topping: ${cartItem.toppingId}}<br/>

        </c:forEach>

        <a href="OrderCupcake.jsp">Bestil flere</a>

    </jsp:body>
</t:pagetemplate>