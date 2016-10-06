/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.PeliculasDAO;

/**
 *
 * @author e_jus
 */
public class ServletImagenes extends HttpServlet {

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
            
            
        if (request.getParameter("id").equals(request.getParameter("id"))) {

            // Preparo los streams
            BufferedInputStream input = null; //stream de entrada que recibe los bytes de la base de datos
            BufferedOutputStream output = null;//stream de salida, que va llamar a response.getOutputstream
            PeliculasDAO pdao = new PeliculasDAO();
            int id = Integer.valueOf(request.getParameter("id"));
            InputStream photoStream = pdao.getImagenById(id);
            response.setContentType("application/octet-stream");
            // Open streams
            input = new BufferedInputStream(photoStream, 8192); // 8192 es el buffer size
            output = new BufferedOutputStream(response.getOutputStream(), 8192);

            // Write file contents to response.
            byte[] buffer = new byte[8192]; // el byte[8192] debe ser igual a los buffer size que puse antes
            int length;
            while ((length = input.read(buffer)) > 0) {
                output.write(buffer, 0, length);
               
            }

        
          output.close();
          input.close();
      

        //Redirect it to profile page
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);

    }else if(request.getParameter("dirTitulo").equals(request.getParameter("dirTitulo"))){
      
        // Preparo los streams
        BufferedInputStream input = null; //stream de entrada que recibe los bytes de la base de datos
        BufferedOutputStream output = null;//stream de salida, que va llamar a response.getOutputstream

      //dale que voy bien!! 
       PeliculasDAO pdao = new PeliculasDAO();
       int idMovie =Integer.valueOf(request.getParameter("id"));
        InputStream photoStream = pdao.getImagenById(idMovie);
        response.setContentType("application/octet-stream");
        // Open streams
        input = new BufferedInputStream(photoStream, 8192); // 8192 es el buffer size
        output = new BufferedOutputStream(response.getOutputStream(), 8192);

        // Write file contents to response.
        byte[] buffer = new byte[8192]; // el byte[8192] debe ser igual a los buffer size que puse antes
        int length;
        while ((length = input.read(buffer)) > 0) {
            output.write(buffer, 0, length);

        }

        output.close();
        input.close();

        //Redirect it to profile page
        RequestDispatcher rd = request.getRequestDispatcher("resultadoBusqueda.jsp");
        rd.forward(request, response);
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
            Logger.getLogger(ServletImagenes.class


.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ServletImagenes.class.getName()).log(Level.SEVERE, null, ex);
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
