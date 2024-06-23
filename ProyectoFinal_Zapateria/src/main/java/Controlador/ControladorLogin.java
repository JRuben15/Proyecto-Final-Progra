/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.RegistroLogin;
import Modelo.Usuarios;
import Vista.FRM_Login;
import Vista.FRM_Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author
 */
public class ControladorLogin implements ActionListener {
    private FRM_Login ventanaLogin;
    private FRM_Menu ventanaMenu;
    private Usuarios usuarios;
    private UsuariosJpaController usuariosController;
    
    public ControladorLogin()
    {
        this.ventanaLogin = new FRM_Login();
        this.ventanaMenu = new FRM_Menu();
        this.usuarios = new Usuarios();
        this.usuariosController = new UsuariosJpaController();
        
        ventanaLogin.escuchador(this);
        ventanaLogin.setVisible(true);  
    }
     
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        switch(ae.getActionCommand().toString()) {
            case "Ingresar":
                ventanaLogin.login();
            break;
            
            case "Salir":
                ventanaLogin.mostrarMensaje("Saliendo...");
                System.exit(0);
            break;
            
            default:
                throw new AssertionError();
        }
    }
}//Fin CLASS
