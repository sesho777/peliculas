<%-- 
    Document   : login
    Created on : 27-ago-2016, 17:03:10
    Author     : e_jus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="navbar.jsp" %>
<%@page errorPage="paginaError.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1"> 
        <title>JSP Page</title>
    </head>
    <body id="bodyLogin"><br><br><br><br>
        <div class="container-fluid" id="containerLogin">
            <form id="loginForm" action="servletLogin" method="post">
                <div class="form-group">
                    <label for="usuario">Usuario:</label>
                    <input type="text" class="form-control" id="usuario" name="usuario">
                    <input type="hidden" id="thisField" name="validacion" value="login">
                </div>
                <div class="form-group" id="divPass">
                    <label for="pwd">Contraseña:</label>
                    <input type="password" class="form-control" id="pwd" name="pass">
                </div><br>
                <div class="row" id="registrate">
                    <span class="pull-left"><strong>¿No tenés una cuenta?<br> <a href="registro.jsp">Registrate!</a></strong></span>
                    <button type="submit" class="btn btn-primary pull-right" id="loginButton">Iniciar Sesion</button><br>
                    <% if (request.getAttribute("error") != null) {%>
                    <p><span class="col-md-12" id="resp"><%= request.getAttribute("error")%></span></p>
                    <% }%>
                </div>
            </form>
        </div>    
    </body>
</html>
