<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<html>
<head>
    <title>Order your cupcakes here!</title>
    <h1>Welcome!</h1>
    <h2>Here you can order your cupcakes</h2>


</head>
<body>
<form>
    <label> Choose topping </label>
    <select>
        <c:forEach items="${sessionScope.listCupcakeT}" var="=topping">

            <option value="listT"> ${topping.toppingName}</option>
        </c:forEach>
    </select>
</form>

<form>
    <label> Choose flavor </label>
    <select>
        <c:forEach items="${sessionScope.listCupcakeB}" var="bottom">

            <option value="listB">  ${bottom.bottomName}</option>
        </c:forEach>

    </select>
</form>

<h3>Submit order</h3>
<form action="Order" method="post">
<button type="button">Order now</button>
</form>

</body>
</html>
