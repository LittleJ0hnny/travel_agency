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
            <td class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Option</a>
                <div class="dropdown-menu" x-placement="bottom-start" style="position: absolute; transform: translate3d(0px, 40px, 0px); top: 0px; left: 0px; will-change: transform;">
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/countries/updateCountry/${hotel.id}">update</a>
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/countries/deleteCountry/${hotel.id}">remove</a>
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/cities/selectRoomsByHotel/${hotel.id}">rooms</a>
                </div>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>