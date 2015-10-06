/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import model.Paciente;
import persistencia.Conexao;

/**
 *
 * @author 631420226
 */
public class PacienteUI {
    //metodos de adicionar excluir paciente

    public void cadastrarPaciente(Paciente p) throws SQLException {
        Connection conexao = Conexao.getConexao();
        Statement s = conexao.createStatement();
        try {
            String sql;

            sql = "insert into paciente(codigo,rg,nome,datanascimento)" + "values (null," + p.getRg() + ",'" + p.getNome() + "','" + p.getDataNascimento() + "')";
            s.execute(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao cadastrar");
        } finally {
            conexao.close();
            s.close();  
        }
    }
}
