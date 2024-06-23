/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Controlador.Controlador_Menu;
import Vista.FRM_Login;
import com.mysql.cj.xdevapi.PreparableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Rubén Delgado C
 */

//En esta clase se configuran todos los métodos relacionados al login.
public class RegistroLogin {
    
    public void validacionUsuario(JTextField usuario, JPasswordField contrasenna) {
        try {           
            ResultSet res = null;
            PreparedStatement pst = null;
            
            Modelo.Conexion conexion = new Modelo.Conexion();
            
            String consulta = "SELECT * FROM tb_usuarios WHERE tb_usuarios.usuario = (?) AND tb_usuarios.contrasenna = (?) And tb_usuarios.perfil = 'Administrador'";
            pst = conexion.establecerConexion().prepareStatement(consulta);
            
            String contrasena = String.valueOf(contrasenna.getPassword());
            
            pst.setString(1, usuario.getText());
            pst.setString(2, contrasena);
            
            //Ejecutar la consulta
            res = pst.executeQuery();
            
            
            if(res.next()) {
                String perfil = res.getString("perfil");
                
                if("Administrador".equalsIgnoreCase(perfil)) {
                    mostrarMensaje("Ha iniciado sesión corectamente. Bienvenido Administrador!");
                    new Controlador_Menu(); 
                }else{
                    mostrarMensaje("Ha iniciado sesión corectamente. Bienvenido Visitante!");
                }
            }else{
                mostrarMensaje("Usuario o contraseña incorrectos.");
                System.exit(0);
            }           
        } catch (Exception e) {
            mostrarMensaje("Ha ocurrido un error "+e.toString());
        }
    }//Fin Metodo validación usuario
    
    public void mostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje);
    }
}//Fin CLASS
