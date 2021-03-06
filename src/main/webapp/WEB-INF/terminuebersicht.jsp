<%-- 
    Document   : terminuebersicht
    Created on : 05.04.2019, 21:09:29
    Author     : f_lieb
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="template"%>

<!DOCTYPE html>
<template:base>
    <jsp:attribute name="title">Terminübersicht</jsp:attribute>
    <jsp:attribute name="content">
        <form method="POST">
            <h1> Termin anlegen</h1>

            <c:if test="${nutzertyp == 'trainer' }">
                <a href="<c:url value="/terminAnlegen"/>"> <button class="btn btn-primary btn-sm" type="button"> Termin anlegen </button></a>
            </c:if>

            <c:choose>
                <c:when test="${!empty terminList.responseList}">
                    <c:forEach items="${terminList.responseList}" var="termin">
                        <div class="card mb-3" style="max-width: 1000px;">
                            <div class="row no-gutters">
                                <div class="col-md-4 herstellerLogo">
                                </div>
                                <div class="col-md-4">
                                    <div class="card-body">
                                        <h5 class="card-title">${termin.kurs.bezeichnung}</h5>
                                        <p class="card-text">Trainer: ${termin.kurs.trainer.username}</p>

                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="card-body">
                                        <p class="card-text">Datum: ${termin.datum}</p>
                                        <p class="card-text">Zeit: ${termin.time}</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </c:when> 
                <c:otherwise>
                    <%-- Hinweis, dass es noch keine Pläne gibt --%>
                    <div class="alert alert-danger" role="alert">
                        Es sind noch keine Termine vorhanden.
                    </div>
                </c:otherwise>
            </c:choose>
        </form>
    </jsp:attribute>
</template:base>