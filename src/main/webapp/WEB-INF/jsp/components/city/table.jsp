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
            <td class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Action</a>
                <div class="dropdown-menu" x-placement="bottom-start" style="position: absolute; transform: translate3d(0px, 40px, 0px); top: 0px; left: 0px; will-change: transform;">
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/cities/updateCity/${city.id}">update</a>
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/cities/deleteCity/${city.id}">remove</a>
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/cities/selectHotelsByCity/${city.id}">hotels</a>
                </div>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>