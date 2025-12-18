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

public class ExcluirFuncionario {
    public static void main(String[] args) {
        
// Excluir o funcionairo por ID

         final String url = "jdbc:mysql://localhost:3306/funcionarios";
        // Usuário do banco
        final String usuario = "root";
        //Senha do banco
        final String senha = "root";
        // Scanner para entrada de dados
        Scanner entrada = new Scanner(System.in);
        //Solicitar o ID do funcionário
        System.out.println("Informe o ID do funcionário para excluir: ");
        int id = entrada.nextInt();
        entrada.nextLine(); //limpa o buffer
        
        String sql = 
                "DELETE FROM funcionarios WHERE id = ?";
          /*
         * try-with-resources:
         * Abre conexão e prepara o comando SQL
         */
        try (Connection conexao =
                     DriverManager.getConnection(url, usuario, senha);
             PreparedStatement stmt =
                     conexao.prepareStatement(sql)) {

            // Substitui o parâmetro da SQL
            stmt.setInt(1, id);

            // Executa o DELETE
            int linhasAfetadas = stmt.executeUpdate();

            // Verifica se algo foi removido
            if (linhasAfetadas > 0) {
                System.out.println("Funcionário excluído com sucesso!");
            } else {
                System.out.println("Funcionário não encontrado.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao excluir funcionário.");
            e.printStackTrace();
        } finally {
            entrada.close();
        }
    }
}
    
