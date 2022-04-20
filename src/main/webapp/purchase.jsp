<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
             Basket:
    </jsp:attribute>

    <jsp:body>



       <h4>Here are the cupcakes you picked: </h4>
        <h4>${sessionScope.bottom_id}</h4>
        <h4>${sessionScope.listCupcakeTopping}</h4>

        <br>


        <p>Click here to pay with your balance</p>
        <form action="reciept.jsp">

            <input type="submit" value="Pay">
        </form>
    </jsp:body>
</t:pagetemplate>