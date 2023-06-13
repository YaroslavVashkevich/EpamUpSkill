<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, java.text.*, com.epam.rd.jsp.currencies.CurrenciesOfCurrentTestCase" %>

<body>
<h1>Currencies</h1>
<ul>
    <jsp:useBean id="currencies" class="com.epam.rd.jsp.currencies.CurrenciesOfCurrentTestCase" scope="request"/>
        <c:forEach var="currency" items="${requestScope.currencies.getCurrencies()}">
        <li>
            <c:out value="${currency}"/>
        </li>
    </c:forEach>
</ul>
<body/>

