package com.isaac;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.isaac.utils.DatabaseUtilDAO;

public class Main {
    public static void main(String[] args) throws SQLException {
        DatabaseUtilDAO databaseUtilDAO = new DatabaseUtilDAO();
        try {
            ResultSet res = databaseUtilDAO.executeQuery("SELECT * FROM  produtos");

            while (res.next()) {
                String nome = res.getString("nome");
                System.out.println(nome);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            databaseUtilDAO.close();
        }
    }
}
