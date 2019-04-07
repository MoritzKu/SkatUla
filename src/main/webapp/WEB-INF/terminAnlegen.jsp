<%-- 
    Document   : terminAnlegen
    Created on : 05.04.2019, 19:39:03
    Author     : f_lieb
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="template"%>


<!DOCTYPE html>

<template:base>
    <jsp:attribute name="title">Terminübersicht</jsp:attribute>
    <jsp:attribute name="content">
        <form method="POST">
            <h1> Termin anlegen</h1> 
            
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="basic-addon3" >Termine</span>
                </div>
                <input name="bezeichnung" type="text" class="form-control" value="" id="basic-url" aria-describedby="basic-addon3" required="true">
            </div>
            
             <div class="dropdown">
                <button class="dropbtn">Termine</button>
                <div class="dropdown-content">
                  <a href="#">Testtermin 1</a>
                  <a href="#">Testtermin 2</a>
                  <a href="#">Testtermin 3</a>
                </div>
              </div> 
             
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="basic-addon3" >Zeit</span>
                </div>
                <input name="time" type="time" class="form-control" value="" id="basic-url" aria-describedby="basic-addon3" required="true">
            </div>
            
             <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="basic-addon3" >Datum</span>
                </div>
                <input name="datum" type="date" class="form-control" value="" id="basic-url" aria-describedby="basic-addon3" required="true">
            </div>
            
             <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="basic-addon3" >Dauer</span>
                </div>
                <input name="dauer" type="number" class="form-control" value="" id="basic-url" aria-describedby="basic-addon3" required="true">
            </div>
            
            <button type="submit" class="btn btn-success"> speichern </button>
        </form>
    </jsp:attribute>
</template:base>
