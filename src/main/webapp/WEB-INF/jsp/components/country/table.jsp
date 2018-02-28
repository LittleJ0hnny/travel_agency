<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table table-hover">
    <thead>
        <tr>
            <th scope="col">Country name</th>
            <th scope="col">Options</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach var="country" items="${countries}">
        <tr>
            <td>${country.name}</td>
            <td class="nav-item dropdown">
                <a type="button"  class="btn btn-primary" href="${pageContext.request.contextPath}/cities/selectCitiesByCountry/${country.id}">Get cities</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>