<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/format" prefix="fmt" %>
...
<table>
    <c:forEach items="${requests}" var="requests">
        <tr>
            <td>${requests.R_ID}</td>
            <td><fmt:formatNumber value="${requests.R_VALUE}" type="currency" currencyCode="USD" /></td>
            <td><c:out value="${requests.R_STATE}" /></td>
            <td><c:out value="${requests.R_CREATION}" /></td>
            <td><c:out value="${requests.R_AUTH_DATE}" /></td>
            
        </tr>
    </c:forEach>
</table>