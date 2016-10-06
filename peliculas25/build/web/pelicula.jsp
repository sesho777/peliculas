<%-- 
    Document   : Pelicula
    Created on : 26-ago-2016, 4:14:08
    Author     : e_jus
--%>

<%@page import="model.Pelicula"%>
<%@page import="model.PeliculasDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="navbar.jsp" %>
<!DOCTYPE html>
<html>
    <head>


        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Pelicula</title>
    </head>
    <body id="bodyPeliculas">

        <div id="fb-root"></div>
        <script>(function (d, s, id) {
                var js, fjs = d.getElementsByTagName(s)[0];
                if (d.getElementById(id))
                    return;
                js = d.createElement(s);
                js.id = id;
                js.src = "//connect.facebook.net/es_LA/sdk.js#xfbml=1&version=v2.7&appId=116950835375177";
                fjs.parentNode.insertBefore(js, fjs);
            }(document, 'script', 'facebook-jssdk'));</script>


        <% PeliculasDAO pdao = new PeliculasDAO();
            //Pelicula p = new Pelicula();
            Pelicula p = pdao.getPeliculasById(Integer.valueOf(request.getParameter("id")));
            String titulo = p.getTitulo();
        %>
        <br>
        <table class="table" id="tablaPeliculas">

            <tbody>             
                <tr>
                    <td>

                        <video preload="none"  poster="servletImagenes?id=<%= pdao.getPeliculasId(Integer.valueOf(request.getParameter("id")))%>" style="width:85%; height:50%"  controls>
                            <source src= "<%= p.getUrl()%>" type="video/mp4" />
                        </video>  

                    </td>

                    <td style="width:15%;"><strong>Titulo Original: </strong><%= titulo%><br><br>
                        <strong>Genero: </strong><%= p.getGenero()%><br><br>
                        <strong>Año: </strong><%= p.getAnio()%><br><br>
                        <strong>Estreno: </strong><%= p.getEstreno()%>
                    </td>

                </tr>          
                <tr>
                    <td><Strong><br><br><br><br><br><br><p for="embed"  style="font-size: 2em">***TRAILER: <%= p.getTitulo()%>***</p></strong></td>
                </tr>
                <tr>
                    <td rowspan="4">
                        <iframe id="embed" style="width:100%; height:200%;"  src="<%= p.getYoutube()%>" frameborder="0" allowfullscreen ></iframe>
                    </td>
                </tr>

            <br><br><br>             
            </tbody>
        </table>
        <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
        <div class="fb-comments" data-href="https://www.facebook.com/peliculas25.25/?fref=ts" data-width="100%" data-numposts="10" colorscheme="dark"></div>


    </body>
</html>
