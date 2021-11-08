/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parquederoModelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author sergio.bohorquez
 */
public class ConsultaVehiculo extends ModeloInicio{
    
    PreparedStatement consultaBD;
    ResultSet resultadoBD;
    
    public boolean registrarVehiculo(Vehiculo vehiculo){
        Connection conexion = conectarBD();
        String query = "INSERT INTO vehiculos (fechaEntrada,fechaSalida,horaEntrada,horaSalida,idPropietario,placa)"
                        + "VALUES (?,?,?,?,?,?)";
        try{
            consultaBD=conexion.prepareStatement(query);
            
            consultaBD.setString(1,vehiculo.getFechaEntrada());
            consultaBD.setString(2,vehiculo.getFechaSalida());
            consultaBD.setString(3,vehiculo.getHoraEntrada());
            consultaBD.setString(4,vehiculo.getHoraSalida());
            consultaBD.setString(5,vehiculo.getIdPropietario());
            consultaBD.setString(6,vehiculo.getPlaca());
            
            int resultado = consultaBD.executeUpdate();
            
            if(resultado>0){
                return true; 
            }else{
                return false;
            }
        }catch(Exception error){
            System.out.println("upsss."+error);
            return false;
        }
          
    }
    
    public Vehiculo buscarVehiculo(String placa){
       
        Connection conexion=conectarBD();
        String query="SELECT * from vehiculos where placa=?";
        
        try{
            
            //Peparate que voy con toa
            consultaBD=conexion.prepareStatement(query);
            
            //Ajusto la consulta
            consultaBD.setString(1, placa);
         
            //Ejecuto la consulta
            resultadoBD=consultaBD.executeQuery();
            
            //Orgaizo el resultado
            Vehiculo vehiculo = new Vehiculo();
            if(resultadoBD.next()){
                
                vehiculo.setPlaca(resultadoBD.getString(placa));
                vehiculo.setFechaEntrada(resultadoBD.getString("FechaEntrada"));
                vehiculo.setHoraEntrada(resultadoBD.getString("HoraEntrada"));
                vehiculo.setFechaSalida(resultadoBD.getString("FechaSalida"));
                vehiculo.setHoraSalida(resultadoBD.getString("HoraSalida"));

                
                return vehiculo;
                
            }else{
                return null;
            }

        }catch(Exception error){
            System.out.println("upsss... "+error);
            return null;
        }
        
       
   } 
}
