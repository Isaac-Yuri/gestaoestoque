package com.isaac.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DatabaseUtilDAO {
    static Connection connection = null;

    public DatabaseUtilDAO() throws SQLException {
        getConnection();
    }

    public void getConnection() throws SQLException {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:database/estoque.db");
            if (connection != null) {
                System.out.println("Conexão bem-sucedida!");
                PreparedStatement stmt = connection.prepareStatement("SELECT * FROM produtos");
                ResultSet rs = stmt.executeQuery();

                System.out.println("==================================");
                while (rs.next()) {
                    String nome = rs.getString("nome");
                    int quantidade = rs.getInt("quantidade");
                    double preco = rs.getDouble("preco");
                    String categoria = rs.getString("categoria");

                    System.out.println("nome: "+nome);
                    System.out.println("categoria: "+categoria);
                    System.out.println("preço: "+ preco);
                    System.out.println("quantidade: "+quantidade);
                    System.out.println("============================");
                }
            } else {
                System.out.println("Não foi possível conectar ao banco de dados.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados.");
            e.printStackTrace();
        } finally {
            close();
            System.out.println("Conexão finalizada!");
        }
    }

    public static void close() throws SQLException {
        connection.close();
    }
}
