<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table table-hover">
    <thead>
        <tr>
            <th scope="col">City name</th>
            <th scope="col">Country name</th>
            <th scope="col">Actions</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach var="city" items="${cities}">
        <tr>
            <td>${city.name}</td>
            <td>${city.country.name}</td>
            <td>
                <a type="button"  class="btn btn-primary" href="${pageContext.request.contextPath}/hotels/selectHotelsByCity/${city.id}">Get hotels</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>