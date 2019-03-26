<%-- 
    Document   : myCalendar
    Created on : 26.03.2019, 23:03:14
    Author     : Benjamin Kanzler
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib tagdir="/WEB-INF/tags/" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/daypilot/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/daypilot/calendar.js"></script>
<script src="/js/Calendar.js"></script>
<template:base>
    <jsp:attribute name = "main">
        <div id="dpc"></div>
    </jsp:attribute>
</template:base>