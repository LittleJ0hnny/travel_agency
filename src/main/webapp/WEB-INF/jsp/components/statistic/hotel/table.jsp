<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table class="table table-hover">
    <thead>
    <tr>
        <th scope="col">Country name</th>
        <th scope="col">City name</th>
        <th scope="col">Hotel name</th>
        <th scope="col">Number Rooms</th>
        <th scope="col">Number Clients</th>
        <th scope="col">Average booking time</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="hotel" items="${hotels}">
        <tr>
            <td>${hotel.city.country.name}</td>
            <td>${hotel.city.name}</td>
            <td>${hotel.name}</td>
            <td>${hotel.rooms.size()}</td>
            <td>${hotel.numberClient}</td>
            <td>${hotel.averageBookingTime}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>