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
        
        <!-- Test von Fabian Login Bereich aufgehübscht -->
        <form action="action_page.php">
            <div class="imgcontainer">
              <img src="img_avatar2.png" alt="Avatar" class="avatar">
            </div>

            <div class="container">
              <label for="uname"><b>Username</b></label>
              <input type="text" placeholder="Enter Username" name="uname" required>

              <label for="psw"><b>Password</b></label>
              <input type="password" placeholder="Enter Password" name="psw" required>

              <button type="submit">Login</button>
              <label>
                <input type="checkbox" checked="checked" name="remember"> Remember me
              </label>
            </div>

            <div class="container" style="background-color:#f1f1f1">
              <button type="button" class="cancelbtn">Cancel</button>
              <span class="psw">Forgot <a href="#">password?</a></span>
            </div>
        </form> 
    </jsp:attribute>
</template:base>
