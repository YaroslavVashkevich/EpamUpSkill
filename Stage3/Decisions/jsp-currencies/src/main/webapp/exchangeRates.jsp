<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, java.text.*, com.epam.rd.jsp.currencies.CurrenciesOfCurrentTestCase" %>

<body>
<jsp:useBean id="currencies" class="com.epam.rd.jsp.currencies.CurrenciesOfCurrentTestCase" scope="request"/>
<c:set var="from" value="${param.from}"/>
<h1>Exchange Rates for ${from}</h1>
<ul>
    <c:forEach var="currency" items="${requestScope.currencies.getExchangeRates(from)}">
        <c:if test="${currency.key != from}">
            <li><c:out value="1 ${from} = ${currency.value} ${currency.key}"/></li>
        </c:if>
    </c:forEach>
</ul>
<body/>


