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
            <div class="row">
                <div class="col-md-12">
                    <div class="row">
                        <div class="col-md-2">
                            <a href="<c:url value="/"/>" class="navbar-brand p-0">
                                <img class="logo p-0" src="<c:url value="/images/Logo_Placeholder.png"/>" alt="SketUla Logo" /> 
                                <span class="brand h3">SketUla</span>
                            </a>
                        </div>
                        <div class="col-md-6">
                            Menu
                        </div>
                        <div class="col-md-4">
                            <div class="row">
                                <div class="col-md-2">
                                    <button type="button" class="btn btn-link">
                                    <a href="<c:url value="/register"/>">Registrieren</a>
                                    </button>
                                </div>
                                <div class="col-md-2">
                                    <c:if test="${!empty nutzer}">
                                        <button type="button" class="btn btn-outline-primary">
                                        <a href="/login">Login</a>
                                        </button>
                                    </c:if>
                                    <c:if test="${empty nutzer}">
                                        <button type="button" class="btn btn-outline-info">
                                        <a href="/logout">Logout</a>
                                        </button>
                                    </c:if>
                                </div>
                            </div>
                        </div>    
                    </div>
                </div>
            </div>
            <jsp:invoke fragment="header"/>
        </header>
        <main>
            <jsp:invoke fragment="content"/>
        </main>
        <footer>
            <jsp:invoke fragment="footer"/>
        </footer>
    </body>
</html>