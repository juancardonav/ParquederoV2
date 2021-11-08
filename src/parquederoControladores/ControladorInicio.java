
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
import parquederoVistas.VistaCreacionCliente;
import parquederoVistas.VistaInicio;


public class ControladorInicio implements ActionListener{
    
    VistaInicio vistaInicio = new VistaInicio();
    Parqueadero parqueadero = new Parqueadero();
    Vehiculo vehiculo = new Vehiculo();
    Propietarios propietarios = new Propietarios();
    
    public ControladorInicio() {
    }
    
    

    public ControladorInicio(VistaInicio vistaInicio, Parqueadero parqueadero, Vehiculo vehiculo, Propietarios propietarios  ) {
        
        this.parqueadero = parqueadero;
        this.vehiculo = vehiculo;
        this.vistaInicio = vistaInicio;
        this.propietarios= propietarios;
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
        String placa=vistaInicio.Placa.getText();
        
        //Intento buscar el vehiculo por placa
        if(consultaVehiculo.buscarVehiculo(placa) != null){
            JOptionPane.showMessageDialog(null, "La placa existe");
             vistaInicio.setVisible(false);
        }else{
            VistaCreacionCliente vistaCreacionCliente = new VistaCreacionCliente();
            vistaCreacionCliente.setVisible(true);
            vistaInicio.setVisible(false);
            ControladorCreacionCliente controladorCreacionCliente =new ControladorCreacionCliente(parqueadero, propietarios, vehiculo ,vistaCreacionCliente);
        }  
       
    }

}
