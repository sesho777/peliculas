/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
@WebServlet(name = "ServletUpdateCuenta", urlPatterns = {"/servletUpdateCuenta"})
public class ServletUpdateCuenta extends HttpServlet {

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

        if (request.getParameter("accion").equals("modNombre")) {

            int id = Integer.valueOf(request.getParameter("id"));

            String nombre = request.getParameter("nombre");

            UsuarioDAO udao = new UsuarioDAO();

            udao.modificarNombreUsuario(nombre, id);

            response.sendRedirect("index.jsp");

        } else if (request.getParameter("accion").equals("modApellido")) {

            int id = Integer.valueOf(request.getParameter("id"));

            String apellido = request.getParameter("apellido");

            UsuarioDAO udao = new UsuarioDAO();

            udao.modificarApellidoUsuario(apellido, id);

            response.sendRedirect("index.jsp");

        } else if (request.getParameter("accion").equals("modFecNac")) {

            int id = Integer.valueOf(request.getParameter("id"));

            Date fecha = Date.valueOf(request.getParameter("fecNac"));

            UsuarioDAO udao = new UsuarioDAO();

            udao.modificarFecNacUsuario(fecha, id);

            response.sendRedirect("index.jsp");

        } else if (request.getParameter("accion").equals("modSexo")) {

            int id = Integer.valueOf(request.getParameter("id"));

            String sexo = request.getParameter("sexo");

            UsuarioDAO udao = new UsuarioDAO();

            udao.modificarSexoUsuario(sexo, id);

            response.sendRedirect("index.jsp");

        } else if (request.getParameter("accion").equals("modNacionalidad")) {

            int id = Integer.valueOf(request.getParameter("id"));

            String nacionalidad = request.getParameter("pais");

            UsuarioDAO udao = new UsuarioDAO();

            udao.modificarNacionalidadUsuario(nacionalidad, id);

            response.sendRedirect("index.jsp");

        } else if (request.getParameter("accion").equals("modEmail")) {

            int id = Integer.valueOf(request.getParameter("id"));

            String mail = request.getParameter("correo");

            UsuarioDAO udao = new UsuarioDAO();

            udao.modificarEmailUsuario(mail, id);

            response.sendRedirect("index.jsp");

        } else if (request.getParameter("accion").equals("modUsuario")) {

            int id = Integer.valueOf(request.getParameter("id"));

            String usuario = request.getParameter("usuario");

            UsuarioDAO udao = new UsuarioDAO();

            udao.modificarUserUsuario(usuario, id);
            
             Usuario u = udao.getUsuarioByUserName(usuario);
            
            /*request.getSession().invalidate();
            
            HttpSession s = request.getSession(true);*/
            
            request.getSession().setAttribute("usuario", u);
            
            request.getSession().setAttribute("nombre", u.getNombre());

            response.sendRedirect("index.jsp");

        } else if (request.getParameter("accion").equals("modPass")) {

            int id = Integer.valueOf(request.getParameter("id"));

            String pass = request.getParameter("pass");

            UsuarioDAO udao = new UsuarioDAO();

            udao.modificarPassUsuario(pass, id);

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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ServletUpdateCuenta.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ServletUpdateCuenta.class.getName()).log(Level.SEVERE, null, ex);
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
