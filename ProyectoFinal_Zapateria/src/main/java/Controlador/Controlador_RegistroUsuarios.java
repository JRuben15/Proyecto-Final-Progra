/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

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
     private FRM_Consulta ventanaConsulta;

    public Controlador_RegistroUsuarios() {
        this.ventanaRegistroU = new FRM_RegistroUsuarios();
        this.panelBotones = new PanelBotones();
        this.usuarios = new Usuarios();
        this.usuarioController = new UsuariosJpaController();
        this.ventanaConsulta = new FRM_Consulta();
        //this.ventanaConsulta.escucharMouse(this);
        
        this.ventanaRegistroU.escuchadorGeneral(this);
        ventanaRegistroU.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       switch(e.getActionCommand()){
           case "Crear":
               //this.usuarios = ventanaRegistroU.getUsuario();
               ventanaRegistroU.mensaje(usuarioController.create(usuarios));
               ventanaRegistroU.limpiar();    
           break;
    
           case "Modificar":
              // this.usuarios = ventanaRegistroU.getUsuario();
               ventanaRegistroU.mensaje(usuarioController.edit(usuarios));
               ventanaRegistroU.limpiar();
           break;
           
           case "Consultar":
               //TABLA

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
    
    /*
    @Override
    public void mouseClicked(MouseEvent e) {
        this.ventanaRegistroU.setUsuario(new Usuarios(this.ventanaConsulta.getDataRow()[0],
                                                      this.ventanaConsulta.getDataRow()[1]),
                                                      this.ventanaConsulta.getDataRow()[2],
                                                      this.ventanaConsulta.getDataRow()[3]);
    }//Fin Metodo
*/
    
    
}//Fin Class
