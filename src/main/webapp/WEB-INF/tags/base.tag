<%-- 
    Document   : base.tag
    Created on : 20.03.2019, 10:08:52
    Author     : Benjamin Kanzler
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="title"%>
<%@attribute name="main" fragment="true"%>
<%@attribute name="head" fragment="true"%>
<%@attribute name="header" fragment="true"%>
<%@attribute name="footer" fragment="true" %>

<%-- any content can be specified here e.g.: --%>
<html>
    <title>
        SkatUla | ${title}
    </title>
    <head>
        <jsp:invoke fragment="head"></jsp:invoke>
    </head>
    <body>
    <jsp:invoke fragment="header"></jsp:invoke>
    <jsp:invoke fragment="main"></jsp:invoke>
    <jsp:invoke fragment="footer"></jsp:invoke>
    </body>
    
    
</html>