<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table table-hover">
    <thead>
    <tr>
        <th scope="col">Country</th>
        <th scope="col">Client</th>
        <th scope="col">Valid From</th>
        <th scope="col">Valid To</th>
        <th scope="col">Last time used</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="visa" items="${visas}">
        <tr>
            <td>${visa.country.name}</td>
            <td>${visa.client.lastname}</td>
            <td>${visa.validFrom}</td>
            <td>${visa.validTo}</td>
            <td>${visa.lastTimeUsed}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>