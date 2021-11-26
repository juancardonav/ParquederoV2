package parquederoControladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import parquedero.Parquedero;
import parquederoModelos.ConsultaParqueadero;
import parquederoModelos.ConsultaVehiculo;
import parquederoModelos.Parqueadero;
import parquederoModelos.Propietarios;
import parquederoModelos.Vehiculo;
import parquederoVistas.Prueba;
import parquederoVistas.VistaCreacionCliente;
import parquederoVistas.VistaIngreso;
import parquederoVistas.VistaInicio;
import parquederoVistas.VistaLiquidarParqueadero;

public class ControladorInicio implements ActionListener {

    VistaInicio vistaInicio = new VistaInicio();
    Parqueadero parqueadero = new Parqueadero();
    Vehiculo vehiculo = new Vehiculo();
    Propietarios propietarios = new Propietarios();

    public ControladorInicio() {
    }

    public ControladorInicio(VistaInicio vistaInicio, Parqueadero parqueadero, Vehiculo vehiculo, Propietarios propietarios) {

        this.parqueadero = parqueadero;
        this.vehiculo = vehiculo;
        this.vistaInicio = vistaInicio;
        this.propietarios = propietarios;
        vistaInicio.BotonConsultar.addActionListener(this);
    }

    public ControladorInicio(VistaInicio vistaInicio, Parquedero parqueadero, Vehiculo vehiculo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Crear objeto de la clase consulta
        ConsultaVehiculo consultaVehiculo = new ConsultaVehiculo();

        //Obtener la placa de la vista
        String placa = vistaInicio.Placa.getText();

        //Intento buscar el vehiculo por placa
        if (consultaVehiculo.buscarVehiculo(placa) != null) {
            vistaInicio.setVisible(false);
            VistaLiquidarParqueadero vistaLiquidarParqueadero = new VistaLiquidarParqueadero();
            vistaLiquidarParqueadero.setVisible(true);
            ControladorLiquidar controladorLiquidar=new ControladorLiquidar(vistaLiquidarParqueadero, placa);
            System.out.println("1");
            vehiculo = consultaVehiculo.buscarVehiculo(vistaInicio.Placa.getText());
            String fechaEntrada = vehiculo.getDateEntry();
            
            if (fechaEntrada == null) {
                VistaIngreso vistaIngreso = new VistaIngreso();
                vistaInicio.setVisible(false);
                vistaLiquidarParqueadero.setVisible(false);
                vistaIngreso.setVisible(true);
                System.out.println("2");
                ControladorIngreso controladorIngreso = new ControladorIngreso(vistaIngreso, placa);
            }
        } else {
            System.out.println("3");
            Prueba vistaprueba = new Prueba();
            vistaInicio.setVisible(false);
            vistaprueba.setVisible(true);
            ControladorPrueba controladorPrueba = new ControladorPrueba(vistaprueba, placa);
        }

    }

}
