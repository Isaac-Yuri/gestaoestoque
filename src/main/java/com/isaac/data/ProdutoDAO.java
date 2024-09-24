package com.isaac.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.isaac.models.Produto;

public class ProdutoDAO implements DAO<Produto> {

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
        } finally {
            conn.close();
            System.out.println("Conexão Encerrada!");
        }
        return produtos;
    }

    public void add(Produto produto) throws SQLException {
        Connection con = null;
        try {
            con = DriverManager.getConnection(urlDatabase);
            String insert = "INSERT INTO produto(nome, categoria, quantidade, preco, id_fornecedor) VALUES(?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(insert);
            stmt.setQueryTimeout(30);
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getCategoria());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setDouble(4, produto.getPreco());
            stmt.setInt(5, produto.getFornecedor().getIdFornecedor());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERRO AO CADASTRAR PRODUTO!");
            e.printStackTrace();
        } finally {
            con.close();
        }
    }

    public void update(Produto produto) throws SQLException {
        Connection con = null;
        try {
            con = DriverManager.getConnection(urlDatabase);
            String update = "UPDATE produtos SET nome = ?, categoria = ?, quantidade = ?, preco = ?, id_fornecedor = ? WHERE id_produto = ?";
            PreparedStatement stmt = con.prepareStatement(update);
            stmt.setQueryTimeout(30);
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getCategoria());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setDouble(4, produto.getPreco());
            stmt.setInt(5, produto.getFornecedor().getIdFornecedor());
            stmt.setInt(6, produto.getIdProduto());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERRO AO ATUALIZAR PRODUTOS!");
            e.printStackTrace();
        } finally {
            con.close();
        }
    }

    public void delete(int idProduto) throws SQLException {
        Connection con = null;
        try{
            con = DriverManager.getConnection(urlDatabase);
            String delete = "DELETE FROM produtos WHERE id_produto = ?";
            PreparedStatement stmt = con.prepareStatement(delete);
            stmt.setQueryTimeout(30);
            stmt.setInt(0, idProduto);
            stmt.executeUpdate();
        } catch(SQLException e){
            System.out.println("ERRO AO DELETAR O PRODUTO!");
            e.printStackTrace();
        } finally{
            con.close();
        }    
    }
}
