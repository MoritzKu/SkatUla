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
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="basic-addon3" >Kursbezeichnung</span>
                </div>
                <input name="bezeichnung" type="text" class="form-control" value="" id="basic-url" aria-describedby="basic-addon3">
            </div>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="basic-addon3" >maximale Teilnehmeranzahl</span>
                </div>
                <input name="maxTeilnehmer" type="number" class="form-control" value="" id="basic-url" aria-describedby="basic-addon3">
            </div>


            <input name="bezeichnung" type="text" class="form-control" placeholder="Behzeichnung" value="">
            <input name="maxTeilnehmer" type="number" class="form-control" placeholder="Maximale Teilnehmerzahl" value="">
            <label for="hersteller">Hersteller: </label>
            <select name="schwierigkeitsgrad" class="form-control form-control-sm" required>
                <option value="" disabled selected style="display: none;">Bitte Schwierigkeitsgrad wählen</option>
                <c:forEach items="${schwierigkeitsgrad}" var="sgValue">
                    <option value="${sgValue}"
                            ${sgValue == kurs.response.schwierigkeitsgrad ? 'selected' : ''}>
                        ${sgValue}
                    </option>
                </c:forEach>
            </select>
             <select name="trainer" class="form-control form-control-sm" required>
                <option value="" disabled selected style="display: none;">Bitte Trainer wählen</option>
                <c:forEach items="${trainerList}" var="trainer">
                    <option value="${trainer.id}"
                            ${trainer == kurs.response.trainer.id ? 'selected' : ''}>
                        ${trainer.username}
                    </option>
                </c:forEach>
            </select>

            <button type="submit" class="btn btn-success"> speichern </button>
        </form>
    </jsp:attribute>
</template:base>

