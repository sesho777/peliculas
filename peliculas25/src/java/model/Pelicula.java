/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Image;
import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import javax.servlet.http.Part;

/**
 *
 * @author e_jus
 */
public class Pelicula {
    private int id;
    private String titulo;
    private String genero;
    private int anio;
    private String estreno;
    private File file;
    private Part part;
    private String archivo;
    private Image imagen;
    private InputStream is;
    private String url;
    private String youtube;

  
   
    public Pelicula(){}

    public Pelicula(int id, String titulo, String genero, int anio, String estreno, String url, String youtube) throws MalformedURLException {
        this.id=id;
        this.titulo = titulo;
        this.genero = genero;
        this.anio = anio;
        this.estreno = estreno;
        this.url =url;
        this.youtube = youtube;
    }
    
        public Pelicula(String titulo, String genero, int anio, String estreno,InputStream is, String url, String youtube) throws MalformedURLException {
        this.id=id;
        this.titulo = titulo;
        this.genero = genero;
        this.anio = anio;
        this.estreno = estreno;
        this.is=is;
        this.url =url;
        this.youtube = youtube;
    }
    
    
      public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }
    
    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getEstreno() {
        return estreno;
    }

    public void setEstreno(String estreno) {
        this.estreno = estreno;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public InputStream getIs() {
        return is;
    }

    public void setIs(InputStream is) {
        this.is = is;
    }

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }
    
    public String toString(){
    
    return "el titulo de la pelicula es: " + this.titulo;
}

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setId(int id) {
        this.id = id;
    }
}
