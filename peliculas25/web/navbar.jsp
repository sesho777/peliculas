<%-- 
    Document   : navbar
    Created on : 22-sep-2016, 20:10:38
    Author     : e_jus
--%>

<%@page import="model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="paginaError.jsp" %>
<!DOCTYPE html>
<html lang="es">
    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet'  type='text/css'>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet">
        <link rel="stylesheet" href="css/estilos.css">
    </head>
    <body>
        <% String nombreSesion = (String) session.getAttribute("nombre");
            String poderes = (String) session.getAttribute("poderes");
            Usuario u = (Usuario) session.getAttribute("usuario"); %>

        <% if (nombreSesion != null && poderes != null && poderes.equals("admin")) {%>

        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.jsp"><span class="glyphicon glyphicon-film"></span>Peliculas25</a>
                </div>
                <div class="collapse navbar-collapse navbar-right" id="myNavbar">
                    <ul class="nav navbar-nav">
                        <li><a href="index.jsp">Home</a></li>
                        <li class="dropdown estDrop">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#">Estrenos <span class="caret"></span></a>
                            <ul class="dropdown-menu estrenos">
                                <li><a href="servletEstrenos?anio=2016">Estrenos 2016</a></li>
                                <li><a href="servletEstrenos?anio=2015">Estrenos 2015</a></li>
                                <li><a href="servletEstrenos?anio=2014">Estrenos 2014</a></li>
                            </ul>
                        </li>
                        <li><a href="#"><form action="servletBusquedas" method="get"><input type="text" id="busqueda" name="busqueda" placeholder="Buscar pelicula..."/><button id="buscar" type="submit" onclick="validarBusqueda()"  style="background-color: transparent; border:none"><i class="glyphicon glyphicon-search"></i></button></form></a></li>       
                    </ul>
                    <ul class="nav navbar-nav navbar-right">

                        <li class="dropdown userDrop">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <span class="glyphicon glyphicon-user"></span> <%= u.getUser()%> <b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu usuario">
                                <li id="sesion"><a href="miCuenta.jsp?id=<%= u.getIdUsuario()%>">Mi Cuenta</a></li>
                                <li id="sesion"><a href="agregarPeliculas.jsp">Agregar Peliculas</a></li>
                                <li id="sesion"><a href="modificarDatosPeliculas.jsp">Modificar Peliculas</a></li>
                                <li><a href="servletLogin?accion=cerrar">Cerrar Sesión</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <% } else if (nombreSesion != null) {%>

        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.jsp"><span class="glyphicon glyphicon-film"></span>Peliculas25</a>
                </div>
                <div class="collapse navbar-collapse navbar-right" id="myNavbar">
                    <ul class="nav navbar-nav">
                        <li><a href="index.jsp">Home</a></li>
                        <li class="dropdown estDrop">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#">Estrenos <span class="caret"></span></a>
                            <ul class="dropdown-menu estrenos">
                                <li><a href="servletEstrenos?anio=2016">Estrenos 2016</a></li>
                                <li><a href="servletEstrenos?anio=2015">Estrenos 2015</a></li>
                                <li><a href="servletEstrenos?anio=2014">Estrenos 2014</a></li>
                            </ul>
                        </li>
                        <li><a href="#"><form action="servletBusquedas" method="get"><input type="text" id="busqueda" name="busqueda" placeholder="Buscar pelicula..."/><button id="buscar" type="submit" onclick="validarBusqueda()"  style="background-color: transparent; border:none"><i class="glyphicon glyphicon-search"></i></button></form></a></li>       
                    </ul>
                    <ul class="nav navbar-nav navbar-right">

                        <li class="dropdown userDrop">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <span class="glyphicon glyphicon-user"></span> <%= u.getUser()%> <b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu usuario">
                                <li id="sesion"><a href="miCuenta.jsp?id=<%= u.getIdUsuario()%>">Mi Cuenta</a></li>                              
                                <li><a href="servletLogin?accion=cerrar">Cerrar Sesión</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>





        <%} else { %>      

        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.jsp"><span class="glyphicon glyphicon-film"></span>Peliculas25</a>
                </div>
                <div class="collapse navbar-collapse navbar-right" id="myNavbar">
                    <ul class="nav navbar-nav">
                        <li><a href="index.jsp">Home</a></li>
                        <li class="dropdown estDrop">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#">Estrenos <span class="caret"></span></a>
                            <ul class="dropdown-menu estrenos">
                               <li><a href="servletEstrenos?anio=2016">Estrenos 2016</a></li>
                                <li><a href="servletEstrenos?anio=2015">Estrenos 2015</a></li>
                                <li><a href="servletEstrenos?anio=2014">Estrenos 2014</a></li>
                            </ul>
                        </li>
                        <li><a href="#"><form action="servletBusquedas" method="get"><input type="text" id="busqueda" name="busqueda" placeholder="Buscar pelicula..."/><button id="buscar" type="submit" onclick="validarBusqueda()"  style="background-color: transparent; border:none"><i class="glyphicon glyphicon-search"></i></button></form></a></li>       

                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="registro.jsp"><span class="glyphicon glyphicon-user"></span> Registrarse</a></li>
                        <li><a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span> Iniciar Sesión</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <% }%>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script>
                            function validarBusqueda() {
                                var busqueda = $("#busqueda").val();
                                if (busqueda === "") {
                                    event.preventDefault();
                                }
                            }
                            $(document).ready(function () {

                                $(".estDrop").mouseenter(function () {

                                    $(".estrenos").slideDown();


                                });
                                $(".estDrop").mouseleave(function () {

                                    $(".estrenos").slideUp();


                                });

                                $(".userDrop").mouseenter(function () {

                                    $(".usuario").slideDown();


                                });
                                $(".userDrop").mouseleave(function () {

                                    $(".usuario").slideUp();


                                });

                            });


        </script>
    </body>
</html>

