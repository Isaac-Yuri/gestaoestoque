package com.isaac;

import java.sql.SQLException;

import com.isaac.utils.DatabaseUtilDAO;

public class Main {
    public static void main(String[] args) throws SQLException {
        DatabaseUtilDAO databaseUtilDAO = new DatabaseUtilDAO();
        try {
            databaseUtilDAO.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
