<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table table-hover">
    <thead>
        <tr>
        <%--<th scope="col">ID</th>--%>
            <th scope="col">City name</th>
            <th scope="col">Country name</th>
            <th scope="col">Actions</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach var="city" items="${cities}">
        <tr>
            <%--<th scope="row">${city.id}</th>--%>
            <td>${city.name}</td>
            <td>${city.country.name}</td>
            <td>
                <a type="button"  class="btn btn-primary" href="${pageContext.request.contextPath}/cities/selectHotelsByCity/${city.id}">Get hotels</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>