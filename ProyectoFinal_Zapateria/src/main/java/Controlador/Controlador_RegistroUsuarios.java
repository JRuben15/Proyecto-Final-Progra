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
               if (ventanaRegistroU.verificarId()) {
                   ventanaRegistroU.mensaje("Debe proporcionar el ID del usuario a modificar.");
                   return;
               }

               int idModificar = ventanaRegistroU.getIdUsuario();

               Usuarios usuarioExistenteModificar = usuarioController.findUsuarios(idModificar);
               if (usuarioExistenteModificar == null) {
                   ventanaRegistroU.mensaje("No se encontró el usuario a modificar.");
                   return;
               }

               if (ventanaRegistroU.verificar()) {
                   ventanaRegistroU.mensaje("No deben existir campos vacíos para poder modificar al usuario.");
                   return;
               }

               Usuarios usuarioModificar = ventanaRegistroU.getUsuario();

               usuarioExistenteModificar.setUsuario(usuarioModificar.getUsuario());
               usuarioExistenteModificar.setNombre(usuarioModificar.getNombre());
               usuarioExistenteModificar.setContrasenna(usuarioModificar.getContrasenna());
               usuarioExistenteModificar.setPerfil(usuarioModificar.getPerfil());

               try {
                   usuarioController.edit(usuarioExistenteModificar);
                   ventanaRegistroU.mensaje("Usuario modificado correctamente.");
                   ventanaRegistroU.limpiar();
               } catch (Exception ex) {
                   ventanaRegistroU.mensaje("Error al modificar el usuario: " + ex.getMessage());
               }
           break;
               
           case "Consultar":
               new Controlador_Consulta();
           break;
           
           case "Eliminar":
               if (ventanaRegistroU.verificarId()) {  
                   ventanaRegistroU.mensaje("Debe proporcionar el ID del usuario a eliminar.");  
                return;  
                }  
               
               int id = ventanaRegistroU.getIdUsuario();  
               Usuarios usuarioExistenteE = usuarioController.findUsuarios(id);  
               
                if (usuarioExistenteE == null) {  
                    ventanaRegistroU.mensaje("No se encontró el usuario a eliminar.");  
                } else {  
                    usuarioController.destroy(id);  
                    ventanaRegistroU.mensaje("Usuario eliminado correctamente.");  
                }  
                ventanaRegistroU.limpiar();
           break;
           
           case "Salir":
               ventanaRegistroU.dispose(); 
               new Controlador_Menu();
           break;
       }
    }  
    
}//Fin Class
