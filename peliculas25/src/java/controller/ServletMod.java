/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.Pelicula;
import model.PeliculasDAO;


@WebServlet("/upload2")
@MultipartConfig(maxFileSize = 16777215)    // upload file's size up to 16MB
public class ServletMod extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("accion").equals("modTitulo")) {

            PeliculasDAO pdao = new PeliculasDAO();
            int idMovie = Integer.valueOf(request.getParameter("id"));
            String titulo = request.getParameter("titulo");

            pdao.modificarNombrePelicula(titulo, idMovie);

            response.sendRedirect("index.jsp");

        } else if (request.getParameter("accion").equals("modGenero")) {

            PeliculasDAO pdao = new PeliculasDAO();
            int idMovie = Integer.valueOf(request.getParameter("id"));
            String genero = request.getParameter("genero");

            pdao.modificarGeneroPelicula(genero, idMovie);

            response.sendRedirect("index.jsp");

        } else if (request.getParameter("accion").equals("modAnio")) {

            PeliculasDAO pdao = new PeliculasDAO();
            int idMovie = Integer.valueOf(request.getParameter("id"));
            int anio = Integer.valueOf(request.getParameter("anio"));

            pdao.modificarAnioPelicula(anio, idMovie);

            response.sendRedirect("index.jsp");

        } else if (request.getParameter("accion").equals("modEstreno")) {

            PeliculasDAO pdao = new PeliculasDAO();
            int idMovie = Integer.valueOf(request.getParameter("id"));
            String estreno = request.getParameter("estreno");

            pdao.modificarEstrenoPelicula(estreno, idMovie);

            response.sendRedirect("index.jsp");

        } else if (request.getParameter("accion").equals("modImagen")) {
            PeliculasDAO pdao = new PeliculasDAO();
            int idMovie = Integer.valueOf(request.getParameter("id"));
            Part filePart = request.getPart("archivo");
            InputStream fileContent = filePart.getInputStream();

            pdao.modificarImagenPelicula(fileContent, filePart, idMovie);

            response.sendRedirect("index.jsp");
            
        } else if (request.getParameter("accion").equals("modUrl")) {
            
            PeliculasDAO pdao = new PeliculasDAO();
            int idMovie = Integer.valueOf(request.getParameter("id"));
            String url = request.getParameter("url");

            pdao.modificarUrlPelicula(url, idMovie);

            response.sendRedirect("index.jsp");
            
            
            
            
            

        } else if (request.getParameter("accion").equals("modYoutube")) {
            
            PeliculasDAO pdao = new PeliculasDAO();
            int idMovie = Integer.valueOf(request.getParameter("id"));
            String you = request.getParameter("you");

            pdao.modificarYoutubePelicula(you, idMovie);

            response.sendRedirect("index.jsp");
            

        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
