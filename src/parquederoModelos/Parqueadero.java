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
    private int limited;
    private int tarifa;
    private int idParqueadero;
    private int celdasDisponibles;

    public Parqueadero() {
    }

    public int getLimited() {
        return limited;
    }

    public void setLimited(int limited) {
        this.limited = limited;
    }

    public int getTarifa() {
        return tarifa;
    }

    public void setTarifa(int tarifa) {
        this.tarifa = tarifa;
    }

    public int getidParqueadero() {
        return idParqueadero;
    }

    public void setidParqueadero(int idParqueadero) {
        this.idParqueadero = idParqueadero;
    }

    public int getCeldasDisponibles() {
        return celdasDisponibles;
    }

    public void setCeldasDisponibles(int celdasDisponibles) {
        this.celdasDisponibles = celdasDisponibles;
    }
    
}
