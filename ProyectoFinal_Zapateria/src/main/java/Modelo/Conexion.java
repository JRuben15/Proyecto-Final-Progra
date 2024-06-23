/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Rubén Delgado C
 */
//En esta clase se implementara la conexión a la base de Datos

public class Conexion {
    Connection conectar;
    
    //Variables para ractificar la conexión.
    String usuario = "root";
    String contrasenna = "";
    String bd = "bd_usuarios";
    String ip = "localhost"; 
    String puerto = "3306";
    
    //Cadena de conexión.
    String cadena = "jdbc:mysql://"+ip+":"+puerto+"/"+bd;
    
    //Metodo para establecer la conexion
    public Connection establecerConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection(cadena, usuario, contrasenna);
           // mostrarMensaje("La conexión a la base de datos se realizo satisfactoriamente.");
            
        } catch (Exception e) {
            mostrarMensaje("No se pudo realizar la conexión "+e.toString());
        }
        return conectar;
    }//Fin MÉTODO establecerConexion
    
    public void mostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje);
    }
    
}//Fin CLASS

