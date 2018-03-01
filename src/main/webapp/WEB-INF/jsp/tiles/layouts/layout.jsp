<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title><tiles:getAsString name="title" /></title>
    <%--Bootstrap--%>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <%--Bootstrap CSS--%>
    <link rel="stylesheet" href="<c:url value='/static/bootstrap/css/bootstrap.min.css' />">
    <link rel="stylesheet" href="<c:url value='/static/bootstrap/css/bootstrap-theme.css' />">
    <%--jQuery--%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <%--Popper--%>
    <script src="https://unpkg.com/popper.js"></script>
    <%--Bootstrap JS--%>
    <script src="<c:url value='/static/bootstrap/js/bootstrap.min.js' />"></script>
    <%--For index page--%>
    <link rel="stylesheet" href="<c:url value='/static/index/index.css' />">
    <link rel="stylesheet" href="<c:url value='/static/index/slider.css' />">
    <%--<link rel="stylesheet" href="<c:url value='/static/index/navigation/css/reset.css'/>">
    <link rel="stylesheet" href="<c:url value='/static/index/navigation/css/style.css'/>">
    <script src="<c:url value='/static/index/navigation/js/modernizr.js'/>"></script>
    <script src="<c:url value='/static/index/navigation/js/jquery-2.1.4.js'/>"></script>
    <script src="<c:url value='/static/index/navigation/js/main.js'/>"></script>--%>
</head>

<body>
<header id="header">
    <tiles:insertAttribute name="header"/>
</header>

<div class="container-fluid">
    <div class="container-fluid">
        <tiles:insertAttribute name="index"/>
    </div>
    <div class="container">
        <tiles:insertAttribute name="input"/>
    </div>
    <div class="container">
        <tiles:insertAttribute name="content"/>
    </div>
</div>

<footer id="footer">
    <tiles:insertAttribute name="footer" />
</footer>
</body>
</html>
