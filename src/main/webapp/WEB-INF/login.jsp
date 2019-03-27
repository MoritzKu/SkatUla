<%-- 
    Document   : login
    Created on : 27.03.2019, 12:27:54
    Author     : Benjamin Kanzler
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<template:base>
    <jsp:attribute name="title">Login</jsp:attribute>
    <jsp:attribute name="content">
        <form>
            <label for="nickname">Nickname: </label>
            <input class="form-control form-control-sm" name="nickname" value="${kunde.response.username}" required="true"
                   type="text" readonly="true"></input>
            <label for="password">Passwort: </label>
            <input type="password" name="password" class="form-control form-control-sm" required/>
            <input type="submit" name="login" value="Login"/>
        </form>
    </jsp:attribute>
</template:base>
