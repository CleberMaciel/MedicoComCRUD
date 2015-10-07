/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicocombd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import model.Paciente;
import persistencia.Conexao;

/**
 *
 * @author 631420226
 */
public class MedicoComBD {

    public static void menu() throws SQLException {
        Scanner sc = new Scanner(System.in);
        int op = 0;

        System.out.println("1 - Cadastrar");
        System.out.println("2 - Listar todos Pacientes");
        System.out.println("3 - Remover Paciente");
        System.out.println("4 - Atualizar Paciente");
        System.out.print("Escolha uma opção: ");
        op = sc.nextInt();
        switch (op) {
            case 1:
                cadastrarPaciente();
                menu();
                break;
            case 2:
                listarTodos();
                menu();
                break;
            case 3:
                removerPaciente();
                menu();
                break;
            case 4:
                atualizarPaciente();
                menu();
                break;
            default:
                System.out.println("Digite uma tecla valida");
                break;
        }

    }

    public static void cadastrarPaciente() throws SQLException {
        Scanner sc = new Scanner(System.in);
        Conexao.getConexao();

        Paciente p = new Paciente();
        System.out.println("Informe  o nome do paciente: ");
        p.setNome(sc.next());
        System.out.println("Informe o RG: ");
        p.setRg(sc.nextInt());
        System.out.println("Informe data de Nascimento: ");
        p.setDataNascimento(sc.next());

        String sql = "INSERT INTO paciente(rg,nome,datanascimento) VALUES(?,?,?)";
        PreparedStatement inserir = Conexao.getConexao().prepareStatement(sql);
        inserir.setInt(1, p.getRg());
        inserir.setString(2, p.getNome());
        inserir.setString(3, p.getDataNascimento());

        int linhasAtualizadas = inserir.executeUpdate();
        if (linhasAtualizadas > 0) {
            System.out.println("Paciente Cadastrado");

        }

    }//fim do metodo cadastrar

    public static void listarTodos() throws SQLException {
        String sql = "SELECT * FROM PACIENTE";
        PreparedStatement listar = Conexao.getConexao().prepareStatement(sql);
        ResultSet resultado = listar.executeQuery();

        while (resultado.next()) {
            System.out.println("------------------------");
            System.out.println("Codigo: " + resultado.getInt("idpaciente"));
            System.out.println("Nome: " + resultado.getString("nome"));
            System.out.println("Data Nascimento: " + resultado.getString("datanascimento"));
            System.out.println("RG: " + resultado.getInt("rg"));
            System.out.println("------------------------");
        }
    }//fim do metodo listarTodos

    public static void removerPaciente() throws SQLException {
        Scanner sc = new Scanner(System.in);
        listarTodos();

        System.out.println("Deletar Paciente: Informe  o codigo:");
        int codigo = sc.nextInt();

        String sql = "DELETE FROM PACIENTE WHERE IDPACIENTE = " + codigo;
        PreparedStatement deletar = Conexao.getConexao().prepareStatement(sql);

        int resultado = deletar.executeUpdate();
        System.out.println("Paciente deletado" + resultado);

    }//fim do metodo removerPaciente

    public static void atualizarPaciente() throws SQLException {
        Scanner sc = new Scanner(System.in);
        listarTodos();
        System.out.println("Informe  o codigo do Paciente que deseja atualizar:");
        int codigo = sc.nextInt();

        Paciente p = new Paciente();
        System.out.println("Informe  o nome do paciente: ");
        p.setNome(sc.next());
        System.out.println("Informe o RG: ");
        p.setRg(sc.nextInt());
        System.out.println("Informe data de Nascimento: ");
        p.setDataNascimento(sc.next());

        String sql = "UPDATE PACIENTE SET RG = ?, NOME = ?, DATANASCIMENTO = ? WHERE IDPACIENTE =" + codigo;
        PreparedStatement atualizar = Conexao.getConexao().prepareStatement(sql);
        
        atualizar.setInt(1, p.getRg());
        atualizar.setString(2, p.getNome());
        atualizar.setString(3, p.getDataNascimento());
        
                
        atualizar.executeUpdate();
        System.out.println("Paciente Atualizado com sucesso");
    }

    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        menu();
    }

}
