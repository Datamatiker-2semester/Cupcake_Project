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
      </tr>

      <tr>

        <td>${sessionScope.user.username}</td>
        <td>test</td>
        <td>test</td>



      </tr>



      <tr>
        <td>Centro comercial Moctezuma</td>
        <td>Francisco Chang</td>
        <td>Mexico</td>
      </tr>
    </table>



  </jsp:body>
</t:pagetemplate>