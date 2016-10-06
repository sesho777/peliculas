<%-- 
    Document   : registro
    Created on : 29-ago-2016, 3:11:22
    Author     : e_jus
--%>

<%@page import="model.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="navbar.jsp" %>
<!DOCTYPE html>
<html>
    <head>

        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>JSP Page</title>
    </head>
    <% if(session.getAttribute("nombre")==null){ %>
    <body id="bodyRegistro"><br>
        <div class="container-fluid">
            <form id="loginForm" action="servletUsuarios" method="post">
                <div class="form-group">
                    <label for="nombre">Nombre:</label>
                    <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Ingresa tu nombre...">
                    <label class="has-error hide" id="nombreError" >*Debe completar el campo "Nombre"!</label>
                </div>
                <div class="form-group">
                    <label for="apellido">Apellido:</label>
                    <input type="text" class="form-control" id="apellido" name="apellido" placeholder="Ingresa tu apellido...">
                    <label class="has-error hide" id="apellidoError" >*Debe completar el campo "Apellido"!</label>
                </div>

                <div class="form-group">
                    <label for="dob">Fecha de Nacimiento:</label>
                    <input type="date" class="form-control" id="dob" name="dob" required="true">
                </div>

                <div class="form-group">
                    <label>Sexo:</label>
                    <label class="radio-inline">
                        <input type="radio" name="optradio" value="Masculino" required="true">Masculino
                    </label>
                    <label class="radio-inline">
                        <input type="radio" name="optradio" value="Femenino" required="true">Femenino
                    </label>

                </div>

                <div class="form-group">
                    <% Usuario user = new Usuario();


                    %>
                    <label for="sel1">Nacionalidad:</label>
                    <select class="form-control" id="sel1" name="pais" required="true">
                        <option value="" selected disabled>Elegí País...</option>
                        <% for (int i = 0; i < user.getLista().size(); i++) {%>
                        <option><%= user.getLista().get(i)%></option>
                        <% }%>
                    </select>
                    <label class="has-error hide" id="nacionalidadError" >*Debe elegir un pais!</label>
                </div>

                <div class="form-group" id="divPass">
                    <label for="correo">Correo Electronico:</label>
                    <input type="email" class="form-control" id="correo" name="correo" placeholder="Ingresá tu correo electronico...">
                    <label class="has-error hide" id="correoError" >*Debe completar el campo "Correo Electronico"!</label>
                </div>

                <div class="form-group" id="divPass">
                    <label for="user">Nombre de Usuario:</label>
                    <input type="text" class="form-control" id="user" name="user" placeholder="Ingresá nombre de usuario..."><strong><span id="respuesta"></span></strong>
                    <label class="has-error hide" id="usuarioError" >*Debe completar el campo "Nombre de Usuario"!</label>
                </div>


                <div class="form-group" id="divPass">
                    <label for="pass">Contraseña:</label>
                    <input type="password" class="form-control" id="pass" name="pass" placeholder="Ingresá contraseña...">
                    <label class="has-error hide" id="passError" >*Debe completar el campo "Contraseña"!</label>
                </div>
                <div class="form-group" id="divPass2">
                    <label for="pass2">Confirmar Contraseña:</label>
                    <input type="password" class="form-control" onkeyup="validar()" id="pass2"placeholder="Ingresá contraseña nuevamente...">
                    <label class="has-error hide" id="passError2" >*Las contraseñas no coinciden!</label>
                </div>



                <br>
                <div class="row" id="registrate">
                    <span class="pull-left"><strong>¿Ya tenes una cuenta?<br> <a href="login.jsp">Inicia sesion!</a></strong></span>
                    <button type="submit" class="btn btn-primary pull-right" id="loginButton" onclick="miFuncion()">Registrate!</button>
                </div><br><br><br><br><br><br><br><br><br>
            </form>
        </div><% }else{ %>
        <br><br><br>
        <h1 style="color:white; text-align: center">Para registrar un nuevo usuario, debes cerrar esta sesion</h1> <% } %>
        <script>
            function miFuncion() {

                var nombre = $("#nombre").val();
                var apellido = $("#apellido").val();
                var correo = $("#correo").val();
                var usuario = $("#user").val();
                var pass = $("#pass").val();
                if (nombre === "") {

                    $("#nombreError").removeClass("hide");
                    $("#nombreError").css("color", "red");
                    $("#nombre").css("border", "red 2px solid");
                    event.preventDefault();
                } else {
                    $("#nombreError").addClass("hide");
                    $("#nombre").css("border", "");
                }
                if (apellido === "") {

                    $("#apellidoError").removeClass("hide");
                    $("#apellidoError").css("color", "red");
                    $("#apellido").css("border", "red 2px solid");
                    event.preventDefault();
                } else {
                    $("#apellidoError").addClass("hide");
                    $("#apellido").css("border", "");
                }
                if (correo === "") {

                    $("#correoError").removeClass("hide");
                    $("#correoError").css("color", "red");
                    $("#correo").css("border", "red 2px solid");
                    event.preventDefault();
                } else {
                    $("#correoError").addClass("hide");
                    $("#correo").css("border", "");
                }
                if (usuario === "") {

                    $("#usuarioError").removeClass("hide");
                    $("#usuarioError").css("color", "red");
                    $("#user").css("border", "red 2px solid");
                    event.preventDefault();
                } else {
                    $("#usuarioError").addClass("hide");
                    $("#user").css("border", "");
                }
                if (pass === "") {

                    $("#passError").removeClass("hide");
                    $("#passError").css("color", "red");
                    $("#pass").css("border", "red 2px solid");
                    event.preventDefault();
                } else {
                    $("#passError").addClass("hide");
                    $("#pass").css("border", "");
                }

            }

            function validar() {
                var pass = $("#pass").val();
                var pass2 = $("#pass2").val();
                if (pass !== pass2) {
                    event.preventDefault();
                    $("#passError2").removeClass("hide");
                    $("#passError2").css("color", "red");
                    $("#pass2").css("border", "red 2px solid");
                } else {

                    $("#passError2").addClass("hide");
                    $("#pass2").css("border", "");
                }

            }

            $(document).ready(function () {
                var resp;
                $("#user").attr("autocomplete","off");
                $("#user").keyup(function () {
                    $.ajax({
                        url: "servletAjax",
                        dataType: "html",
                        contentType: "charset=UTF-8",
                        method: "GET",
                        data: {
                            id: $("#user").val()
                        },
                        success: function (responseText) {
                            if ("true" === responseText) {
                                /*$("#user").append("<span id="respuesta"></span>");*/
                                $("#respuesta").css("color", "red");
                                $("#respuesta").html("*El usuario ya existe!");
                                resp =responseText;
                            } else {
                                /*$("#user").after("<span id="respuesta"></span>");*/
                                $("#respuesta").css("color", "green");
                                $("#respuesta").html("Usuario Disponible!");
                                resp =responseText;
                            }

                        },
                        error: function (jqXHR, textStatus, errorThrown) {
                            alert(textStatus + errorThrown);
                        }
                    });
                });
                
                    $("#loginButton").click(function(){
                    
                    if(resp==="true" || $("#user").val()===""){
                        
                        event.preventDefault();
                    }else{
                        $("#loginForm").submit();
                    }
                    
                });
               
            });






        </script>
    </body>
</html>
