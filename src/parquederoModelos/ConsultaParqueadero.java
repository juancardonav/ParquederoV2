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
public class ConsultaParqueadero extends ModeloInicio{
    PreparedStatement consultaBD;
    ResultSet resultadoBD;

    public boolean registrarparqueadero(Parqueadero parqueadero) {
        Connection conexion = conectarBD();
        String query = "INSERT INTO parqueadero (celdasDisponibles,limit,placa,tarifa)"
                + "VALUES (?,?,?,?)";
        try {
            consultaBD = conexion.prepareStatement(query);

            consultaBD.setInt(1, parqueadero.getCeldasDisponibles());
            consultaBD.setInt(2, parqueadero.getLimit());
            consultaBD.setString(3, parqueadero.getPlaca());
            consultaBD.setInt(4, parqueadero.getTarifa());

            int resultado = consultaBD.executeUpdate();
            
            if (resultado > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception error) {
            System.out.println("upsss." + error);
            return false;
        }

    }

    public Parqueadero consultaparqueadero(String placa) {
        Connection conexion = conectarBD();
        String query = "SELECT * from parqueadero where placa = ?";
        try {
            consultaBD = conexion.prepareStatement(query);

            consultaBD.setString(1, placa);

            resultadoBD = consultaBD.executeQuery();
            Parqueadero parqueadero = new Parqueadero();
            if (resultadoBD.next()) {
                parqueadero.setCeldasDisponibles(resultadoBD.getInt("celdasDisponibles"));
                parqueadero.setLimit(resultadoBD.getInt("limit"));
                parqueadero.setPlaca(resultadoBD.getString("placa"));
                parqueadero.setTarifa(resultadoBD.getInt("tarifa"));
                return parqueadero;
            } else {
                return null;
            }
        } catch (Exception error) {
            System.out.println("epss" + error);
            return null;
        }
    }
    
}
