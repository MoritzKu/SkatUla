<%-- 
    Document   : register
    Created on : 27.03.2019, 14:36:13
    Author     : Benjamin Kanzler
--%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="template"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<template:base>
    <jsp:attribute name="title">Registrierung</jsp:attribute>
    <jsp:attribute name="content">
        <form method="POST">
            <div class="form-check-inline">
                <label class="form-check-label" for="kunde">
                    <input type="radio" name="nutzertyp" class="form-check-input"
                           value="1" id="kunde" checked> Kunde
                </label>
            </div>
            <div class="form-check-inline">
                <label class="form-check-label" for="mitarbeiter">
                    <input type="radio" name="nutzertyp" class="form-check-input"
                           value="2" id="mitarbeiter"> Trainer
                </label>
            </div>
            <br>
            <label for="nickname">Nickname: </label>
            <input class="form-control form-control-sm" name="nickname" placeholder="username" required="true"
                   type="text"></input>
            <label for="password">Passwort: </label>
            <input type="password" name="password" class="form-control form-control-sm" required="true"/>
            <button class="btn btn-sm btn-outline-primary" type="submit" name="login">Login</button>
        </form>
    </jsp:attribute>
</template:base>
