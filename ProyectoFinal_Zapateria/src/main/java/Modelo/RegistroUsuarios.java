/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Modelo.Usuarios;
import java.util.ArrayList;

/**
 *
 * @author Rubén Delgado C
 */
public class RegistroUsuarios {
    ArrayList<Usuarios> listaUsuarios;

    public RegistroUsuarios() {
        this.listaUsuarios = new ArrayList<>();
    }
    
     public String[] getComboUsuarios(){
        String[] usuarios = new String[this.listaUsuarios.size()];
        for (int i = 0; i < this.listaUsuarios.size(); i++) {
            usuarios[i] = this.listaUsuarios.get(i).getUsuario();
        }
        return usuarios;
    }
    
    
}//Fin CLASS
