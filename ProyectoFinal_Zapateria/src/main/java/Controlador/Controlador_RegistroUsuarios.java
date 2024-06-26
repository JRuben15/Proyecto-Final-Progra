/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.RegistroUsuarios;
import Modelo.Usuarios;
import Vista.FRM_Consulta;
import Vista.FRM_RegistroUsuarios;
import Vista.PanelBotones;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author
 */
public class Controlador_RegistroUsuarios implements ActionListener { //, MouseListener {
     private FRM_RegistroUsuarios ventanaRegistroU;
     private PanelBotones panelBotones;
     private Usuarios usuarios;
     private UsuariosJpaController usuarioController;
     
     private RegistroUsuarios registroU;
     

    public Controlador_RegistroUsuarios() {
        this.ventanaRegistroU = new FRM_RegistroUsuarios();
        this.panelBotones = new PanelBotones();
        this.usuarios = new Usuarios();
        this.registroU = new RegistroUsuarios();
        
        this.usuarioController = new UsuariosJpaController();
        
        this.ventanaRegistroU.escuchadorGeneral(this);
        ventanaRegistroU.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       switch(e.getActionCommand()){
           case "Crear":
               if(ventanaRegistroU.verificar() == true) {
                   ventanaRegistroU.mensaje("No deben existir campos vacios.");
               }else{
                   this.usuarios = ventanaRegistroU.getUsuario();
                   ventanaRegistroU.mensaje(usuarioController.create(usuarios));
                   ventanaRegistroU.limpiar(); 
               }
           break;
    
           case "Modificar":
               if(ventanaRegistroU.verificar() == true) {
                   ventanaRegistroU.mensaje("No deben existir campos vacios."); 
               }else{
                   this.usuarios = ventanaRegistroU.getUsuario();
                   ventanaRegistroU.cargarCombo(this.registroU.getComboUsuarios());
                   ventanaRegistroU.mensaje(usuarioController.edit(usuarios));
                   ventanaRegistroU.limpiar();   
               }   
           break;
           
           case "Consultar":
               new Controlador_Consulta();
           break;
           
           case "Eliminar":
               //TABLA
               
           break;
           
           case "Salir":
               ventanaRegistroU.dispose(); 
               new Controlador_Menu();
           break;
       }
    }  
    
}//Fin Class
