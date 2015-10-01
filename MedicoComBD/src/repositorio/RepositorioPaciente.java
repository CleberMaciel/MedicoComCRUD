/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import persistencia.Conexao;

/**
 *
 * @author 631420226
 */
public class RepositorioPaciente {
    //metodos de adicionar excluir paciente

    public void cadastrarPaciente() throws SQLException{
       Connection conexao = Conexao.getConexao(); 
       Statement s = conexao.createStatement();
       
       
        
        
    }
}
