<%-- 
    Document   : index
    Created on : 19.03.2019, 18:36:03
    Author     : Benjamin Kanzler
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib tagdir="/WEB-INF/tags/" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<template:base>
    <jsp:attribute name="title">
        Index
    </jsp:attribute>
    <jsp:attribute name="head">
        <h1>HELLO WORLD!</h1>
    </jsp:attribute>
    <jsp:attribute name="header">
        <div>Header</div>
    </jsp:attribute>
    <jsp:attribute name="main">
        <div>Main</div>
    </jsp:attribute>
    <jsp:attribute name="footer">
        <div>Footer</div>
    </jsp:attribute>
</template:base>
