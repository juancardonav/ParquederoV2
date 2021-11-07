/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parquederoModelos;

/**
 *
 * @author sergio.bohorquez
 */
public class Parqueadero {
    private int limit;
    private int tarifa;
    private String placa;
    private int celdasDisponibles;

    public Parqueadero() {
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getTarifa() {
        return tarifa;
    }

    public void setTarifa(int tarifa) {
        this.tarifa = tarifa;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getCeldasDisponibles() {
        return celdasDisponibles;
    }

    public void setCeldasDisponibles(int celdasDisponibles) {
        this.celdasDisponibles = celdasDisponibles;
    }
    
}
