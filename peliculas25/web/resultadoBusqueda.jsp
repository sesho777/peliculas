<%-- 
    Document   : resultadoBuqueda
    Created on : 28-ago-2016, 1:51:08
    Author     : e_jus
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.PeliculasDAO"%>
<%@page import="model.Pelicula"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="navbar.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>JSP Page</title>
    </head>
    <body id="bodyResultado">
        <%
          
            
            ArrayList<Pelicula> lista = (ArrayList) request.getAttribute("listaPeliculas");%>

        <% if (lista.size() != 0) { %>

        <br><br><br><br>
        <table class="table">
            <% for (Pelicula p : lista) {%>

            <tr>
                <td><a href="pelicula.jsp?id=<%= p.getId()%>"><img src="servletImagenes?dirTitulo=<%= p.getId()%>&id=<%= p.getId()%>" class="img-rounded img-responsive" height="300px" width="300px"/></a><span><p>Titulo: <%= p.getTitulo()%></p><p>Año: <%= p.getAnio()%></p><p>Año: <%= p.getGenero()%></p></span><hr></td>
            </tr>
            
            <% } %>

        </table>
        <% } else { %>
        <div class="container-fluid">
            <div class="row">
                <h1 class="resultadoNegBusqueda">La busqueda no ha producido resultados...</h1>
            </div>
            <div class="row" style="margin-left: 45%">
                <h1 class="resultadoNegBusqueda2">: /</h1>
            </div>
        </div>
        <% }%>
    </body>
</html>
