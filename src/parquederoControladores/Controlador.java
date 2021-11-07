/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parquederoControladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import parquederoModelos.ModeloInicio;
import parquederoVistas.VistaInicio;

/**
 *
 * @author Usuario
 */
public class Controlador implements ActionListener{
    
    ModeloInicio modeloIni = new ModeloInicio();
    VistaInicio vistaIni = new VistaInicio();
    
    
    public Controlador(ModeloInicio modeloIni, VistaInicio vistaIni) {
        this.modeloIni=modeloIni;
        this.vistaIni=vistaIni;
        vistaIni.BotonConsultar.addActionListener(this);
    }

    public Controlador() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        modeloIni.conectarBD();
    }
    
    
    
}
