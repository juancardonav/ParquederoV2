/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parquedero;

import parquederoControladores.Controlador;
import parquederoModelos.ModeloInicio;
import parquederoVistas.VistaInicio;

/**
 *
 * @author Usuario
 */
public class Parquedero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    ModeloInicio modeloIni = new ModeloInicio();
    VistaInicio vistaIni = new VistaInicio();
    vistaIni.setVisible(true);
    Controlador controlador = new Controlador(modeloIni, vistaIni);
        
    }
    
}
