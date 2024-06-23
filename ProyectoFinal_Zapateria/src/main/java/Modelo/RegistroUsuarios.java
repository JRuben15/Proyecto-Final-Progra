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
    
    /*
    //Tabla
    public String[][] getMatrizUsuarios() {
        //DEfinimos la Matriz
        String[][] matrizUsuarios = new String[this.listaUsuarios.size()][Usuarios.TITULOS_USUARIOS.length];
        
        for(int f = 0; f < matrizUsuarios.length; f++) {
            matrizUsuarios[f][0] = listaUsuarios.get(f).getUsuario();
            matrizUsuarios[f][1] = listaUsuarios.get(f).getNombre();
            matrizUsuarios[f][2] = listaUsuarios.get(f).getContrasenna();
            matrizUsuarios[f][3] = listaUsuarios.get(f).getPerfil();
        }//Fin FOR f
        return matrizUsuarios;
    }//FIn Metodo getMatrizCanciones

*/
}//Fin CLASS
