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
    <jsp:attribute name="head">
        <script src="<c:url value="/js/KursCollection.js"/>"></script>
    </jsp:attribute>
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
                                                <button type="button" ${(kurs.maxTeilnehmer >= kurs.aktuelleTeilnehmerzahl)?'disabled':''}class="btn btn-primary btn-sm">Kurs belegen</button>
                                            </a>
                                        </c:if>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- Platzhalter für die vorhandenen Songs -->
                        <div id="kurse"></div>

                        <!-- Ab hier fängt es an, Spaß zu machen 🤩 -->
                        <script>
                            kursCollection = new KursCollection();
                            //songResource.setAuthData("username", "password");

                            // Abruf und Anzeige aller Songs, nach Laden der Seite
                            let reloadKurse = async () => {
                                let response = await kursCollection.getKurse("");

                                if ("exception" in response) {
                                    alert(`[${response.exception}]: ${response.message}`)
                                } else {
                                    let kurseElement = document.getElementById("kurse");
                                    kurseElement.innerHTML = "";

                                    response.responseList.forEach(kurs => {
                                        // Empfangene Daten anzeigen
                                        let kursElement = document.createElement("div");
                                        kurseElement.classList.add("kurs");
                                        kurseElement.appendChild(kursElement);

                                        kursElement.innerHTML = `<b>${kurs.bezeichnung}</b> <br/>`
                                                + `<span class="label">Trainer:</span> ${kurs.trainer.username} <br/>`
                                                + `<span class="label">Max. Teilnehmer</span> ${kurs.maxTeilnehmer} <br/>`
                                                + `<span class="label">Teilnehmer aktuell</span> ${kurs.aktuelleTeilnehmerzahl} <br/>`;
                                    });
                                }
                            };

                            window.addEventListener("load", () => reloadKurse());
                        </script>
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

