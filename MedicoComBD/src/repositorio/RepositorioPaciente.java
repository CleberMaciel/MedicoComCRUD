/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import model.Paciente;

/**
 *
 * @author 631420226
 */
public class RepositorioPaciente {
    private static Paciente p = new Paciente();
    
    public static Paciente getPaciente(){
        return p;
    }
    
    public void cadastrarPaciente(Paciente p ){
    Paciente p1 = RepositorioPaciente.getPaciente();
    
    }
}
