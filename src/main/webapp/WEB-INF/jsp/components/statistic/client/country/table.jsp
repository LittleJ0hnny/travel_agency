<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table table-hover">
    <thead>
    <tr>
        <th scope="col">Country</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="country" items="${countries}">
        <tr>
            <td>${country.name}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>