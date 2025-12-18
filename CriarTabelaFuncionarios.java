package Funcionarios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ============================================================
 * CRIAÇÃO DA TABELA FUNCIONARIOS (JDBC DIRETO)
 * ============================================================
 *
 * Esta versão NÃO utiliza classe gerenciadora de conexão.
 * Todos os dados de conexão ficam diretamente no código.
 *
 * Ideal para:
 * - Primeiros exemplos em aula
 * - Entender o funcionamento do JDBC
 */
public class CriarTabelaFuncionarios {

    public static void main(String[] args) {

        // Dados de conexão com o banco de dados
        final String url = "jdbc:mysql://localhost:3306/funcionarios";
        final String usuario = "root";
        final String senha = "admin";

        /*
         * try-with-resources:
         * - Abre a conexão
         * - Cria o Statement
         * - Fecha tudo automaticamente
         */
        try (Connection conexao =
                     DriverManager.getConnection(url, usuario, senha);
             Statement stmt = conexao.createStatement()) {

            // Comando SQL para criar a tabela de funcionários
            String sql =
                    "CREATE TABLE IF NOT EXISTS funcionarios ("
                  + "id INT AUTO_INCREMENT PRIMARY KEY, "
                  + "nome VARCHAR(80) NOT NULL, "
                  + "cargo VARCHAR(50) NOT NULL"
                  + ")";

            // Executa o comando SQL
            stmt.execute(sql);

            // Confirmação no console
            System.out.println("Tabela 'funcionarios' criada com sucesso!");

        } catch (SQLException e) {

            // Tratamento simples de erro para fins didáticos
            System.out.println("Erro ao criar a tabela 'funcionarios'.");
            e.printStackTrace();
        }
    }
}
