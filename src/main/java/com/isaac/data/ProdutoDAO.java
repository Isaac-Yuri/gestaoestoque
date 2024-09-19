package com.isaac.data;

import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.isaac.models.Produto;

public class ProdutoDAO extends DAO {

    public List<Produto> getAll() throws SQLException {
        List<Produto> produtos = new ArrayList<>();
        Connection conn = null;
        try {
            String query = "SELECT * FROM produtos";
            conn = DriverManager.getConnection(urlDatabase);

            if (conn != null) {
                System.out.println("Conexão bem sucedida!");
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet res = stmt.executeQuery();

                while (res.next()) {
                    Produto produto = new Produto();
                    produto.setNome(res.getString("nome"));
                    produto.setCategoria(res.getString("categoria"));
                    produto.setQuantidade(res.getInt("quantidade"));
                    produto.setPreco(res.getDouble("preco"));
                    produto.setCategoria(res.getString("categoria"));

                    produtos.add(produto);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro na Conexão");
            e.printStackTrace();
        } finally {
            conn.close();
            System.out.println("Conexão Encerrada!");
        }
        return produtos;
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
