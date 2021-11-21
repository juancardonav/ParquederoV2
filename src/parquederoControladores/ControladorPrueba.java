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
import parquederoVistas.VistaInicio;

public class ControladorPrueba implements ActionListener {
    
    Parqueadero parqueadero = new Parqueadero();
    Propietarios propietarios = new Propietarios();
    Vehiculo vehiculo = new Vehiculo();
    Prueba vistaPrueba = new Prueba();

    public ControladorPrueba(Prueba prueba) {
        
        this.vistaPrueba=prueba;
        prueba.botonRegistrar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        ConsultaPropietario consultaPropietario = new ConsultaPropietario();
        ConsultaVehiculo consultaVehiculo = new ConsultaVehiculo();
       
        /*System.out.println("hici clic");*/
        System.out.println("texto: "+vistaPrueba.cajaplaca.getText());
        System.out.println("texto: "+vistaPrueba.cajacedula.getText());
        System.out.println("texto: "+vistaPrueba.cajatelefono.getText());
        System.out.println("texto: "+vistaPrueba.cajanombre.getText());
        
        propietarios.setCedula(vistaPrueba.cajacedula.getText());
        propietarios.setNombres(vistaPrueba.cajanombre.getText());
        propietarios.setTelefonoF(vistaPrueba.cajatelefono.getText());
        
        //REGISTRO VEHICULO
        vehiculo.setPlaca(vistaPrueba.cajaplaca.getText());
        vehiculo.setIdPropietario(vistaPrueba.cajacedula.getText());
        
        Date entrada = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaEntrada=formato.format(entrada);
        vehiculo.setDateEntry(fechaEntrada);
        
        
        
        
        if (consultaPropietario.registrarPropietario(propietarios) && consultaVehiculo.registrarVehiculo(vehiculo)) {
            JOptionPane.showMessageDialog(null, "Registro Exitoso");
            
            vistaPrueba.setVisible(false); 
            VistaInicio vistaInicio = new VistaInicio();
            vistaInicio.setVisible(true);
            
        } else {
            JOptionPane.showMessageDialog(null, "Error en el registro");
        }
        
          
    }
    
    
    
}
