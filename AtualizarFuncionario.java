/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funcionarios;

/**
 *
 * @author Professor
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement; 
import java.util.Scanner;
import java.sql.PreparedStatement;

public class AtualizarFuncionario {

// Atualizar o nome e o cargo de um funcionário com base no ID
public static void main(String[] args) {
         final String url = "jdbc:mysql://localhost:3306/funcionarios";
        // Usuário do banco
        final String usuario = "root";
        //Senha do banco
        final String senha = "root";
        // Scanner para entrada de dados
        Scanner entrada = new Scanner(System.in);
        //Solicitar o ID do funcionário
        System.out.println("Informe o ID do funcionário: ");
        int id = entrada.nextInt();
        entrada.nextLine(); //limpa o buffer
        
        // Solicita o novo nome
        System.out.println("Informe o novo nome: ");
        String nome = entrada.nextLine();
        
        // Solicita o novo cargo
        System.out.println(" Informe o novo cargo: ");
        String cargo = entrada.nextLine();
        /*
        SQL parametrizado
        Atualiza o nome e cargo com base no ID
        */
        String sql = 
                "UPDATE funcionarios SET nome = ? , cargo = ? WHERE id = ?";
        /*
        try abre a conexao e prepara o comando SQL*/
        
        try(Connection conexao = 
                DriverManager.getConnection(url, usuario, senha);
                PreparedStatement stmt = 
                        conexao.prepareStatement(sql)){
            stmt.setString(1, nome);
            stmt.setString(2, cargo);
            stmt.setInt(3, id);
            // executa o UPDATE
            int linhasAfetadas = stmt.executeUpdate();
            // Verifica se algo foi alterado
            if( linhasAfetadas > 0){
                System.out.println("Funcionário atualizado com sucesso!");
            }else{
                System.out.println("  Funcionário não encontrado.");
            }
        }catch(SQLException e){
            System.out.println("Erro ao atualizar funcionário");
               
        }finally{
            entrada.close();
        }
    }
    
}
