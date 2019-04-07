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
                <a href="<c:url value="/kursAnlegen"/>">
                    <button class="btn btn-primary btn-sm" type="button"> Kurs anlegen </button>
                </a>
            </c:if>
            <div id="kurse"></div>

            <!-- Ab hier fängt es an, Spaß zu machen 🤩 -->
            <script>
                kursCollection = new KursCollection();
                //songResource.setAuthData("username", "password");

                // Abruf und Anzeige aller Songs, nach Laden der Seite
                let reloadKurse = async () => {
                    let response = await kursCollection.getKurse("");
                    if ("exception" in response) {
                        alert(`[${response.exception}]: ${response.message}`);
                    } else {
                        let kurseElement = document.getElementById("kurse");
                        kurseElement.innerHTML = "";
                        response.responseList.forEach(singleKurs => {
                            // Empfangene Daten anzeigen
                            let kursElement = document.createElement("div");
                            kurseElement.appendChild(kursElement);
                            kursElement.innerHTML =
                                    `<div class="card mb-3" style="max-width: 1000px;">` +
                                    `<div class="row no-gutters">` +
                                    `<div class="col-md-4 herstellerLogo">` +
                                    `</div>` +
                                    `<div class="col-md-4">` +
                                    `<div class="card-body">` +
                                    `<h5 class="card-title">` + singleKurs.bezeichnung.valueOf() + `</h5>` +
                                    `<p class="card-text">Trainer: ` + singleKurs.trainer.username.valueOf() + `</p>` +
                                    `</div>` +
                                    `</div>` +
                                    `<div class="col-md-4">` +
                                    `<div class="card-body">` +
                                    `<p class="card-text">Maximale Teilnehmer: ` + singleKurs.maxTeilnehmer.valueOf() + `</p>` +
                                    `<p class="card-text">aktuelle Teilnehmer: ` + singleKurs.aktuelleTeilnehmerzahl.valueOf() + `</p>` +
                                    `<c:if test="${nutzertyp == 'kunde'}">` +
                                    `<a href="kursBelegen/` + singleKurs.id.valueOf() + `"/>` +
                                    `<button id="belegen" type="button" class="btn btn-primary btn-sm">Kurs belegen</button>` +
                                    `</a>` +
                                    `</c:if>` +
                                    `</div>` +
                                    `</div>` +
                                    `</div>` +
                                    `</div>`;
                            console.log("Vor der Abfrage, ob die max Anzahl an Teilnehmer schon erreicht ist: ");
                            let maxTeilnehmer = parseInt(singleKurs.maxTeilnehmer.valueOf());
                            let aktuellTeilnehmer = parseInt(singleKurs.aktuelleTeilnehmerzahl.valueOf());
                            console.log("Max: " + maxTeilnehmer + "\tAkt: " + aktuellTeilnehmer);
                            if (maxTeilnehmer <= aktuellTeilnehmer) {
                                console.log("Maximale Anzahl an Teilnehmer erreicht");
                                document.getElementById("belegen").disabled = true;
                            }
                        }
                        );
                    }
                };
                window.addEventListener("load", () => reloadKurse());
                </script>
            </form>
    </jsp:attribute>
</template:base>

