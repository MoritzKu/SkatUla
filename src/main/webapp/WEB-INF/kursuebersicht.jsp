<%-- 
    Document   : kursuebersicht
    Created on : 03.04.2019, 22:14:37
    Author     : MoritzKuttler
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="template"%>

<!DOCTYPE html>

<template:base>
    <jsp:attribute name="title">Kursübersicht</jsp:attribute>
    <jsp:attribute name="content">
        <form method="POST">
            <h1> Kurs anlegen</h1>

            <c:if test="${nutzertyp == 'trainer' }">
                <a href="<c:url value="/kursAnlegen"/>"> <button class="btn btn-primary btn-sm" type="button"> Kurs anlegen </button></a>
            </c:if>

            <c:choose>
                <c:when test="${!empty kursList.responseList}">
                    <c:forEach items="${kursList.responseList}" var="kurs">
                        <div class="card mb-3" style="max-width: 1000px;">
                            <div class="row no-gutters">
                                <div class="col-md-4 herstellerLogo">
                                </div>
                                <div class="col-md-4">
                                    <div class="card-body">
                                        <h5 class="card-title">${kurs.bezeichnung}</h5>
                                        <p class="card-text">Trainer: ${kurs.trainer.username}</p>
                                        <!-- <a href="<c:url value="/detail/${kurs.id}/"/>">
                                            <button class="btn btn-primary btn-sm">
                                                Details
                                            </button>
                                        </a> -->
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="card-body">
                                        <p class="card-text">Maximale Teilnehmer: ${kurs.maxTeilnehmer}</p>
                                        <p class="card-text">aktuelle Teilnehmer: ${kurs.aktuelleTeilnehmerzahl}</p>
                                        <c:if test="${nutzertyp == 'kunde'}">
                                            <a href="<c:url value="/kursBelegen/${kurs.id}"/>">
                                                <button type="button" class="btn btn-primary btn-sm">Kurs belegen</button>
                                            </a>
                                        </c:if>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </c:when> 
                <c:otherwise>
                    <%-- Hinweis, dass es noch keine Kurs gibt --%>
                    <div class="alert alert-danger" role="alert">
                        Es sind noch keine Kurse vorhanden.
                    </div>
                </c:otherwise>
            </c:choose>
        </form>
    </jsp:attribute>
</template:base>

