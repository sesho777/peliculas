<%-- 
    Document   : miCuenta
    Created on : 16-sep-2016, 22:56:13
    Author     : e_jus
--%>

<%@page import="model.UsuarioDAO"%>
<%@page import="model.Usuario"%>
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
    <body><br><br>
        <div class="container-fluid" id="contenedorMiCuenta">
            <% UsuarioDAO udao = new UsuarioDAO();
                Usuario u2 = udao.getUsuarioById(Integer.valueOf(request.getParameter("id")));
            %>
            <h1><strong>「 Datos de Mi Cuenta 」</strong></h1><br><br>
                <p> Nombre: <span><%=  u2.getNombre()%> </span><a href="#" id="nMod">[Modificar]</a></p>
                <form hidden="true" action="servletUpdateCuenta" method="post" id="nForm">
                    <input type="text" name="nombre" id="nom"><input type="hidden" name="accion" value="modNombre">
                    <input type="hidden" name="id" value="<%=  u2.getIdUsuario()%>">
                    <button type="submit" class="btn btn-primary" onclick="validarCambioNom()">Actualizar</button>
                </form> 
                <p> Apellido: <span><%= u2.getApellido()%></span> <a href="#" id="aMod">[Modificar]</a></p>
                <form hidden="true" action="servletUpdateCuenta" method="post" id="aForm">
                    <input type="text" name="apellido" id="ape"><input type="hidden" name="accion" value="modApellido">
                    <input type="hidden" name="id" value="<%=  u2.getIdUsuario()%>">
                    <button type="submit" class="btn btn-primary" onclick="validarCambioApe()">Actualizar</button>
                </form> 
                <p> Fecha de Nacimiento:<span> <%= u2.getFecNac()%> </span><a href="#" id="fMod">[Modificar]</a></p>
                <form hidden="true" action="servletUpdateCuenta" method="post" id="fForm">
                    <input type="date" name="fecNac" id="dob"><input type="hidden" name="accion" value="modFecNac">
                    <input type="hidden" name="id" value="<%=  u2.getIdUsuario()%>">
                    <button type="submit" class="btn btn-primary" onclick="validarCambioDob()">Actualizar</button>
                </form> 


                <p> Sexo: <span><%= u2.getSexo()%></span> <a href="#" id="sMod">[Modificar]</a></p>
                <form hidden="true" action="servletUpdateCuenta" method="post" id="sForm">                  
                    <label><input type="radio" name="sexo" id="sex" value="Masculino" required>Masculino</label>
                    <label><input type="radio" name="sexo" id="sex" value="Femenino" required>Femenino</label>   
                    <input type="hidden" name="accion" value="modSexo">
                    <input type="hidden" name="id" value="<%= u2.getIdUsuario()%>">
                    <button type="submit" class="btn btn-primary">Actualizar</button>
                </form> 


                <p> Nacionalidad: <span><%= u2.getNacionalidad()%></span> <a href="#" id="naMod">[Modificar]</a></p>
                <% Usuario user = new Usuario();  %>
                <form hidden="true" action="servletUpdateCuenta" method="post" id="naForm" style="color:black">   
                    <input type="hidden" name="accion" value="modNacionalidad">
                    <select id="" name="pais" required="true">
                        <option value="" selected disabled>Elegí País...</option>
                        <% for (int i = 0; i < user.getLista().size(); i++) {%>
                        <option><%= user.getLista().get(i)%></option>
                        <% }%>
                    </select>
                    <input type="hidden" name="id" value="<%=  u.getIdUsuario()%>">
                    <button type="submit" class="btn btn-primary">Actualizar</button>
                </form>



                <p> E-Mail: <span><%= u2.getEmail()%></span> <a href="#" id="eMod">[Modificar]</a></p>
                <form hidden="true" action="servletUpdateCuenta" method="post" id="eForm">
                    <input type="email" name="correo" id="mail"><input type="hidden" name="accion" value="modEmail">
                    <input type="hidden" name="id" value="<%= u2.getIdUsuario()%>">
                    <button type="submit" class="btn btn-primary" onclick="validarCambioEmail()">Actualizar</button>
                </form> 

                <p>  Nombre de Usuario: <span><%= u2.getUser()%></span> <a href="#" id="uMod">[Modificar]</a> </p>
                <form hidden="true" action="servletUpdateCuenta" method="post" id="uForm">
                    <input type="text" name="usuario" id="use"><strong><span id="respuesta"></span></strong>
                    <input type="hidden" name="accion" value="modUsuario">
                    <input type="hidden" name="id" value="<%= u2.getIdUsuario()%>">
                    <button class="btn btn-primary" onclick="validarCambioUsuario()" id="botonUsuario">Actualizar</button>
                </form> 

                <p> Contraseña: <span><%= u2.getPass()%></span> <a href="#" id="pMod">[Modificar]</a> </p>
                <form hidden="true" action="servletUpdateCuenta" method="post" id="pForm">
                    <input type="text" name="pass" id="pass"><input type="hidden" name="accion" value="modPass">
                    <input type="hidden" name="id" value="<%= u.getIdUsuario()%>">
                    <button class="btn btn-primary" onclick="validarCambioPass()">Actualizar</button>
                </form> 
            </div>
        


        <script>


            function validarCambioNom() {
                var nombre = $("#nom").val().trim();

                if (nombre === "") {
                    $("#nom").css("border", "2px solid red");
                    event.preventDefault();
                }
            }
            function validarCambioApe() {
                var apellido = $("#ape").val().trim();
                if (apellido === "") {
                    $("#ape").css("border", "2px solid red");
                    event.preventDefault();
                }

            }

            function validarCambioDob() {
                var dob = $("#dob").val().trim();
                if (dob === "") {
                    $("#dob").css("border", "2px solid red");
                    event.preventDefault();
                }

            }

            function validarCambioEmail() {
                var mail = $("#mail").val().trim();
                if (mail === "") {
                    $("#mail").css("border", "2px solid red");
                    event.preventDefault();
                }

            }

            function validarCambioUsuario() {
                var usuario = $("#use").val().trim();

                if (usuario === "") {
                    $("#use").css("border", "2px solid red");
                    event.preventDefault();
                }

            }
            function validarCambioPass() {
                var pass = $("#pass").val().trim();
                if (pass === "") {
                    $("#pass").css("border", "2px solid red");
                    event.preventDefault();
                }

            }


            $(document).ready(function () {

                $("#nMod").click(function () {

                    $("#nForm").show();
                });
                $("#aMod").click(function () {

                    $("#aForm").show();
                });
                $("#aMod").click(function () {

                    $("#aForm").show();
                });
                $("#fMod").click(function () {

                    $("#fForm").show();
                });
                $("#sMod").click(function () {

                    $("#sForm").show();
                });

                $("#naMod").click(function () {

                    $("#naForm").show();
                });

                $("#eMod").click(function () {

                    $("#eForm").show();
                });
                $("#uMod").click(function () {

                    $("#uForm").show();
                });
                $("#pMod").click(function () {

                    $("#pForm").show();
                });

                $("#use").attr("autocomplete", "off");
                var resp;
                $("#use").keyup(function () {

                    $.ajax({
                        url: "servletAjax",
                        dataType: "html",
                        contentType: "charset=UTF-8",
                        method: "GET",
                        data: {
                            id: $("#use").val()

                        },
                        success: function (responseText) {
                            if ("true" === responseText) {
                                $("#respuesta").css("color", "red");
                                $("#respuesta").html("*El usuario ya existe!");

                                resp = responseText;

                            } else {

                                $("#respuesta").css("color", "green");
                                $("#respuesta").html("Usuario Disponible!");
                                resp = responseText;

                                //
                            }

                        },
                        error: function (jqXHR, textStatus, errorThrown) {
                            alert(textStatus + errorThrown);

                        }
                    });

                });

                $("#botonUsuario").click(function () {

                    if (resp === "true" || $("#use").val() === "") {

                        event.preventDefault();
                    } else {
                        $("#uForm").submit();
                    }

                });

            });



        </script>



    </body>
</html>
