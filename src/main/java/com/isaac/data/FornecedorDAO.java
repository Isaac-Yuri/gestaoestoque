package com.isaac.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.isaac.models.Fornecedor;

public class FornecedorDAO extends DAO {

    @Override
    public List<Fornecedor> getAll() throws SQLException {
        List<Fornecedor> fornecedores = new ArrayList<>();
        Connection conn = null;
        try {
            String query = "SELECT * FROM fornecedores";
            conn = DriverManager.getConnection(urlDatabase);

            if (conn != null) {
                System.out.println("Conexão bem sucedida!");
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet res = stmt.executeQuery();

                while (res.next()) {
                    Fornecedor fornecedor = new Fornecedor();
                    fornecedor.setNome(res.getString("nome"));
                    fornecedor.setEndereco(res.getString("endereco"));
                    fornecedor.setTelefone(res.getString("telefone"));

                    fornecedores.add(fornecedor);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro na Conexão");
            e.printStackTrace();
        } finally {
            conn.close();
            System.out.println("Conexão Encerrada!");
        }
        return fornecedores;
    }

    @Override
    public void add() throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public void update() throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete() throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
