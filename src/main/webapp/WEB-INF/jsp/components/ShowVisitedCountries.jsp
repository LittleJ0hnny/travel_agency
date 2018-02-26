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
                        <th>first name</th>
                        <th>last name</th>
                        <th>country</th>
                        <th>visa</th>
                        <th>valid from</th>
                        <th>valid to</th>
                        <th>last time used</th>
                    </tr>
                    <c:forEach var="visa" items="${visas}">
                            <tr>
                                <td>${visa.client.firstname}</td>
                                <td>${visa.client.lastname}</td>
                                <td>${visa.country.name}</td>
                                <td>${visa.id}</td>
                                <td>${visa.validFrom}</td>
                                <td>${visa.validTo}</td>
                                <td>${visa.lastTimeUsed}</td>
                            </tr>
                    </c:forEach>
                </table>
    </body>
</html>