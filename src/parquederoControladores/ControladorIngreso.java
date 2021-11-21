/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parquederoControladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import parquederoModelos.ConsultaPropietario;
import parquederoModelos.ConsultaVehiculo;
import parquederoModelos.Parqueadero;
import parquederoModelos.Propietarios;
import parquederoModelos.Vehiculo;
import parquederoVistas.Prueba;
import parquederoVistas.VistaIngreso;
import parquederoVistas.VistaInicio;

/**
 *
 * @author Usuario
 */
public class ControladorIngreso implements ActionListener{

    Parqueadero parqueadero = new Parqueadero();
    Vehiculo vehiculo = new Vehiculo();

    VistaIngreso vistaIngreso = new VistaIngreso();

    public ControladorIngreso(VistaIngreso vistaIngreso,  String placa) {
        System.out.println(placa);
        this.vistaIngreso = vistaIngreso;
         this.vehiculo = vehiculo;
         vistaIngreso.Placa.setText(placa);
        vistaIngreso.BotonIngresar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        ConsultaVehiculo consultaVehiculo = new ConsultaVehiculo();
        
        vehiculo.setPlaca(vistaIngreso.Placa.getText());
        
        Date entrada = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaEntrada=formato.format(entrada);
        vehiculo.setDateEntry(fechaEntrada);


        if (consultaVehiculo.actualizarEntrada(vehiculo)) {
            JOptionPane.showMessageDialog(null, "Ingreso exitoso");
            vistaIngreso.setVisible(false);
            VistaInicio vistaInicio = new VistaInicio();
            vistaInicio.setVisible(true);
            
            
            
        } else {
            JOptionPane.showMessageDialog(null, "Error en el ingreso");
        }
        
    }
    
    
    
}
