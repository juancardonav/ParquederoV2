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
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import parquederoModelos.ConsultaPropietario;
import parquederoModelos.ConsultaVehiculo;
import parquederoModelos.Propietarios;
import parquederoModelos.Vehiculo;
import parquederoVistas.VistaInicio;
import parquederoVistas.VistaLiquidarParqueadero;

public class ControladorLiquidar implements ActionListener {

    VistaLiquidarParqueadero vistaLiquidarParqueadero = new VistaLiquidarParqueadero();
    Vehiculo vehiculo = new Vehiculo();
    Propietarios propietarios = new Propietarios();

    public ControladorLiquidar(VistaLiquidarParqueadero vistaLiquidarParqueadero, String placa) {
        this.vistaLiquidarParqueadero = vistaLiquidarParqueadero;
        System.out.println(placa);
        vistaLiquidarParqueadero.BotonLiquidar.addActionListener(this);
        vistaLiquidarParqueadero.Placa.setText(placa);

        this.propietarios = propietarios;
        this.vehiculo = vehiculo;

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        //traemos las consultas
        ConsultaVehiculo consultaVehiculo = new ConsultaVehiculo();
        ConsultaPropietario consultaPropietario = new ConsultaPropietario();

        //Obtener fecha salida
        vehiculo = consultaVehiculo.buscarVehiculo(vistaLiquidarParqueadero.Placa.getText());
        String fechaEntrada = vehiculo.getDateEntry();
        String placa = vehiculo.getPlaca();
        try {
            Date entrada = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(fechaEntrada);

            Date salida = new Date();
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String fechaSalida = formato.format(salida);

            long tiempoDiferencia = salida.getTime() - entrada.getTime();
            TimeUnit unidadTiempo = TimeUnit.MINUTES;
            long tiempoParqueadero = unidadTiempo.convert(tiempoDiferencia, TimeUnit.MILLISECONDS);

            long valorPagar = tiempoParqueadero * 100;

            vehiculo.setDateOut(fechaSalida);

            if (consultaVehiculo.actualizar(vehiculo)) {
                JOptionPane.showMessageDialog(null, "Propietarie del vehiculo: " + placa + "\n" + "\nFecha Entrada: " + fechaEntrada + "\n"
                        + "\nFecha Salida: " + fechaSalida + "\n"
                        + "\nSu tiempo en el parqueadero es: " + tiempoParqueadero + " minutos" + "\n"
                        + "\nY el valor a pagar es:  " + "$" + valorPagar + "\n" + "  " + "\n");
                
                
                vistaLiquidarParqueadero.setVisible(false);
                VistaInicio vistaInicio = new VistaInicio();
                vistaInicio.setVisible(true);
                
                /*System.exit(0);*/

            } else {
                JOptionPane.showMessageDialog(null, "Error en la salida");
            }
            
            //Enviar null a la fecha de salida
            vehiculo.setDateOut(null);
            consultaVehiculo.actualizar(vehiculo);
            
            vehiculo.setDateEntry(null);
            consultaVehiculo.actualizarEntrada(vehiculo);


        } catch (Exception e) {

            System.out.println("upss" + e);

        }

    }

}
