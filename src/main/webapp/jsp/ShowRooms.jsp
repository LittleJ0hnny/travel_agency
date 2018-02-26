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

    <c:if test = "${hotelId > 0}">
        <form action="http://localhost:8080/hotels/findFreeHotel" method="post">
        To find free hotel please choose date
          choose the date of arrival:
          <input type="date" name="From" min="${todayDate}"><br>
          choose the date of departure:
          <input type="date" name="To" min="${todayDate}"><br>
          <input type="hidden" name="hotelId" value="${hotelId}">
          <input type="submit" value="Find">
        </form>
    </c:if>
               <table>
                    <tr>
                        <th>Name City</th>
                        <th>Name Hotel</th>
                        <th>Type</th>
                        <th>Price</th>
                        <th>Number bed</th>
                    </tr>
                    <c:forEach var="room" items="${rooms}">
                            <tr>
                                <td>${room.hotel.city.name}</td>
                                <td>${room.hotel.name}</td>
                                <td>${room.type}</td>
                                <td>${room.price}</td>
                                <td>${room.num_of_beds}</td>
                            </tr>
                    </c:forEach>
                </table>
    </body>
</html>