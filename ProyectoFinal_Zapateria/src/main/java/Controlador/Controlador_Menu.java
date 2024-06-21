/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.FRM_Menu;
import Vista.FRM_RegistroUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author
 */
public class Controlador_Menu implements ActionListener {
    private FRM_Menu ventanaMenu;
    private FRM_RegistroUsuarios ventanaRegistro;
    
    public Controlador_Menu() {
        this.ventanaMenu = new FRM_Menu();
        this.ventanaRegistro = new FRM_RegistroUsuarios();
        
        this.ventanaMenu.escuchadorMenu(this);
        ventanaMenu.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        switch(ae.getActionCommand()){
            case "Registro Usuarios":
                ventanaRegistro.setVisible(true);
            break;
          
            case "Salir":
                ventanaMenu.dispose();
            break;
        }
    }
}
