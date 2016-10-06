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
import javax.servlet.http.HttpSession;
import model.Usuario;
import model.UsuarioDAO;

/**
 *
 * @author e_jus
 */
public class ServletLogin extends HttpServlet {

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
            throws ServletException, IOException {

       

        

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
        
        if (request.getParameter("accion").equals("cerrar")) {

            request.getSession().invalidate();
            response.sendRedirect("index.jsp");

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
        processRequest(request, response);

         if (request.getParameter("validacion").equals("login")) {
            
            try {
                String usuario = request.getParameter("usuario").trim();
                String pass = request.getParameter("pass").trim();
                ArrayList lista = new ArrayList();
                UsuarioDAO udao = new UsuarioDAO();
                lista.addAll(udao.getAllUsuariosYClaves());
                Usuario u = udao.getUsuarioByUserName(usuario);
                
                
                if (lista.contains(usuario) && lista.contains(pass)) {
                    
                    HttpSession session = request.getSession();
                    
                    session.setAttribute("nombre", usuario);
                    session.setAttribute("usuario", u);
                    
                    if(usuario.equals("sesho")){
                        session.setAttribute("poderes", "admin");
                        response.sendRedirect("index.jsp");
                        
                    }else{
                        response.sendRedirect("index.jsp");
                    }
                } else {
                    request.setAttribute("error", "*Usuario y/o contraseña invalidos!");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(ServletLogin.class.getName()).log(Level.SEVERE, null, ex);
            }

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
