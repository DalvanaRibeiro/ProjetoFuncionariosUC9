package Funcionarios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ============================================================
 *  CRIAÇÃO DE BANCO DE DADOS COM JDBC
 * ============================================================
 *
 * Esta classe tem como objetivo:
 *  Criar um banco de dados MySQL via Java (JDBC).
 *
 * É um exemplo didático para entender:
 * - Conexão JDBC
 * - Uso de Statement
 * - Execução de comandos SQL
 */
public class CriarBanco {

    public static void main(String[] args) {

        // URL mínima de conexão com o MySQL
        // Não informamos o banco, pois ele ainda NÃO EXISTE
        final String url = "jdbc:mysql://localhost:3306";

        // Usuário do banco
        final String usuario = "root";

        // Senha do banco
        final String senha = "admin";

        /*
         * try-with-resources:
         * - Abre a conexão com o banco
         * - Fecha automaticamente ao final do bloco
         */
        try (Connection conexao =
                     DriverManager.getConnection(url, usuario, senha);
             Statement stmt = conexao.createStatement()) {

            // Comando SQL para criar o banco de dados
            // IF NOT EXISTS evita erro caso o banco já exista
            String sql = "CREATE DATABASE IF NOT EXISTS funcionarios";

            // Executa o comando SQL
            stmt.execute(sql);

            // Mensagem de sucesso
            System.out.println("Banco de dados 'funcionarios' criado com sucesso!");

        } catch (SQLException e) {

            // Tratamento simples de erro para fins didáticos
            System.out.println("Erro ao criar o banco de dados.");
            e.printStackTrace();
        }
    }
}
