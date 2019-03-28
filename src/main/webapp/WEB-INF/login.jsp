<%-- 
    Document   : login
    Created on : 27.03.2019, 12:27:54
    Author     : Benjamin Kanzler
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="template"%>

<!DOCTYPE html>

<template:base>
    <jsp:attribute name="title">Login</jsp:attribute>
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
