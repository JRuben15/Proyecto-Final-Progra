/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

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
    
    //Tabla
    public String[][] getMatrizCanciones() {
        //DEfinimos la Matriz
        String[][] matrizCanciones = new String[this.listaUsuarios.size()][Usuarios.TITULOS_USUARIOS.length];
        
        for(int f = 0; f < matrizCanciones.length; f++) {
            matrizCanciones[f][0] = listaUsuarios.get(f).getUsuario();
            matrizCanciones[f][1] = listaUsuarios.get(f).getNombre();
            matrizCanciones[f][2] = listaUsuarios.get(f).getContrasenna();
            matrizCanciones[f][3] = listaUsuarios.get(f).getPerfil();
        }//Fin FOR f
        return matrizCanciones;
    }//FIn Metodo getMatrizCanciones
}//Fin CLASS
