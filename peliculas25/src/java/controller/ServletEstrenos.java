/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pelicula;
import model.PeliculasDAO;

/**
 *
 * @author e_jus
 */
public class ServletEstrenos extends HttpServlet {

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
      
        if(request.getParameter("anio").equals("2016")){
            
            int anio = Integer.valueOf(request.getParameter("anio"));
                        
            PeliculasDAO pdao = new PeliculasDAO();
            
            ArrayList<Pelicula> lista = new ArrayList<>();
            
            lista= pdao.getPeliculaByYear(anio);
            
            request.setAttribute("estrenos", lista);
            
            request.setAttribute("anio", anio);
            
            request.getRequestDispatcher("estrenos.jsp").forward(request, response);
      
        }else if(request.getParameter("anio").equals("2015")){
            
            int anio = Integer.valueOf(request.getParameter("anio"));
                        
            PeliculasDAO pdao = new PeliculasDAO();
            
            ArrayList<Pelicula> lista = new ArrayList<>();
            
            lista= pdao.getPeliculaByYear(anio);
            
            request.setAttribute("estrenos", lista);
            
            request.setAttribute("anio", anio);
            
            request.getRequestDispatcher("estrenos.jsp").forward(request, response);
      
        }else if(request.getParameter("anio").equals("2014")){
            
            int anio = Integer.valueOf(request.getParameter("anio"));
                        
            PeliculasDAO pdao = new PeliculasDAO();
            
            ArrayList<Pelicula> lista = new ArrayList<>();
            
            lista= pdao.getPeliculaByYear(anio);
            
            request.setAttribute("estrenos", lista);
            
            request.setAttribute("anio", anio);
            
            request.getRequestDispatcher("estrenos.jsp").forward(request, response);
      
        }else{
            
             PeliculasDAO pdao = new PeliculasDAO();
            
             ArrayList<Pelicula> lista = new ArrayList<>();
            
            int anio = Integer.valueOf(request.getParameter("anio"));    
            
            request.setAttribute("estrenos", lista);
            
            request.setAttribute("anio", anio);
            
            request.getRequestDispatcher("estrenos.jsp").forward(request, response);
            
            
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ServletEstrenos.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ServletEstrenos.class.getName()).log(Level.SEVERE, null, ex);
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
