/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.FRM_Consulta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Rubén Delgado C
 */
public class Controlador_Consulta implements ActionListener {
    private FRM_Consulta ventanaConsulta;
    
    public Controlador_Consulta()
    {
        this.ventanaConsulta = new FRM_Consulta();
        ventanaConsulta.llenarTabla();
  
        ventanaConsulta.escuchador(this);
        ventanaConsulta.setLocationRelativeTo(null);
        ventanaConsulta.setVisible(true);
    }
     
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        switch(ae.getActionCommand().toString()) {
            case "Salir":
                ventanaConsulta.dispose();
            break;
            
            default:
                throw new AssertionError();
        }
    }
    
}//Fin CLASS
