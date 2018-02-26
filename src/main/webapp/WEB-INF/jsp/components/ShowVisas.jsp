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
                        <th>ID</th>
                        <th>Country</th>
                        <th>Client</th>
                        <th>Valid from</th>
                        <th>Valid to</th>
                        <th>Last time used</th>
                    </tr>
                    <c:forEach var="visa" items="${visas}">
                            <tr>
                                <td>${visa.id}</td>
                                <td>${visa.country.name}</td>
                                <td>${visa.client.lastname}</td>
                                <td>${visa.validFrom}</td>
                                <td>${visa.validTo}</td>
                                <td>${visa.lastTimeUsed}</td>
                            </tr>
                    </c:forEach>
                </table>
    </body>
</html>