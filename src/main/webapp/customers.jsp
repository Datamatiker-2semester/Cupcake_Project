<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
             Customers:
    </jsp:attribute>

  <jsp:attribute name="footer">
            Customer page
    </jsp:attribute>

  <jsp:body>

    <table>

      <tr>
        <th>Customer's username:</th>
        <th>Customer's email:</th>
        <th>Customer's balance:</th>
      </tr></thead>
      <c:forEach items="${sessionScope.userList}" var="userList">

      <tr>
        <td>${userList.username}</td>
        <td>${userList.email}</td>
        <td>${userList.balance}</td>




      </tr>

      </c:forEach>

    </table>



  </jsp:body>
</t:pagetemplate>