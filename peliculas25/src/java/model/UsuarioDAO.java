/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import conexion.MiConexion;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.catalina.tribes.util.Arrays;

/**
 *
 * @author e_jus
 */
public class UsuarioDAO {

    Connection con = null;
    Statement st = null;
    PreparedStatement ps = null;
    MiConexion c = new MiConexion();
    int count;
    boolean valido = false;
    ArrayList lista = new ArrayList();
    Usuario user = new Usuario();

    public boolean registrarUsuario(Usuario u) {

        try {

            ps = c.conectarABBDD().prepareStatement("INSERT INTO usuarios (nombre, apellido, fechaNacimiento, sexo, nacionalidad, email, usuario, pass) VALUES (?,?,?,?,?,?,?,?)");

            ps.setString(1, u.getNombre());
            ps.setString(2, u.getApellido());
            ps.setDate(3, u.getFecNac());
            ps.setString(4, u.getSexo());
            ps.setString(5, u.getNacionalidad());
            ps.setString(6, u.getEmail());
            ps.setString(7, u.getUser());
            ps.setString(8, u.getPass());

            ps.executeUpdate();

            return valido = true;

        } catch (SQLException ex) {
            String error = Arrays.toString(ex.getStackTrace());
            System.out.println(ex.getStackTrace());
            return valido = false;
        } finally {
            try {
                c.conectarABBDD().close();

            } catch (SQLException e) {
                e.getStackTrace();
            }
        }

    }

    public ArrayList getAllUsuarios() {

        try {
            st = c.conectarABBDD().createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM usuarios");

            while (rs.next()) {

                lista.add(rs.getString("usuario"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public ArrayList getAllUsuariosYClaves() {

        try {
            st = c.conectarABBDD().createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM usuarios");

            while (rs.next()) {

                lista.add(rs.getString("usuario"));
                lista.add(rs.getString("pass"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public Usuario getUsuarioByUserName(String username) throws SQLException, IOException {

        ps = c.conectarABBDD().prepareStatement("SELECT * FROM usuarios WHERE usuario=?");

        //ps.setString(1, nombre);
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();
        //rs.beforeFirst();
        while (rs.next()) {

            user = new Usuario(rs.getInt("idUsuario"), rs.getString("nombre"), rs.getString("apellido"), rs.getDate("fechaNacimiento"), rs.getString("sexo"), rs.getString("nacionalidad"), rs.getString("email"), rs.getString("usuario"), rs.getString("pass"));
            /* p.setTitulo(rs.getString("titulo"));
            p.setGenero(rs.getString("genero"));
            p.setAnio(rs.getInt("año"));
            p.setEstreno(rs.getInt("estreno"));*/
            //System.out.println(p.getTitulo());
        }
        c.conectarABBDD().close();
        ps.close();
        rs.close();
        return user;

    }
    
        public Usuario getUsuarioById(int id) throws SQLException, IOException {

        ps = c.conectarABBDD().prepareStatement("SELECT * FROM usuarios WHERE idUsuario=?");

        //ps.setString(1, nombre);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        //rs.beforeFirst();
        while (rs.next()) {

            user = new Usuario(rs.getInt("idUsuario"), rs.getString("nombre"), rs.getString("apellido"), rs.getDate("fechaNacimiento"), rs.getString("sexo"), rs.getString("nacionalidad"), rs.getString("email"), rs.getString("usuario"), rs.getString("pass"));
           
        }
        c.conectarABBDD().close();
        ps.close();
        rs.close();
        return user;

    }

    public void modificarNombreUsuario(String nombre, int idUsuario) {

        try {

            ps = c.conectarABBDD().prepareStatement("UPDATE usuarios SET nombre=? WHERE idUsuario=?");

            ps.setString(1, nombre);
            ps.setInt(2, idUsuario);

            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.getCause();
        }

    }

    public void modificarApellidoUsuario(String apellido, int idUsuario) {

        try {

            ps = c.conectarABBDD().prepareStatement("UPDATE usuarios SET apellido=? WHERE idUsuario=?");

            ps.setString(1, apellido);
            ps.setInt(2, idUsuario);

            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.getCause();
        }

    }

    public void modificarFecNacUsuario(Date fecNac, int idUsuario) {

        try {

            ps = c.conectarABBDD().prepareStatement("UPDATE usuarios SET fechaNacimiento=? WHERE idUsuario=?");

            ps.setDate(1, fecNac);
            ps.setInt(2, idUsuario);

            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.getCause();
        }

    }

    public void modificarSexoUsuario(String sexo, int idUsuario) {

        try {

            ps = c.conectarABBDD().prepareStatement("UPDATE usuarios SET sexo=? WHERE idUsuario=?");

            ps.setString(1, sexo);
            ps.setInt(2, idUsuario);

            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.getCause();
        }

    }

    public void modificarNacionalidadUsuario(String nacionalidad, int idUsuario) {

        try {

            ps = c.conectarABBDD().prepareStatement("UPDATE usuarios SET nacionalidad=? WHERE idUsuario=?");

            ps.setString(1, nacionalidad);
            ps.setInt(2, idUsuario);

            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.getCause();
        }

    }

    public void modificarEmailUsuario(String email, int idUsuario) {

        try {

            ps = c.conectarABBDD().prepareStatement("UPDATE usuarios SET email=? WHERE idUsuario=?");

            ps.setString(1, email);
            ps.setInt(2, idUsuario);

            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.getCause();
        }

    }
       public void modificarUserUsuario(String user, int idUsuario) {

        try {

            ps = c.conectarABBDD().prepareStatement("UPDATE usuarios SET usuario=? WHERE idUsuario=?");

            ps.setString(1, user);
            ps.setInt(2, idUsuario);

            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.getCause();
        }

    }
            public void modificarPassUsuario(String pass, int idUsuario) {

        try {

            ps = c.conectarABBDD().prepareStatement("UPDATE usuarios SET pass=? WHERE idUsuario=?");

            ps.setString(1, pass);
            ps.setInt(2, idUsuario);

            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.getCause();
        }

    }

}
