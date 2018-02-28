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
                <a type="button"  class="btn btn-primary" href="${pageContext.request.contextPath}/cities/cities/selectRoomsByHotel/${hotel.id}">Get cities</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>