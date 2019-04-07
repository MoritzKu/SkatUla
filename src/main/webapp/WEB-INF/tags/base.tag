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

        <link rel="stylesheet" href="<c:url value="/css/base.css"/>">
        <link rel="stylesheet" href="<c:url value="/css/login.css"/>">
        <link rel="stylesheet" href="<c:url value="/css/index.css"/>">
        <link rel="stylesheet" href="<c:url value="/css/kursuebersicht.css"/>">

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

    </head>
    <body class="back">
        <header>
            <nav class="navbar navbar-dark bg-dark">
                <div class="box1">
                    <a href="<c:url value="/"/>" class="navbar-brand p-0">
                        <img class="logo p-0 rounded-circle" style="max-width:50px" src="images/Logo_Placeholder.png" alt="SketUla Logo"/> 
                        <span class="brand h3">SkatUla</span>                        
                    </a>                

                    <!-- Button um Modal-Kontoeinstellungen zu triggern -->
                    <button type="button" class="btn btn-success" data-toggle="modal" data-target="#exampleModal">
                        Konto
                    </button>
                    <!-- Modal -->
                    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Konto verwalten</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <c:if test="${empty nutzer || nutzer.response == null}">
                                        <a href="<c:url value="/register"/>">
                                            <img src="<c:url value="/images/registration.png"/>" alt="selfhtml">                                        
                                            <p1 class="modalKonto"> Registrieren </p1>
                                        </a>
                                        <hr>
                                        <a href="<c:url value="/login"/>">
                                            <img src="<c:url value="/images/login.png"/>" alt="selfhtml"> 
                                            <p1 class="modalKonto">    Login</p1>
                                        </a>
                                    </c:if>

                                    <c:if test="${!empty nutzer && nutzer.response != null}">
                                        <a href="<c:url value="/logout"/>">
                                            <img src="<c:url value="/images/logout.png"/>" alt="selfhtml">                                        
                                            <p1 class="modalKonto">Logout</p1>
                                        </a>
                                        <hr>
                                        <a href="<c:url value="/accountdetails"/>">
                                            <img src="<c:url value="/images/profile.png"/>" alt="selfhtml">                                        
                                            <p1 class="modalKonto">Profil verwalten</p1>
                                        </a>
                                    </c:if>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-success" data-dismiss="modal">Close</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="box2">
                    <a href="<c:url value="/kursuebersicht"/>">
                        <button type="button" class="btn btn-success">
                            Kurse
                        </button>
                    </a>
                    <!-- Weiteren Button für die Planverwaltung -->
                    <a href="<c:url value="/planuebersicht"/>">
                        <button type="button" class="btn btn-success">
                            Pläne
                        </button>
                    </a>
                    <!-- Weiterer Button für die Terminverwaltung -->
                    <a href="<c:url value="/terminuebersicht"/>">
                        <button type="button" class="btn btn-success">
                            Termine
                        </button>
                    </a>
                </div>
                <div class="box3">
                    <form class="form-inline my-2 my-lg-0">
                        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-success" type="submit">Search</button>
                    </form>
                </div>                    
            </nav>
            <jsp:invoke fragment="header"/>
        </header>
        <div class="overlay">
            <jsp:invoke fragment="content"/>
        </div>
    </body>
    <footer>
        <jsp:invoke fragment="footer"/>
    </footer>
</html>
