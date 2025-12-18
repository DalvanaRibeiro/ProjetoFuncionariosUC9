/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funcionarios;

/**
 *
 * @author Dalvana
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ============================================================
 *  EXEMPLO BÁSICO DE CONEXÃO COM JDBC
 * ============================================================
 *
 * Objetivo:
 * Testar se o Java consegue se conectar ao MySQL.
 *
 * Versão:
 * Simples, direta e ideal para iniciantes.
 */
public class Conexao {

    public static void main(String[] args) {

        // URL mínima de conexão com o MySQL
        // localhost → banco local
        // 3306 → porta padrão
        // meu_banco → nome do banco de dados
        final String url = "jdbc:mysql://localhost:3306/funcionarios";

        // Usuário do banco
        final String usuario = "root";

        // Senha do banco
        final String senha = "admin";

        try {
            // Abre a conexão com o banco
            Connection conexao =
                    DriverManager.getConnection(url, usuario, senha);

            // Se chegou aqui, conectou com sucesso
            System.out.println("Conexão efetuada com sucesso!");

            // Fecha a conexão
            conexao.close();

        } catch (SQLException e) {
            // Tratamento de erro simples e didático
            System.out.println("Erro ao conectar ao banco de dados.");
            e.printStackTrace();
        }
    }
}
