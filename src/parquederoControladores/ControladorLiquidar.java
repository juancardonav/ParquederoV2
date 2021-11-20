/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parquederoControladores;

import parquederoVistas.VistaInicio;
import parquederoVistas.VistaLiquidarParqueadero;

/**
 *
 * @author 505
 */
public class ControladorLiquidar {
    
    
    VistaInicio vistaInicio=new VistaInicio();
    //Obtener la placa de la vista
    String placa=vistaInicio.Placa.getText();
    
    VistaLiquidarParqueadero vistaLiquidarParqueadero = new VistaLiquidarParqueadero();
    
    
   
    
    
}
