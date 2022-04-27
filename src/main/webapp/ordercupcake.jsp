<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
  <jsp:attribute name="header">
            Order here
    </jsp:attribute>

    <jsp:attribute name="footer">
        Order here
    </jsp:attribute>
    <jsp:body>

        <div>Welcome ${user.username}! What would you like?</div>
        <br>
        <form method="post">
            <label for="bottom">Vælg bund</label>
            <br>
            <select name="bottom" id="bottom">
                <c:forEach items="${applicationScope.bottoms}" var="items" varStatus="loop">
                    <option value="${loop.index}">${items.name} (${items.price},-)</option>
                </c:forEach>


            </select>
            <br>

            <br>

            <label for="topping">Vælg topping</label>
            <br>
            <select name="topping" id="topping">
                <c:forEach items="${applicationScope.topping}" var="items" varStatus="loop">
                    <option value="${loop.index}">${items.name} (${items.price},-)</option>
                </c:forEach>
            </select>
            <br>
            <br>
            <input id="number" type="number" name="number" value="1" max="50" min="1" >
            <br>
            <h6>Submit order</h6>
            <input type="submit" id="button" value="Click here">

        </form>

    </jsp:body>
</t:pagetemplate>