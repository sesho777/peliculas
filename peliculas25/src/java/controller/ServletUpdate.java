/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.Pelicula;
import model.PeliculasDAO;

/**
 *
 * @author e_jus
 */
public class ServletUpdate extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        if (request.getParameter("accion").equals("modificar")) {

            PeliculasDAO pdao = new PeliculasDAO();
            int id=Integer.valueOf(request.getParameter("id"));
            
            Pelicula p= pdao.getPeliculasById2(id);
          
            request.setAttribute("pelicula", p);
            request.getRequestDispatcher("modificarPel.jsp").forward(request, response);

        } else if (request.getParameter("accion").equals("eliminar")) {
            
            PeliculasDAO pdao = new PeliculasDAO();
            Pelicula p= pdao.getPeliculasById2(Integer.valueOf(request.getParameter("id")));
          
          
            int id = (int) p.getId();
            String titulo= p.getTitulo();
            
            pdao.eliminarPelicula(titulo, id);
            
            request.getRequestDispatcher("modificarDatosPeliculas.jsp").forward(request, response);
            
            

        }/* else if (request.getParameter("modificarCampos").equals("escondido")) {
            PeliculasDAO pdao = new PeliculasDAO();
            String titulo = request.getParameter("titulo");
            String genero = request.getParameter("genero");
            int anio = Integer.valueOf(request.getParameter("anio"));
            String estreno = request.getParameter("estreno");

            Part filePart = request.getPart("imagen");
             InputStream fileContent = filePart.getInputStream();
            String url = request.getParameter("url");
           
            String youtube = request.getParameter("youtube");

            pdao.modificarDatosPelicula(titulo, genero, anio, estreno, fileContent, url, youtube);
            
            request.getRequestDispatcher("modificar.jsp").forward(request, response);
        }*/
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ServletUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ServletUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
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
