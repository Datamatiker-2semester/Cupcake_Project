<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
             Kunder:
    </jsp:attribute>

  <jsp:attribute name="footer">
            Kunder:
    </jsp:attribute>

  <jsp:body>

    <table>

      <tr>
        <th>Kunderbrugernavn:</th>
        <th>Købshistorik:</th>
        <th>Rediger Profil:</th>
      </tr></thead>
      <c:forEach items="${sessionScope.userList}" var="userList">

      <tr>
        <td>${userList.username}</td>
        <td>${userList.email}</td>




      </tr>

      </c:forEach>

    </table>



  </jsp:body>
</t:pagetemplate>