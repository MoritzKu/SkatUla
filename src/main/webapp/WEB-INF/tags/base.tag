<%-- 
    Document   : base.tag
    Created on : 20.03.2019, 10:08:52
    Author     : Benjamin Kanzler
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="title"%>
<%@attribute name="content" fragment="true"%>
<%@attribute name="head" fragment="true"%>
<%@attribute name="header" fragment="true"%>
<%@attribute name="footer" fragment="true" %>

<%-- any content can be specified here e.g.: --%>
<html>
    <title>
        SkatUla | ${title}
    </title>
    <head>
        <!-- CSS einbinden -->
        <link rel="stylesheet" href="style.css">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/base.css"/>">

        <!--Favicon -->
        <link rel="icon" type="image/png" sizes="32x32" href="images/favicon-32x32.png">

        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

        <!-- Popper JS -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script> 
        <jsp:invoke fragment="head"/>
        <!--Versuch ein Hintergrundbild einzubauen -->
        <style type="text/css">
            body{
                background: url(WEB-INF/tags/hintergrund.jpg) no-repeat fixed;
            }
        </style>

    </head>
    <body>
        <header>
            <!-- Navigationsbereich der Anwendung-->
            <nav class="navbar navbar-expand-md bg-dark navbar-dark sticky-top">
                <a href="<c:url value="/"/>" class="navbar-brand p-0">
                    <img class="logo p-0 rounded-circle" style="max-width:50px" src="images/Logo_Placeholder.png" alt="SketUla Logo"/> 
                    <span class="brand h3">SkatUla</span>
                </a>
                <div class="">
                    <input class="form-control mr-sm-2" type="text" placeholder="Search">
                    <button class="btn btn-success" style="margin:5px;" type="submit">
                        Suchen
                    </button>
                    <a href="<c:url value="/register"/>">
                        <button type="button" class="btn btn-success">
                            Kurse
                        </button>
                    </a>
                    <div class="justify-content-center">
                        <c:if test="${empty nutzer || nutzer.response == null}">
                            <a href="<c:url value="/register"/>">
                                <button type="button" class="btn btn-link">
                                    Registrieren
                                </button>
                            </a>
                            <a href="<c:url value="/login"/>">
                                <button type="button" class="btn btn-sm btn-outline-primary mr-2">
                                    Login
                                </button>
                            </a>
                        </c:if>
                        <c:if test="${!empty nutzer && nutzer.response != null}">
                            <!-- Navbar links -->
                            <a href="<c:url value="/logout"/>">
                                <button class="btn btn-outline-light">
                                    Logout
                                </button>
                            </a>
                            <a href="<c:url value="/accountdetails"/>">
                                <button class="btn btn-outline-light">
                                    Profil
                                </button>
                            </a>
                        </c:if>
                    </div>
                </div>
            </nav>
            <jsp:invoke fragment="header"/>
        </header>
        <div>
            <jsp:invoke fragment="content"/>
        </div>
    </body>
    <footer>
        <jsp:invoke fragment="footer"/>
    </footer>
</html>