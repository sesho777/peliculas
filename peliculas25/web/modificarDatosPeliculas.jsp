<%-- 
    Document   : modificarDatosPeliculas
    Created on : 01-sep-2016, 6:05:58
    Author     : e_jus
--%>

<%@page import="model.Pelicula"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.PeliculasDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="navbar.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>JSP Page</title>
    </head>
    <body>
       
        <div id="contenedor2">
             <% if (nombreSesion != null && poderes != null && poderes.equals("admin")) {%>
            <h1 style="margin:2%; color:white; text-align: center;text-decoration: underline">Modificar Datos de las Peliculas</h1><br><br>
     
            <% PeliculasDAO pdao = new PeliculasDAO();
                ArrayList<Pelicula> lista = new ArrayList<>();
                lista = pdao.getTodosPelicula();
            %>
            

            <table class="table">
                <thead>
                    <tr>
                        <th class="tituloMod" colspan="5">Lista de peliculas</th>                   
                    </tr>
                    <tr>
                        <th class="tituloMod">Titulo</th>
                        <th class="tituloMod">Genero</th>
                        <th class="tituloMod">Año</th>
                        <th class="tituloMod">Modificar</th>
                        <th class="tituloMod">Eliminar</th>
                    </tr>
                </thead>
                <tbody>

                    <% for (Pelicula p : lista) {%>
                    <tr>
                        <td class="itemsMod"><%= p.getTitulo()%></td>
                        <td class="itemsMod2"><%= p.getGenero()%></td>
                        <td class="itemsMod2"><%= p.getAnio()%></td> 



                        <td class="itemsMod2"><a href="servletUpdate?accion=modificar&id=<%= p.getId()  %>"><span class="glyphicon glyphicon-pencil"></span></a></td>
                        <td class="itemsMod2"><a href="servletUpdate?accion=eliminar&id=<%= p.getId() %>"><span class="glyphicon glyphicon-trash"></span></a></td>

                    </tr>
                    <% }%>

                </tbody>
            </table>


        </div>
        <h2 style="text-align: center; color:red;"><strong>***SOLO ACCESIBLE CON PERMISOS DE ADMINISTRADOR!!!***</strong></h2>
        <% }else{ %><br><br><br><br>
    <h1 style="text-align: center; font-size: 3em; font-weight: bolder; color:red"">--ACCESO DENEGADO--</h1>
    <h1 style="text-align: center; font-size: 7em; font-weight: bolder; color:red">🛇</h1>
    <% } %>
    </body>
</html>
