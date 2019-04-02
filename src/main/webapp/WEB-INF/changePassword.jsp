<%-- 
    Document   : changePassword
    Created on : 02.04.2019, 10:37:16
    Author     : Benjamin Kanzler
--%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="template" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<template:base>
    <jsp:attribute name="title">Passwort ändern</jsp:attribute>
    <jsp:attribute name="content">
        <h1>Account Detail ${nutzer.response.username}</h1>
        <form method="POST">
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text">altes Passwort</span>
                </div>
                <input name="oldPassword" type="password" class="form-control">
            </div>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text">neues Passwort</span>
                </div>
                <input name="newPassword" type="password" class="form-control">
                <div class="input-group-prepend">
                    <span class="input-group-text">neues Passwort bestätigen</span>
                </div>
                <input name="newPasswordConfirm" type="password" class="form-control">
            </div>
            <button class="">Passwort ändern</button>
        </form>
    </jsp:attribute>
</template:base>
