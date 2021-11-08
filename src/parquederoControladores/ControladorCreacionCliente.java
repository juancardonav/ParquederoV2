
package parquederoControladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import parquederoModelos.ConsultaParqueadero;
import parquederoModelos.ConsultaPropietario;
import parquederoModelos.ConsultaVehiculo;
import parquederoModelos.Parqueadero;
import parquederoModelos.Propietarios;
import parquederoModelos.Vehiculo;
import parquederoVistas.VistaCreacionCliente;


public class ControladorCreacionCliente implements ActionListener{
    
    Parqueadero parqueadero = new Parqueadero();
    Propietarios propietarios = new Propietarios();
    Vehiculo vehiculo = new Vehiculo();
    VistaCreacionCliente vistaCreacionCliente = new VistaCreacionCliente();

    public ControladorCreacionCliente() {
    }
    

    public ControladorCreacionCliente( Parqueadero parqueadero, Propietarios propietarios, Vehiculo vehiculo, VistaCreacionCliente vistaCreacionCliente ) {
        this.parqueadero = parqueadero;
        this.propietarios = propietarios;
        this.vehiculo = vehiculo;
        
        vistaCreacionCliente.BotonCrear.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        
         //Trae la consulta de la escuderia

          ConsultaParqueadero consultaParqueadero = new ConsultaParqueadero();
          ConsultaPropietario consultaPropietario = new ConsultaPropietario();
          ConsultaVehiculo consultaVehiculo = new ConsultaVehiculo();
          
       //armar un PROPIETARIO para grabar
       
       propietarios.setCedula(vistaCreacionCliente.IdPropietario.getText());
       propietarios.setPlaca(vistaCreacionCliente.Placa.getText());
       propietarios.setNombres(vistaCreacionCliente.Nombre.getText());
       propietarios.setTelefonoF(vistaCreacionCliente.Telefono.getText());
       propietarios.setTelefonoM(vistaCreacionCliente.Celular.getText());
       
          //Intentar Registrar EL VEHICULO
          
          vehiculo.setPlaca(vistaCreacionCliente.Placa.getText());
          vehiculo.setIdPropietario(vistaCreacionCliente.IdPropietario.getText());
        
          if(consultaPropietario.registrarPropietario(propietarios) && consultaVehiculo.registrarVehiculo(vehiculo)){
           JOptionPane.showMessageDialog(null, "Registro Exitoso");
          }else{
          JOptionPane.showMessageDialog(null, "Ups...Intente nuevamente");
          }

    }
    
    
}
