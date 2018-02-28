<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table class="table table-hover">
    <thead>
    <tr>
        <th scope="col">City name</th>
        <th scope="col">Hotel name</th>
        <th scope="col">Type</th>
        <th scope="col">Price</th>
        <th scope="col">Number bed</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="room" items="${rooms}">
        <tr>
            <td>${room.hotel.city.name}</td>
            <td>${room.hotel.name}</td>
            <td>${room.type}</td>
            <td>${room.price}</td>
            <td>${room.num_of_beds}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>