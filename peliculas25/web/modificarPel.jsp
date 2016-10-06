<%-- 
    Document   : modificarPel
    Created on : 12-sep-2016, 7:13:43
    Author     : e_jus
--%>

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
    <body>
        <br><br><br><br>
        <div class="container-fluid" id="contenedorModificarPel">
   <% if (nombreSesion != null && poderes != null && poderes.equals("admin")) {%>
            <% Pelicula p = (Pelicula) request.getAttribute("pelicula");%>

            
            <p> Titulo: <span><%= p.getTitulo()%></span> <a href="#" id="tMod">[Modificar]</a></p>
                <form hidden="true" action="servletMod" method="post" id="tForm">
                    <input type="text" name="titulo" id="tit"><input type="hidden" name="accion" value="modTitulo">
                    <input type="hidden" name="id" value="<%= p.getId()%>">
                    <button type="submit" class="btn btn-primary" onclick="validarCambioTit()">Actualizar</button>
                </form> 
                <p> Genero: <span><%= p.getGenero()%></span> <a href="#" id="gMod">[Modificar]</a></p>
                <form hidden="true" action="servletMod" method="post" id="gForm">
                    <input type="text" name="genero" id="gen"><input type="hidden" name="accion" value="modGenero">
                    <input type="hidden" name="id" value="<%= p.getId()%>">
                    <button type="submit" class="btn btn-primary" onclick="validarCambioGen()">Actualizar</button>
                </form> 
                <p> Año: <span><%= p.getAnio()%></span> <a href="#" id="aMod">[Modificar]</a></p>
                <form hidden="true" action="servletMod" method="post" id="aForm">
                    <select class="selectpicker" name="anio" id="ani" value="" style="color:black" required>
                        <option value="" selected disabled>Elija Año</option>
                        <% for (int i = 2016; i > 1900; i--) {%>
                        <option><%=i%></option>
                        <% }%>
                    </select>
                    <input type="hidden" name="accion" value="modAnio">
                    <input type="hidden" name="id" value="<%= p.getId()%>">
                    <button type="submit" class="btn btn-primary">Actualizar</button>
                </form> 
                     <p> Estreno: <span><%= p.getEstreno() %></span> <a href="#" id="eMod">[Modificar]</a></p>
                <form hidden="true" action="servletMod" method="post" id="eForm">
                    <label for="radio">Es Estreno?   </label>                   
                        <label><input type="radio" name="estreno" id="radiob" value="Si" required>Si</label>
                        <label><input type="radio" name="estreno" id="radiob" value="No" required>No</label>   
                    <input type="hidden" name="accion" value="modEstreno">
                    <input type="hidden" name="id" value="<%= p.getId()%>">
                    <button type="submit" class="btn btn-primary">Actualizar</button>
                </form> 
                    
                <p>Imagen:  <img src="servletImagenes?id=<%= p.getId()%>" class="img-rounded img-responsive" width="250" height="250"/> <a href="#" id="iMod">[Modificar]</a> </p>
                <form hidden="true" action="servletMod" method="post" id="iForm" enctype="multipart/form-data">
                    <input type="file" name="archivo" width="10" id="ima" style="color:white"/> 
                    <input type="hidden" name="accion" value="modImagen">
                    <input type="hidden" name="id" value="<%= p.getId()%>">
                    <button type="submit" class="btn btn-primary" onclick="validarCambioIma()">Actualizar</button>
                </form> 
               
                <p> URL: <span><%= p.getUrl()%></span> <a href="#" id="uMod">[Modificar]</a></p>
                <form hidden="true" action="servletMod" method="post" id="uForm">
                    <input type="text" name="url" id="url"><input type="hidden" name="accion" value="modUrl">
                    <input type="hidden" name="id" value="<%= p.getId()%>">
                    <button type="submit" class="btn btn-primary" onclick="validarCambioUrl()">Actualizar</button>
                </form> 
                <p>  Youtube embed: <span><%= p.getYoutube()%></span> <a href="#" id="yMod">[Modificar]</a> </p>
                 <form hidden="true" action="servletMod" method="post" id="yForm">
                    <input type="text" name="you" id="you"><input type="hidden" name="accion" value="modYoutube">
                    <input type="hidden" name="id" value="<%= p.getId()%>">
                    <button type="submit" class="btn btn-primary" onclick="validarCambioYou()">Actualizar</button>
                </form> 
            
        </div>
<% }else{ %><br><br><br><br>
    <h1 style="text-align: center; font-size: 3em; font-weight: bolder; color:red">--ACCESO DENEGADO--<br>🛇</h1>
    
    <% } %>

        <script>






            function validarCambioTit() {
                var titulo = $("#tit").val().trim();

                if (titulo === "") {
                    $("#tit").css("border", "2px solid red");
                    event.preventDefault();
                }
            }
            function validarCambioGen() {
                var genero = $("#gen").val().trim();
                if (genero === "") {
                    $("#gen").css("border", "2px solid red");
                    event.preventDefault();
                }

            }
           /* function validarCambioAnio() {
                var anio = $("#ani").val().trim();
                if (anio === "") {
                    $("#ani").css("border", "2px solid red");
                    event.preventDefault();
                }

            }function validarCambioEst() {
                var estreno = $("#est").val().trim();
                if (estreno === "") {
                    $("#est").css("border", "2px solid red");
                    event.preventDefault();
                }

            }*/
            function validarCambioIma() {
                var imagen = $("#ima").val().trim();
                if (imagen === "") {
                    $("#ima").css("border", "2px solid red");
                    event.preventDefault();
                }

            }
            function validarCambioUrl() {
                var url = $("#url").val().trim();
                if (url === "") {
                    $("#url").css("border", "2px solid red");
                    event.preventDefault();
                }

            }
             function validarCambioYou() {
                var you = $("#you").val().trim();
                if (you === "") {
                    $("#you").css("border", "2px solid red");
                    event.preventDefault();
                }

            }

            $(document).ready(function () {

                $("#tMod").click(function () {

                    $("#tForm").show();
                });
                $("#gMod").click(function () {

                    $("#gForm").show();
                });
                $("#aMod").click(function () {

                    $("#aForm").show();
                });
                 $("#eMod").click(function () {

                    $("#eForm").show();
                });
                  $("#iMod").click(function () {

                    $("#iForm").show();
                });
                  $("#uMod").click(function () {

                    $("#uForm").show();
                });
                  $("#yMod").click(function () {

                    $("#yForm").show();
                });

            });



        </script>

    </body>
</html>
