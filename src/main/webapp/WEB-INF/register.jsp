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
            <div class="loginSpace">

                <h1> Registrieren </h1>

                <div class="chooseUser">
                    <div class="btn-group btn-group-toggle" data-toggle="buttons">
                        <label class="btn btn-success" for="kunde" checked="true">
                            <input type="radio" name="nutzertyp" class="form-check-input"
                                   value="1" id="kunde" checked> Kunde
                        </label>
                        <label class="btn btn-success" for="mitarbeiter">
                            <input type="radio" name="nutzertyp" class="form-check-input"
                                   value="2" id="mitarbeiter"> Trainer
                        </label>
                    </div>
                </div>



                <br>
                <p> <label for="nickname">Nickname: </label></p>
                <input class="form-control form-control-sm" name="nickname" placeholder="username" required="true"
                       type="text"></input>
                <hr>
                <p><label for="password">Passwort: </label></p>
                <input type="password" name="password" class="form-control form-control-sm" required="true"/>
                <hr>
                <p><button class="btn btn-success" type="submit" name="login">Registrieren</button></p>
            </div>
        </form>
    </jsp:attribute>
</template:base>
