<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
             Login:
    </jsp:attribute>

    <jsp:attribute name="footer">
            Login
    </jsp:attribute>

    <jsp:body>

        <h3>You can log in here</h3>

        <form action="login" method="post">
            <label for="username">Username: </label>
            <input type="text" id="username" name="username"/>
            <br>
            <br>
            <label for="password">Password: </label>
            <input type="password" id="password" name="password"/>
            <br>
            <br>
            <input type="submit"  value="Log in"/>
        </form>
            <br>
        <h4>You can create a new user here</h4>
        <form action="createUser.jsp">

            <input type="submit" value="Create user">
        </form>
        <br>
        <h4>You can create a new user here</h4>
        <form action="createUser.jsp">

            <input type="submit" value="Create user">
        </form>


    </jsp:body>
</t:pagetemplate>