<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table table-hover">
    <thead>
    <tr>
        <th scope="col">First Name</th>
        <th scope="col">Last Name</th>
        <th scope="col">Bithday</th>
        <th scope="col">Citizenship</th>
        <th scope="col">Number Visas</th>
        <th scope="col">All Visas</th>
        <th scope="col">Active Visas</th>
        <th scope="col">visited country</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="client" items="${clients}">
        <tr>
            <td>${client.firstname}</td>
            <td>${client.lastname}</td>
            <td>${client.bithday}</td>
            <td>${client.citizenship}</td>
            <td>${client.visas.size()}</td>
            <td class="nav-item dropdown">
                <a type="button"  class="btn btn-primary" href="${pageContext.request.contextPath}/clientVisas/all/${client.id}">All Visas</a>
            </td>
            <td class="nav-item dropdown">
                <a type="button"  class="btn btn-primary" href="${pageContext.request.contextPath}/clientVisas/active/${client.id}">Active Visas</a>
            </td>
            <td class="nav-item dropdown">
                <a type="button"  class="btn btn-primary" href="${pageContext.request.contextPath}/visitedCountry/${client.id}">Visited Countries</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>