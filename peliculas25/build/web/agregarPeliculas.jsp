<%-- 
    Document   : index
    Created on : 20-ago-2016, 22:29:58
    Author     : e_jus
--%>

<%@page import="java.io.InputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.InputStreamReader"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="navbar.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">     
        <title>JSP Page</title>
    </head>
    <body style="background-color: black">
        
        <div class="container-fluid">
    <% if (nombreSesion != null && poderes != null && poderes.equals("admin")) {%>
            <form action="servletPeliculas" method="post" id="loginForm2" enctype="multipart/form-data">         
               
                    <div class="form-group">
                        <label for="titulo">Titulo:</label>
                        <input type="text" class="form-control" id="titulo" name="titulo">
                    </div>

                    <div class="form-group">
                        <label for="genero">Genero:</label>
                        <select class="selectpicker" name="genero" id="genero" class="form-control">
                            <option value="" selected disabled>Elija Género</option>
                            <option>Terror</option>
                            <option>Accion</option>
                            <option>Suspenso</option>
                            <option>Historica</option>
                            <option>Drama</option>
                            <option>Comedia</option>
                            <option>Ciencia Ficcion</option>
                            <option>Romantica</option>
                            <option>Policial</option>
                            <option>Bélica</option>
                        </select>        
                    </div>
                    <div class="form-group">
                        <label for="anio">Año:</label>
                        <select class="selectpicker" name="anio" id="anio" value="" class="form-control">
                            <option value="" selected disabled>Elija Año</option>
                            <% for (int i = 2017; i > 1900; i--) {%>
                            <option><%=i%></option>
                            <% }%>

                        </select>
                    </div>
                
              
                    <div class="form-group">
                        <label for="radio">Es Estreno?   </label>                   
                        <label class="radio-inline"><input type="radio" name="optradio" id="radiob" value="Si">Si</label>
                        <label class="radio-inline"><input type="radio" name="optradio" id="radiob" value="No">No</label>   
                    </div>

                    <div class="form-group">
                        <input type="file" name="archivo" width="10" id="archivo" style="color:white;"/>
                    </div>

                    <div class="form-group">
                        <label for="url">URL</label>
                        <input type="text" name="url" width="10" id="url" class="form-control" />
                    </div>

                    <div class="form-group">
                        <label for="youtube">Youtube Embed:</label>
                        <input type="text" name="youtube" width="10" id="youtube" class="form-control" />
                    </div>

             
                <div class="row">
                    <input class="btn btn-primary btn-lg pull-right" type="submit" id="agregar" value="Agregar" style="color:white" />
                </div>
            </form>
            <h1 style="text-align: center; color:red;"><strong>***SOLO ACCESIBLE CON PERMISOS DE ADMINISTRADOR!!!***</strong></h1>
        </div>

 <% }else{ %>
 <h1 style="text-align: center; font-size: 3em; font-weight: bolder; color:red">--ACCESO DENEGADO--<br>🛇</h1>
   
    <% } %>
    </body>
</html>


