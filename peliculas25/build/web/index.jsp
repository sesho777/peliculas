<%-- 
    Document   : index
    Created on : 22-sep-2016, 20:10:17
    Author     : e_jus
--%>

<%@page import="model.Pelicula"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.PeliculasDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="navbar.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Peliculas25</title>
    </head>
    <body><br><br><br>
        <div class="container">
            <% PeliculasDAO pdao = new PeliculasDAO();

                ArrayList<Pelicula> lista = new ArrayList<>();
                ArrayList<Pelicula> lista2 = new ArrayList<>();
                ArrayList<Pelicula> lista3 = new ArrayList<>();
                lista = pdao.getTodosPelicula();
                for (Pelicula p : lista) {
                    if (p.getEstreno().equalsIgnoreCase("si")) {
                        lista2.add(p);
                    } else if (p.getEstreno().equalsIgnoreCase("no")) {
                        lista3.add(p);
                    }
                }

            %>
            <table class="table">
                <thead>
                    <tr>
                        <th colspan="2"> <strong><h1>Estrenos Peliculas25!</h1></strong></th>     
                    </tr>
                </thead> 
                <tbody>
                    <tr>
                        <% for (Pelicula p : lista2) {%>
                        <td><a href="pelicula.jsp?id=<%= p.getId()%>"><img class="img-rounded img-responsive" src="servletImagenes?id=<%= p.getId()%>" width="500" height="500"/></a></td>
                                <% }%>                                    
                    </tr>    
                </tbody>
            </table><hr style="background-color: white">
        </div>
        <div class="container-fluid">
            <table class="table">
                <thead>
                    <tr>
                        <th colspan="<%= lista3.size()%>"> <strong><h1>Ultimos Estrenos</h1></strong></th>     
                    </tr>
                </thead>
                <tbody>
                    <% int j = 0;
                        int h = 0; %>
                    <% for (int i = 0; i < lista.size(); i++) {
                            if (h == 0) {%>     
                    <tr><%}
                        h++;%>                      
                        <td><a href="pelicula.jsp?id=<%= lista.get(i).getId()%>"><img class="img img-rounded img-responsive" src="servletImagenes?id=<%=  lista.get(i).getId()%>" width="500" height="500"/></a></td>
                                <%if (h == 6) {
                                        h = 0; %>
                    </tr><%
                            }
                        }%>


                </tbody>
            </table>
        </div>
        <!-- fin filas de peliculas -->

        <div class="container-fluid" id="footer">
            <table class="table">
                <thead>
                    <tr><th></th></tr>

                </thead>
                <tbody>
                    <tr>
                        <td class="pull-right"><p><strong>Seguinos en Twitter y Facebook!</strong></p></td>                                    
                        <td><span class="btn btn-twitter"><i class="fa fa-twitter fa-3x" aria-hidden="true"></i></i></span></td>                   
                        <td><a href="https://www.facebook.com/pepito6666"><span class="btn btn-facebook"><i class="fa fa-facebook fa-3x" aria-hidden="true"></i></span></a></td>
                    </tr>
                </tbody>
            </table>

        </div>

    </body>
</html>
