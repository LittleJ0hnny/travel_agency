<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table class="table table-hover">
    <thead>
    <tr>
        <th scope="col">City name</th>
        <th scope="col">Hotel name</th>
        <th scope="col">Type</th>
        <th scope="col">Price</th>
        <th scope="col">Number of beds</th>
        <th scope="col">Booking</th>
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
            <td>
                <form action="${pageContext.request.contextPath}/" method="post">
                    <input type="hidden" name="userId" value="${user.id}">
                    <input type="hidden" name="roomId" value="${room.id}">
                    <input type="hidden" name="userId" value="${hotel.id}">
                    <input type="hidden" name="dateFrom" value="${dateFrom}">
                    <input type="hidden" name="dateTo" value="${dateTo}">
                    <input type="submit" value="Book">
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>