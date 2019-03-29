<%-- 
    Document   : accountdetails
    Created on : 29.03.2019, 11:59:50
    Author     : Benjamin Kanzler
--%>
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
                    <span class="input-group-text">Person</span>
                </div>
                <input name="vorname" type="text" class="form-control" placeholder="Vorname">
                <input name="nachname" type="text" class="form-control" placeholder="Nachname">
            </div>
            <button type="submit" class="btn btn-outline-primary btn-sm">
                Speichern
            </button>
        </form>
    </jsp:attribute>
</template:base>
