/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parquederoModelos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Vehiculo {    
    private String placa;
    private String idPropietario;
    private String dateEntry;
    private String dateOut;

    
    //ModeloInicio inicio = new ModeloInicio();
    public Vehiculo() {
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(String idPropietario) {
        this.idPropietario = idPropietario;
    }

    public String getDateEntry() {
        return dateEntry;
    }

    public void setDateEntry(String dateEntry) {
        this.dateEntry = dateEntry;
    }

    public String getDateOut() {
        return dateOut;
    }

    public void setDateOut(String dateOut) {
        this.dateOut = dateOut;
    }


 
    

}
    
 
