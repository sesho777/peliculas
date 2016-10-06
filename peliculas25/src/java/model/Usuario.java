/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author e_jus
 */
public class Usuario {

    private int idUsuario;

    private String nombre;
    private String apellido;
    private Date fecNac;
    private String sexo;
    private String nacionalidad;
    private String email;
    private String user;
    private String pass;

    
    public Usuario(String nombre, String apellido, Date fecNac, String sexo, String nacionalidad, String email, String user, String pass) {
        
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecNac = fecNac;
        this.sexo = sexo;
        this.nacionalidad = nacionalidad;
        this.email = email;
        this.user = user;
        this.pass = pass;
    }
    
    
    public Usuario(int idUsuario, String nombre, String apellido, Date fecNac, String sexo, String nacionalidad, String email, String user, String pass) {
        this.idUsuario=idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecNac = fecNac;
        this.sexo = sexo;
        this.nacionalidad = nacionalidad;
        this.email = email;
        this.user = user;
        this.pass = pass;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFecNac() {
        return fecNac;
    }

    public void setFecNac(Date fecNac) {
        this.fecNac = fecNac;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    //*************************************************
    ArrayList lista = new ArrayList();

    String[] paises = {"Albania\n", "Alemania\n", "Andorra\n", "Angola\n", "Antigua y Barbuda\n", "Antillas Holandesas\n", "Arabia Saudita\n", "Argelia\n", "Argentina\n", "Armenia\n", "Aruba\n", "Australia\n", "Austria\n", "Azerbaijan\n", "Bahamas\n", "Bahrain\n", "Bangladesh\n", "Barbados\n", "Belarusia\n", "Belgica\n", "Belice\n", "Benin\n", "Bermudas\n", "Bolivia\n", "Bosnia\n", "Botswana\n", "Brasil\n", "Brunei Darussulam\n", "Bulgaria\n", "Burkina Faso\n", "Burundi\n", "Butan\n", "Camboya\n", "Camerun\n", "Canada\n", "Cape Verde\n", "Chad\n", "Chile\n", "China\n", "Chipre\n", "Colombia\n", "Comoros\n", "Congo\n", "Corea del Norte\n", "Corea del Sur\n", "Costa de Marfíl\n", "Costa Rica\n", "Croasia\n", "Cuba\n", "Dinamarca\n", "Djibouti\n", "Dominica\n", "Ecuador\n", "Egipto\n", "El Salvador\n", "Emiratos Arabes Unidos\n", "Eritrea\n", "Eslovenia\n", "España\n", "Estados Unidos\n", "Estonia\n", "Etiopia\n", "Fiji\n", "Filipinas\n", "Finlandia\n", "Francia\n", "Gabon\n", "Gambia\n", "Georgia\n", "Ghana\n", "Granada\n", "Grecia\n", "Groenlandia\n", "Guadalupe\n", "Guam\n", "Guatemala\n", "Guayana Francesa\n", "Guerney\n", "Guinea\n", "Guinea-Bissau\n", "Guinea Equatorial\n", "Guyana\n", "Haiti\n", "Holanda\n", "Honduras\n", "Hong Kong\n", "Hungria\n", "India\n", "Indonesia\n", "Irak\n", "Iran\n", "Irlanda\n", "Islandia\n", "Islas Caiman\n", "Islas Faroe\n", "Islas Malvinas\n", "Islas Marshall\n", "Islas Solomon\n", "Islas Virgenes Britanicas\n", "Islas Virgenes (U.S.)\n", "Israel\n", "Italia\n", "Jamaica\n", "Japon\n", "Jersey\n", "Jordania\n", "Kazakhstan\n", "Kenia\n", "Kiribati\n", "Kuwait\n", "Kyrgyzstan\n", "Laos\n", "Latvia\n", "Lesotho\n", "Libano\n", "Liberia\n", "Libia\n", "Liechtenstein\n", "Lituania\n", "Luxemburgo\n", "Macao\n", "Macedonia\n", "Madagascar\n", "Malasia\n", "Malawi\n", "Maldivas\n", "Mali\n", "Malta\n", "Marruecos\n", "Martinica\n", "Mauricio\n", "Mauritania\n", "Mexico\n", "Micronesia\n", "Moldova\n", "Monaco\n", "Mongolia\n", "Mozambique\n", "Myanmar (Burma)\n", "Namibia\n", "Nepal\n", "Nicaragua\n", "Niger\n", "Nigeria\n", "Noruega\n", "Nueva Caledonia\n", "Nueva Zealandia\n", "Oman\n", "Pakistan\n", "Palestina\n", "Panama\n", "Papua Nueva Guinea\n", "Paraguay\n", "Peru\n", "Polinesia Francesa\n", "Polonia\n", "Portugal\n", "Puerto Rico\n", "Qatar\n", "Reino Unido\n", "Republica Centroafricana\n", "Republica Checa\n", "Republica Democratica del Congo\n", "Republica Dominicana\n", "Republica Eslovaca\n", "Reunion\n", "Ruanda\n", "Rumania\n", "Rusia\n", "Sahara\n", "Samoa\n", "San Cristobal-Nevis (St. Kitts)\n", "San Marino\n", "San Vincente y las Granadinas\n", "Santa Helena\n", "Santa Lucia\n", "Santa Sede (Vaticano)\n", "Sao Tome & Principe\n", "Senegal\n", "Seychelles\n", "Sierra Leona\n", "Singapur\n", "Siria\n", "Somalia\n", "Sri Lanka (Ceilan)\n", "Sudan\n", "Sudan del Sur\n", "Suecia\n", "Suiza\n", "Sur Africa\n", "Surinam\n", "Swaziland\n", "Tailandia\n", "Taiwan\n", "Tajikistan\n", "Tanzania\n", "Timor Oriental\n", "Togo\n", "Tokelau\n", "Tonga\n", "Trinidad & Tobago\n", "Tunisia\n", "Turkmenistan\n", "Turquia\n", "Ucrania\n", "Uganda\n", "Union Europea\n", "Uruguay\n", "Uzbekistan\n", "Vanuatu\n", "Venezuela\n", "Vietnam\n", "Yemen\n", "Zambia\n", "Zimbabwe\n"
    };

    public Usuario() {
        for (int i = 0; i < paises.length; i++) {
            lista.add(paises[i]);
        }
    }

    public ArrayList getLista() {
        return lista;
    }

}
