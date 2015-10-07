/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 631420226
 */
public class Conexao {
   private static String URL ="jdbc:postgresql://localhost:5432/consultoriomedico";
   private static String USER ="postgres";
   private static String PASS ="senac2015";
   
   public static Connection getConexao(){
       Connection c = null;
       try {
           c = DriverManager.getConnection(URL, USER, PASS);
           System.out.println("Conectado");
       } catch (SQLException e) {
           System.out.println("Erro ao conectar");
       }
       return c;
   }
}
