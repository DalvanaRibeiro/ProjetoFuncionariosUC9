package Funcionarios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * ============================================================
 *  INSERÇÃO DE DADOS NO BANCO (JDBC DIRETO)
 * ============================================================
 *
 * Esta versão NÃO utiliza GerenciadorConexao.
 * Os dados de conexão ficam diretamente no código.
 *
 * Ideal para:
 * - Primeiros exemplos em aula
 * - Entender claramente o fluxo JDBC
 */
public class NovoFuncionario {

    public static void main(String[] args) {

        // Dados de conexão com o banco de dados
        final String url = "jdbc:mysql://localhost:3306/funcionarios";
        final String usuario = "root";
        final String senha = "admin";

        // Scanner para entrada de dados
        Scanner entrada = new Scanner(System.in);

        // Solicita o nome do funcionário
        System.out.print("Informe o nome do funcionário: ");
        String nome = entrada.nextLine();

        // Solicita o cargo do funcionário
        System.out.print("Informe o cargo do funcionário: ");
        String cargo = entrada.nextLine();

        /*
         * SQL parametrizado
         * O uso de ? evita SQL Injection
         */
        String sql =
                "INSERT INTO funcionarios (nome, cargo) VALUES (?, ?)";

        /*
         * try-with-resources:
         * - Abre a conexão
         * - Prepara o comando SQL
         * - Fecha automaticamente
         */
        try (Connection conexao =
                     DriverManager.getConnection(url, usuario, senha);
             PreparedStatement stmt =
                     conexao.prepareStatement(sql)) {

            // Substitui os parâmetros da SQL
            stmt.setString(1, nome);
            stmt.setString(2, cargo);

            // Executa o INSERT
            stmt.executeUpdate();

            // Confirmação no console
            System.out.println("Funcionário incluído com sucesso!");

        } catch (SQLException e) {

            // Tratamento simples de erro para fins didáticos
            System.out.println("Erro ao incluir funcionário.");
            e.printStackTrace();

        } finally {
            // Fecha o Scanner
            entrada.close();
        }
    }
}
