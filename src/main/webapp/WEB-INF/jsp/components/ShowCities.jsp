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
                    <c:forEach var="city" items="${cities}">
                            <tr>
                                <td>${city.country.name}</td>
                                <td>${city.name}</td>
                                <td><a href="http://localhost:8080/hotels/${city.id}">Show all hotels for this city</a></td>

                            </tr>
                    </c:forEach>
                </table>
    </body>
</html>