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
               <table>
                    <tr>
                        <th>Name Country</th>
                        <th>Name City</th>
                        <th></th>
                    </tr>
                    <c:forEach var="hotel" items="${hotels}">
                            <tr>
                                <td>${hotel.city.name}</td>
                                <td>${hotel.name}</td>
                                <td>${hotel.rooms.size()}</td>

                            </tr>
                    </c:forEach>
                </table>
    </body>
</html>