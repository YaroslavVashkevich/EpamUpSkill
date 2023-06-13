<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, java.text.*, com.epam.rd.jsp.currencies.CurrenciesOfCurrentTestCase" %>
<body>
<jsp:useBean id="currencies" class="com.epam.rd.jsp.currencies.CurrenciesOfCurrentTestCase" scope="request"/>
    <c:set var="from" value="${param.from}" />
    <c:set var="to" value="${param.to}" />
    <c:set var="amount" value="${param.amount}" />
        <h1>Converting ${from} to ${to}</h1>
            <c:set var="currency" value="${requestScope.currencies.convert(amount,from,to)}"/>
        <p><c:out value="${amount} ${from} = ${currency} ${to}"/></p>
<body/>
