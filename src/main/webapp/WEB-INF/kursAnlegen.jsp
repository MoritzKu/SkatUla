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

            <input name="bezeichnung" type="text" class="form-control" placeholder="Behzeichnung" value="">
            <input name="maxTeilnehmer" type="number" class="form-control" placeholder="Maximale Teilnehmerzahl" value="">
            <input name="schwierigkeitsgrad" type="text" class="form-control" placeholder="Schwierigkeitsgrad" value="">


            <button type="submit" class="btn btn-success"> speichern </button>
        </form>
    </jsp:attribute>
</template:base>

