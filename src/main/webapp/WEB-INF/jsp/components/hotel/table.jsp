<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table class="table table-hover">
    <thead>
    <tr>
        <th scope="col">City name</th>
        <th scope="col">Hotel name</th>
        <th scope="col">Options</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="hotel" items="${hotels}">
        <tr>
            <td>${hotel.name}</td>
            <td>${hotel.city.name}</td>
            <td>
                <a type="button"  class="btn btn-primary" href="${pageContext.request.contextPath}/rooms/selectRoomsByHotel/${hotel.id}">Get rooms</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>