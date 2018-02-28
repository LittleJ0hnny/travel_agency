<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table table-hover">
    <thead>
        <tr>
            <%--<th scope="col">ID</th>--%>
            <th scope="col">Country name</th>
            <th scope="col">Options</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach var="country" items="${countries}">
        <tr>
            <%--<th scope="row">${country.id}</th>--%>
            <td>${country.name}</td>
            <td class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Option</a>
                <div class="dropdown-menu" x-placement="bottom-start" style="position: absolute; transform: translate3d(0px, 40px, 0px); top: 0px; left: 0px; will-change: transform;">
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/countries/updateCountry/${country.id}">update</a>
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/countries/deleteCountry/${country.id}">remove</a>
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/cities/selectCitiesByCountry/${country.id}">cities</a>
                </div>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>