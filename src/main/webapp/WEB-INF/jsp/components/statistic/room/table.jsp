<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table class="table table-hover">
    <thead>
    <tr>
        <th scope="col">Hotel name</th>
        <th scope="col">Number Room</th>
        <th scope="col">Count</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="room" items="${rooms}">
        <tr>
            <td>${room.hotel.name}</td>
            <td>${room.number}</td>
            <td>${room.sum}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>