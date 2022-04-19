<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">

    </jsp:attribute>

    <jsp:attribute name="footer">
            Create user:
    </jsp:attribute>

    <jsp:body>



        <h3>Please fill out the information below to create an account:</h3>
        <br>
        <form action="CreateUserServlet" method="post">
            <label for="username">Username: </label>
            <input type="text" id="username" name="username"/>
            <br>
            <br>
            <label for="password">Password: </label>
            <input type="password" id="password" name="password"/>
            <br>
            <br>
            <label for="email">Email: </label>
            <input type="email" id="email" name="email"/>
            <br>
            <br>
            <input type="submit"  value="Create user"/>
        </form>
        <br>

    </jsp:body>
</t:pagetemplate>