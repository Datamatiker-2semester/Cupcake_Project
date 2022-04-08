<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
  <jsp:attribute name="header">

    </jsp:attribute>

    <jsp:attribute name="footer">

    </jsp:attribute>
<jsp:body>

    <div>Welcome ${user.username}! What would you like?</div>
    <br>
<form>
    <label> Choose topping </label>
    <select>
        <c:forEach items="${sessionScope.listCupcakeT}" var="topping">

            <option value="listT">
                    <column>${topping.toppingName}</column>
                    <column>${topping.toppingPrice}</column>
                    <column>kr</column>
            </option>
        </c:forEach>
    </select>
</form>

<form>
    <label> Choose flavor </label>
    <select>
        <c:forEach items="${sessionScope.listCupcakeB}" var="bottom">

            <option value="listB">
                <column>${bottom.bottomName}</column>
                <column>${bottom.bottomPrice}</column>
                <column> kr</column>
            </option>
        </c:forEach>

    </select>
</form>
    <br>
<h6>Submit order</h6>
    <button class="GFG" value="choice"
            onclick="window.location.href = 'PurchaseServlet'">
        Click Here
    </button>
</form>


</jsp:body>
</t:pagetemplate>
