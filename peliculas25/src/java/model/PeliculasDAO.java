/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import conexion.MiConexion;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.servlet.http.Part;
import javax.swing.JOptionPane;

/**
 *
 * @author e_jus
 */
public class PeliculasDAO {

    Pelicula p = new Pelicula();
    MiConexion con = new MiConexion();
    PreparedStatement ps;
    Statement st;
    ArrayList lista = new ArrayList();

    public void agregarPeliculas(Pelicula p) throws FileNotFoundException {
        FileInputStream fis = null;
        try {
            con.conectarABBDD().setAutoCommit(false);
            ps = con.conectarABBDD().prepareStatement("INSERT INTO peliculas (titulo, genero, año, estreno, imagen, url, youtube)"
                    + "VALUES(?,?,?,?,?,?,?)");
            ps.setString(1, p.getTitulo());
            ps.setString(2, p.getGenero());
            ps.setInt(3, p.getAnio());
            ps.setString(4, p.getEstreno());
            ps.setBinaryStream(5, p.getIs(), (int) p.getPart().getSize());
            ps.setString(6, p.getUrl());
            ps.setString(7, p.getYoutube());
            ps.executeUpdate();
            con.conectarABBDD().commit();
        } catch (SQLException ex) {
            String error = ex.getMessage();
            System.out.println(error);
        }
    }

    public InputStream getImagenById(int id) throws SQLException, IOException {

        con.conectarABBDD();

        InputStream inpst = null;

        ps = con.conectarABBDD().prepareStatement("SELECT imagen FROM peliculas WHERE idMovie=?");

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            inpst = rs.getBinaryStream("imagen");        
        }
        return inpst;
    }

    public int getPeliculasId(int id) throws SQLException, IOException {

        con.conectarABBDD();

        int i = 0;

        ps = con.conectarABBDD().prepareStatement("SELECT idMovie FROM peliculas WHERE idMovie=?");

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            p.setId(rs.getInt("idMovie"));
        }
        return p.getId();
    }

    public ArrayList getTodos() throws SQLException, IOException {
        lista = new ArrayList();
        con.conectarABBDD();

        int i = 0;

        ps = con.conectarABBDD().prepareStatement("SELECT * FROM peliculas");

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            i = rs.getInt("idMovie");
            lista.add(i);
        }
        return lista;
    }

    public ArrayList getTodosPelicula() throws SQLException, IOException {
        lista = new ArrayList();
        con.conectarABBDD();

        ps = con.conectarABBDD().prepareStatement("SELECT * FROM peliculas");

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            p = new Pelicula(rs.getInt("idMovie"), rs.getString("titulo"), rs.getString("genero"), rs.getInt("año"), rs.getString("estreno"), rs.getString("url"), rs.getString("youtube"));
            lista.add(p);
        }
        return lista;
    }

    public ArrayList getTodosPeliculaConImagen() throws SQLException, IOException {
        lista = new ArrayList();
        con.conectarABBDD();

        ps = con.conectarABBDD().prepareStatement("SELECT * FROM peliculas");

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            p = new Pelicula(rs.getString("titulo"), rs.getString("genero"), rs.getInt("año"), rs.getString("estreno"), rs.getBinaryStream("imagen"), rs.getString("url"), rs.getString("youtube"));
            lista.add(p);
        }
        return lista;

    }

    public Pelicula getPeliculasById(int id) throws SQLException, IOException {

        con.conectarABBDD();

        int i = 0;

        ps = con.conectarABBDD().prepareStatement("SELECT * FROM peliculas WHERE idMovie=?");

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            p = new Pelicula();
            p.setTitulo(rs.getString("titulo"));
            p.setGenero(rs.getString("genero"));
            p.setAnio(rs.getInt("año"));
            p.setEstreno(rs.getString("estreno"));
            p.setIs(rs.getBinaryStream("imagen"));
            p.setUrl(rs.getString("url"));
            p.setYoutube(rs.getString("youtube"));
        }

        return p;

    }

    public Pelicula getPeliculasByTitulo(String nombre) throws SQLException, IOException {

        con.conectarABBDD();

        ps = con.conectarABBDD().prepareStatement("SELECT * FROM peliculas WHERE titulo LIKE ?");

        ps.setString(1, "%" + nombre.trim() + "%");
        ResultSet rs = ps.executeQuery();
       
        while (rs.next()) {

            p = new Pelicula(rs.getInt("idMovie"), rs.getString("titulo"), rs.getString("genero"), rs.getInt("año"), rs.getString("estreno"), rs.getString("url"), rs.getString("youtube"));
           
        }
        con.conectarABBDD().close();
        ps.close();
        rs.close();
        return p;

    }
    
     public Pelicula getPeliculasById2(int id) throws SQLException, IOException {

        con.conectarABBDD();

        

        ps = con.conectarABBDD().prepareStatement("SELECT * FROM peliculas WHERE idMovie=?");

        //ps.setString(1, nombre);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        //rs.beforeFirst();
        while (rs.next()) {

            p = new Pelicula(rs.getInt("idMovie"), rs.getString("titulo"), rs.getString("genero"), rs.getInt("año"), rs.getString("estreno"), rs.getString("url"), rs.getString("youtube"));
           
        }
        con.conectarABBDD().close();
        ps.close();
        rs.close();
        return p;

    }
     
        public ArrayList getPeliculaByYear(int year) throws SQLException, IOException {

        con.conectarABBDD();
        
        ps = con.conectarABBDD().prepareStatement("SELECT * FROM peliculas WHERE año=?");
      
        ps.setInt(1, year);
        ResultSet rs = ps.executeQuery();
      
        while (rs.next()) {

            p = new Pelicula(rs.getInt("idMovie"), rs.getString("titulo"), rs.getString("genero"), rs.getInt("año"), rs.getString("estreno"), rs.getString("url"), rs.getString("youtube"));
           lista.add(p);
        }
        con.conectarABBDD().close();
        ps.close();
        rs.close();
        return lista;

    }

    public ArrayList getAllPeliculasByTitulo(String nombre) throws SQLException, IOException {

        con.conectarABBDD();

        int i = 0;

        ps = con.conectarABBDD().prepareStatement("SELECT * FROM peliculas WHERE titulo LIKE ?");

        ps.setString(1, nombre.trim() + "%");
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {

            p = new Pelicula(rs.getInt("idMovie"), rs.getString("titulo"), rs.getString("genero"), rs.getInt("año"), rs.getString("estreno"), rs.getString("url"), rs.getString("youtube"));
            
            lista.add(p);
        }
        con.conectarABBDD().close();
        ps.close();
        rs.close();
        return lista;

    }

    public void modificarNombrePelicula(String titulo, int idMovie) {

        try {
            con.conectarABBDD().setAutoCommit(false);

            ps = con.conectarABBDD().prepareStatement("UPDATE peliculas SET titulo=? WHERE idMovie=?");

            ps.setString(1, titulo);
            ps.setInt(2, idMovie);

            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.getCause();
        }

    }

    public void modificarGeneroPelicula(String genero, int idMovie) {

        try {
            con.conectarABBDD().setAutoCommit(false);

            ps = con.conectarABBDD().prepareStatement("UPDATE peliculas SET genero=? WHERE idMovie=?");

            ps.setString(1, genero);
            ps.setInt(2, idMovie);

            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.getCause();
        }

    }

    public void modificarAnioPelicula(int anio, int idMovie) {

        try {
            con.conectarABBDD().setAutoCommit(false);

            ps = con.conectarABBDD().prepareStatement("UPDATE peliculas SET año=? WHERE idMovie=?");

            ps.setInt(1, anio);
            ps.setInt(2, idMovie);

            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.getCause();
        }

    }

    public void modificarEstrenoPelicula(String estreno, int idMovie) {

        try {
            con.conectarABBDD().setAutoCommit(false);

            ps = con.conectarABBDD().prepareStatement("UPDATE peliculas SET estreno=? WHERE idMovie=?");

            ps.setString(1, estreno);
            ps.setInt(2, idMovie);

            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.getCause();
        }

    }

    public void modificarImagenPelicula(InputStream is, Part parte, int idMovie) {

        try {
            con.conectarABBDD().setAutoCommit(false);

            ps = con.conectarABBDD().prepareStatement("UPDATE peliculas SET imagen=? WHERE idMovie=?");

            ps.setBinaryStream(1, is, (int) parte.getSize());
            ps.setInt(2, idMovie);

            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.getCause();
        }

    }
     public void modificarUrlPelicula(String url, int idMovie) {

        try {
            con.conectarABBDD().setAutoCommit(false);

            ps = con.conectarABBDD().prepareStatement("UPDATE peliculas SET url=? WHERE idMovie=?");

            ps.setString(1, url);
            ps.setInt(2, idMovie);

            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.getCause();
        }

    }
      public void modificarYoutubePelicula(String you, int idMovie) {

        try {
            con.conectarABBDD().setAutoCommit(false);

            ps = con.conectarABBDD().prepareStatement("UPDATE peliculas SET youtube=? WHERE idMovie=?");

            ps.setString(1, you);
            ps.setInt(2, idMovie);

            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.getCause();
        }

    }
       public void eliminarPelicula(String titulo, int idMovie) {

        try {
            con.conectarABBDD().setAutoCommit(false);

            ps = con.conectarABBDD().prepareStatement("DELETE FROM peliculas WHERE titulo=? AND idMovie=?");

            ps.setString(1, titulo);
            ps.setInt(2, idMovie);

            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.getCause();
        }

    }

}
