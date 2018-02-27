<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>   
        Countries
    </title>
</head>
    <body>
    <h3>${tableName}</h3>
    <br>

    <c:if test = "${cityId > 0}">
        <form action="http://localhost:8080/hotels/findFreeHotel" method="post">
        To find free hotel please choose date
          choose the date of arrival:
          <input type="date" name="From" min="${todayDate}"><br>
          choose the date of departure:
          <input type="date" name="To" min="${todayDate}"><br>
          <input type="hidden" name="cityId" value="${cityId}">
          <input type="submit" value="Find">
        </form>
               <table>
                    <tr>
                        <th>Name City</th>
                        <th>Name Hotel</th>
                        <th>Number Rooms</th>
                        <th>Rooms</th>
                    </tr>
                    <c:forEach var="hotel" items="${hotels}">
                            <tr>
                                <td>${hotel.city.name}</td>
                                <td>${hotel.name}</td>
                                <td>${hotel.rooms.size()}</td>
                                <td><a href="http://localhost:8080/rooms/${hotel.id}">Show all rooms for this hotel</a></td>
                            </tr>
                    </c:forEach>
                </table>
    </c:if>
    <c:if test = "${cityId == 0}">
                <table>
                                    <tr>
                                        <th>Name City</th>
                                        <th>Name Hotel</th>
                                        <th>Number Rooms</th>
                                        <th>Rooms</th>
                                        <th>Number Clients</th>
                                        <th>Average booking time</th>
                                    </tr>
                                    <c:forEach var="hotel" items="${hotels}">
                                            <tr>
                                                <td>${hotel.city.name}</td>
                                                <td>${hotel.name}</td>
                                                <td>${hotel.rooms.size()}</td>
                                                <td><a href="http://localhost:8080/rooms/${hotel.id}">Show all rooms for this hotel</a></td>
                                                <td>${hotel.numberClient}</td>
                                                <td>${hotel.averageBookingTime}</td>
                                            </tr>
                                    </c:forEach>
                </table>
    </c:if>
    </body>
</html>