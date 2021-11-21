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
public class ConsultaVehiculo extends ModeloInicio {

    PreparedStatement consultaBD;
    ResultSet resultadoBD;

    public boolean registrarVehiculo(Vehiculo vehiculo) {
        Connection conexion = conectarBD();
        String query = "INSERT INTO vehiculos (placa,idPropietario,dateEntry,dateOut)"
                + "VALUES (?,?,?,?)";
        try {
            consultaBD = conexion.prepareStatement(query);
            consultaBD.setString(1, vehiculo.getPlaca());
            consultaBD.setString(2, vehiculo.getIdPropietario());
            consultaBD.setString(3, vehiculo.getDateEntry());
            consultaBD.setString(4, vehiculo.getDateOut());

            int resultado = consultaBD.executeUpdate();

            if (resultado > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception error) {
            System.out.println("Error en el registro del vehiculo:" + error);
            return false;
        }

    }

    public Vehiculo buscarVehiculo(String placa) {

        Connection conexion = conectarBD();
        String query = "SELECT * from vehiculos where placa=?";

        try {

            //Peparate que voy con toa
            consultaBD = conexion.prepareStatement(query);

            //Ajusto la consulta
            consultaBD.setString(1, placa);

            //Ejecuto la consulta
            resultadoBD = consultaBD.executeQuery();

            //Orgaizo el resultado
            Vehiculo vehiculo = new Vehiculo();
            if (resultadoBD.next()) {
                vehiculo.setPlaca(resultadoBD.getString("placa"));
                vehiculo.setIdPropietario(resultadoBD.getString("idPropietario"));
                vehiculo.setDateEntry(resultadoBD.getString("dateEntry"));
                vehiculo.setDateOut(resultadoBD.getString("dateOut"));

                return vehiculo;

            } else {
                return null;
            }

        } catch (Exception error) {
            System.out.println("upsss... " + error);
            return null;
        }

    }

    public boolean actualizar(Vehiculo vehiculo) {
        Connection conexion = conectarBD();
        String query = "UPDATE vehiculos SET dateOut=? WHERE placa=?";

        try {

            //Peparate que voy con toa
            consultaBD = conexion.prepareStatement(query);

            //Ajusto la consulta
            consultaBD.setString(1, vehiculo.getDateOut());
            consultaBD.setString(2, vehiculo.getPlaca());

            //Ejecuto la consulta
            int resultado = consultaBD.executeUpdate();

            //Orgaizo el resultado
            if (resultado > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception error) {
            System.out.println("Error al actualizar el registro:" + error);
            return false;
        }

    }
    
    public boolean actualizarEntrada(Vehiculo vehiculo) {
        Connection conexion = conectarBD();
        String query = "UPDATE vehiculos SET dateEntry=? WHERE placa=?";

        try {

            //Peparate que voy con toa
            consultaBD = conexion.prepareStatement(query);

            //Ajusto la consulta
            consultaBD.setString(1, vehiculo.getDateEntry());
            consultaBD.setString(2, vehiculo.getPlaca());

            //Ejecuto la consulta
            int resultado = consultaBD.executeUpdate();

            //Orgaizo el resultado
            if (resultado > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception error) {
            System.out.println("Error al actualizar el registro:" + error);
            return false;
        }

    }

}
