<%-- 
    Document   : accountdetails
    Created on : 29.03.2019, 11:59:50
    Author     : Benjamin Kanzler
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib tagdir="/WEB-INF/tags/" prefix="template" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<template:base>
    <jsp:attribute name="title">
        Account-Details
    </jsp:attribute>
    <jsp:attribute name="content">
        <h1>Account Detail ${nutzer.response.username}</h1>
        <form method="POST">
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text">Anmeldedaten</span>
                </div>
                <input name="nickname" type="text" class="form-control" placeholder="Nutzername" value="${nutzer.response.username}">
                <div>
                    <a href="<c:url value="/changePassword"/>">
                        <span class="input-group-prepend">Passwort ändern</span>
                    </a>
                </div>
                <input name="passwort" type="password" class="form-control" value="${nutzer.response.passwort}" readonly="true">
                <input name="email" type="text" class="form-control" placeholder="example@test.com" value="${nutzer.response.email}">
            </div>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text">Person</span>
                </div>
                <input name="vorname" type="text" class="form-control" placeholder="Vorname" value="${nutzer.response.vorname}">
                <input name="nachname" type="text" class="form-control" placeholder="Nachname" value="${nutzer.response.name}">
            </div>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text">Adresse</span>
                </div>
                <input name="strasse" type="text" class="form-control" placeholder="Straße" value="${nutzer.response.adresse.strasse}">
                <input name="hausnr" type="number" class="form-control" placeholder="Hausnummer" value="${nutzer.response.adresse.hausnummer}">
            </div>
            <div class="input-group mb-3">
                <input name="land" type="text" class="form-control" placeholder="D" value="${nutzer.response.adresse.land}">
                <input name="plz" type="text" class="form-control" placeholder="PLZ" value="${nutzer.response.adresse.plz}">
                <input name="ort" type="text" class="form-control" placeholder="Ort" value="${nutzer.response.adresse.ort}">
            </div>
            <button type="submit" class="btn btn-success">
                Speichern
            </button>
        </form>
    </jsp:attribute>
</template:base>
