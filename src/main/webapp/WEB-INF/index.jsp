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
    <jsp:attribute name="header">
        <c:if test="${nutzer.message != null}">
            <div class="alert alert-success" role="success">
                <p>${nutzer.message}</p>
            </div>
        </c:if>
    </jsp:attribute>
    <jsp:attribute name="content">
        <div>
            <h1> Herzlich Willkommen ${nutzer.response.username}!</h1>
            <p> Viel Spaß auf unserer Seite :-)</p>
            <div class="pictureIndex">
            <img src="<c:url value="/images/motivation.bmp"/>" alt="selfhtml">         
            </div>
        </div>
    </jsp:attribute>
</template:base>