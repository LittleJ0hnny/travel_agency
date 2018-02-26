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
                        <th>NAME</th>
                        <th></th>
                        <th></th>
                    </tr>
                    <c:forEach var="country" items="${countries}">
                            <tr>
                                <td>${country.id}</td>
                                <td>${country.name}</td>
                                <td><a href="http://localhost:8080/cities/${country.id}">Show all available cities</a></td>
                                <td><a href="http://localhost:8080/visas/${country.id}">Show all visas for this country</a></td>
                            </tr>
                    </c:forEach>
                </table>
    </body>
</html>