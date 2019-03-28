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
    <body>
        <header>
            <!-- Navigationsbereich der Anwendung-->
            <nav class="navbar navbar-expand-md bg-dark navbar-dark sticky-top">
                <a href="<c:url value="/"/>" class="navbar-brand p-0">
                    <img class="logo p-0 rounded-circle" src="images/Logo_Placeholder.png" alt="SketUla Logo"/> 
                    <span class="brand h3">SketUla</span>
                </a>
                <div class="">
                    <form class="form-inline" action="/action_page.php">
                        <input class="form-control mr-sm-2" type="text" placeholder="Search">
                        <button class="btn btn-success" type="submit">
                            Suchen
                        </button>
                    </form>
                    <div class="justify-content-center">
                        <c:if test="${empty nutzer}">
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
                        <c:if test="${!empty nutzer}">
                            <!-- Toggler/collapsibe Button -->
                            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">

                            </button>
                            <!-- Navbar links -->
                            <div class="collapse navbar-collapse" id="collapsibleNavbar">
                                <ul class="navbar-nav">
                                    <li class="nav-item">
                                        <a href="<c:url value="/logout"/>">
                                            <button class="btn btn-outline-link btn-sm">    
                                                Logout
                                            </button>
                                        </a>
                                    </li>
                                    <li class="nav-item">
                                        <a href="<c:url value="/profil"/>">
                                            <button class="btn btn-outline-link btn-sm">    
                                                Profil
                                            </button>
                                        </a>
                                    </li>
                                </ul>
                            </div>
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