<%-- 
    Document   : terminAnlegen
    Created on : 05.04.2019, 19:39:03
    Author     : f_lieb
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="template"%>



<!DOCTYPE html>

<template:base>
    <jsp:attribute name="title">Terminübersicht</jsp:attribute>
    <jsp:attribute name="head">
        <script src="<c:url value="/js/KursCollection.js"/>"></script>
    </jsp:attribute>
    <jsp:attribute name="content">
        <form method="POST">
            <h1> Termin anlegen</h1> 

            <label for="klasse">Klasse: </label>
            <select name="kurs" id="kurse" class="form-control form-control-sm" required><option value="" disabled selected style="display: none;">Bitte Kurs wählen</option></select>

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
                        response.responseList.forEach(singleKurs => {

                            let kursElement = document.createElement("option");
                            kursElement.value = singleKurs.id.valueOf();
                            kurseElement.appendChild(kursElement);
                            // Empfangene Daten anzeigen
                            kursElement.innerHTML = singleKurs.bezeichnung.valueOf();


                        }
                        );
                    }
                };
                window.addEventListener("load", () => reloadKurse());
            </script>   



            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="basic-addon3" >Zeit</span>
                </div>
                <input name="time" type="time" class="form-control" value="" id="basic-url" aria-describedby="basic-addon3" required="true">
            </div>

            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="basic-addon3" >Datum</span>
                </div>
                <input name="datum" type="date" class="form-control" value="" id="basic-url" aria-describedby="basic-addon3" required="true">
            </div>

            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="basic-addon3" >Dauer</span>
                </div>
                <input name="dauer" type="number" class="form-control" value="" id="basic-url" aria-describedby="basic-addon3" required="true">
            </div>

            <button type="submit" class="btn btn-success"> speichern </button>
        </form>
    </jsp:attribute>
</template:base>
