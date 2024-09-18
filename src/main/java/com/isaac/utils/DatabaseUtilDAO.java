package com.isaac.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DatabaseUtilDAO {
    static Connection connection = null;

    private boolean getConnection() throws SQLException {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:database/estoque.db");
            if (connection != null) {
                System.out.println("Conexão bem-sucedida!");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados.");
            e.printStackTrace();
        }
        return false;
    }

    public ResultSet executeQuery(String query) throws SQLException {
        try {
            if(getConnection()) {
                PreparedStatement stmt = connection.prepareStatement(query);
                return stmt.executeQuery();
            }
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados.");
            e.printStackTrace();
        }
        return null;
    }

    public void close() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
            System.out.println("Conexão Encerrada");
        }
    }
}
