/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author
 */
@Entity
@Table(name = "tb_usuarios")

public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "contrasenna")
    private String contrasenna;
    @Basic(optional = false)
    @Column(name = "perfil")
    private String perfil;
    
    //Crear Vector para Tabla
    //Variable constante: No cambia su valor en el programa Nunca. Van en Mayúscula.
    public static final String[] TITULOS_USUARIOS  = {"Usuario", "Nombre", "Contraseña", "Perfil"};

    public Usuarios(String usuario, String nombre, String contrasenna, String perfil) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.contrasenna = contrasenna;
        this.perfil = perfil;
    }
    
     public Usuarios() {
        this.usuario = "";
        this.nombre = "";
        this.contrasenna = "";
        this.perfil = "";
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    @Override
    public String toString() {
        return "Usuarios{" + "usuario=" + usuario + ", nombre=" + nombre + ", contrasenna=" + contrasenna + ", perfil=" + perfil + '}';
    }

}//Fin CLASS
