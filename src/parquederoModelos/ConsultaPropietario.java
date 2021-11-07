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
public class ConsultaPropietario extends ModeloInicio {

    PreparedStatement consultaBD;
    ResultSet resultadoBD;

    public boolean registrarPropietario(Propietarios propietario) {
        Connection conexion = conectarBD();
        String query = "INSERT INTO propietario (cedula,nombres,placa,telefonoF,telefonoM)"
                + "VALUES (?,?,?,?,?)";
        try {
            consultaBD = conexion.prepareStatement(query);

            consultaBD.setString(1, propietario.getCedula());
            consultaBD.setString(2, propietario.getNombres());
            consultaBD.setString(3, propietario.getPlaca());
            consultaBD.setString(4, propietario.getTelefonoF());
            consultaBD.setString(5, propietario.getTelefonoM());

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

    public Propietarios consultaPropietario(String cedula) {
        Connection conexion = conectarBD();
        String query = "SELECT * from propietarios where cedula = ?";
        try {
            consultaBD = conexion.prepareStatement(query);

            consultaBD.setString(1, cedula);

            resultadoBD = consultaBD.executeQuery();
            Propietarios propietario = new Propietarios();
            if (resultadoBD.next()) {
                propietario.setCedula(resultadoBD.getString("cedula"));
                propietario.setNombres(resultadoBD.getString("nombres"));
                propietario.setPlaca(resultadoBD.getString("placa"));
                propietario.setTelefonoF(resultadoBD.getString("telefonoF"));
                propietario.setTelefonoM(resultadoBD.getString("telefonoM"));
                return propietario;
            } else {
                return null;
            }
        } catch (Exception error) {
            System.out.println("epss" + error);
            return null;
        }

    }
}
