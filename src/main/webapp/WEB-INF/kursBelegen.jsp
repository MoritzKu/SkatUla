<%-- 
    Document   : kursuebersicht
    Created on : 03.04.2019, 22:14:37
    Author     : MoritzKuttler
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="template"%>

<!DOCTYPE html>

<template:base>
    <jsp:attribute name="title">Kurs belegen</jsp:attribute>
    <jsp:attribute name="content">
        <form method="POST">
            <h1> Kurs belegen</h1> 

            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="basic-addon3" >Kursbezeichnung</span>
                </div>
                <input name="bezeichnung" type="text" class="form-control" value="${kurs.response.bezeichnung}" id="basic-url" aria-describedby="basic-addon3" readonly="true">
            </div>

            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="basic-addon3" >maximale Teilnehmeranzahl</span>
                </div>
                <input name="maxTeilnehmer" type="number" class="form-control" value="${kurs.response.maxTeilnehmer}" id="basic-url" aria-describedby="basic-addon3" readonly="true">
            </div>

            <label for="schwierigkeitsgrad">Schwierigkeitsgrad: </label>
            <select name="schwierigkeitsgrad" class="form-control form-control-sm" disabled="true">
                <option value="" disabled selected style="display: none;">Bitte Schwierigkeitsgrad wählen</option>
                <c:forEach items="${schwierigkeitsgrad}" var="sgValue">
                    <option readonly="true" value="${sgValue}"
                            ${sgValue == kurs.response.schwierigkeitsgrad ? 'selected' : ''}>
                        ${sgValue}
                    </option>
                </c:forEach>
            </select>
             
            <label for="trainer">Trainer: </label>
            <input name="trainer" value="${kurs.response.trainer.username}" readonly="true"></input>

            <button type="submit" class="btn btn-success"> Kurs belegen </button>
        </form>
    </jsp:attribute>
</template:base>

