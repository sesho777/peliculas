/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author e_jus
 */
public class MiConexion {

    Connection con;

    public Connection conectarABBDD() {

        try {
 
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            con = DriverManager.getConnection("jdbc:mysql://localhost/peliculas25", "root", "");

        } catch (Exception ex) {
            ex.getCause();
        }
        return con;
    }

}
