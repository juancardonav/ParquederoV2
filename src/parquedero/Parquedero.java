/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parquedero;

import parquederoControladores.ControladorInicio;
import parquederoControladores.ControladorPrueba;
import parquederoModelos.Parqueadero;
import parquederoModelos.Propietarios;
import parquederoModelos.Vehiculo;
import parquederoVistas.Prueba;
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
        
    
    VistaInicio vistaInicio = new VistaInicio();
    vistaInicio.setVisible(true);
    Parqueadero parqueadero = new Parqueadero();
    Vehiculo vehiculo = new Vehiculo();
    Propietarios propietarios = new Propietarios();
    
    ControladorInicio controladorInicio = new ControladorInicio(vistaInicio,parqueadero,vehiculo,propietarios);

        
    }
    
}
