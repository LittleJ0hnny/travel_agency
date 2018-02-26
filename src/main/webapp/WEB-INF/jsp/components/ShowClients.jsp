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
                        <th>first name</th>
                        <th>last name</th>
                        <th>bithday</th>
                        <th>citizenship</th>
                        <th>number visas</th>
                        <th>visas</th>
                        <th>Active Visas</th>
                        <th>visited country</th>
                    </tr>
                    <c:forEach var="client" items="${clients}">
                            <tr>
                                <td>${client.id}</td>
                                <td>${client.firstname}</td>
                                <td>${client.lastname}</td>
                                <td>${client.bithday}</td>
                                <td>${client.citizenship}</td>
                                <td>${client.visas.size()}</td>
                                <td><a href="http://localhost:8080/clientVisas/all/${client.id}">Show all visas for this client</a></td>
                                <td><a href="http://localhost:8080/clientVisas/active/${client.id}">Show active visas for this client</a></td>
                                <td><a href="http://localhost:8080/visitedCountry/${client.id}">Show visited countries</a></td>

                            </tr>
                    </c:forEach>
                </table>
    </body>
</html>