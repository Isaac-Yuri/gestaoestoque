package com.isaac.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.isaac.models.Fornecedor;
import com.isaac.models.Produto;

public class ProdutoDAO implements DAO<Produto> {

    public List<Produto> getAll() throws SQLException {
        List<Produto> produtos = new ArrayList<>();
        String query = "SELECT * FROM produtos";
        
        try (Connection conn = DriverManager.getConnection(urlDatabase);
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet res = stmt.executeQuery()) {

            System.out.println("Conexão bem sucedida!");

            while (res.next()) {
                Produto produto = new Produto();
                produto.setNome(res.getString("nome"));
                produto.setCategoria(res.getString("categoria"));
                produto.setQuantidade(res.getInt("quantidade"));
                produto.setPreco(res.getDouble("preco"));

                FornecedorDAO fornecedorDAO = new FornecedorDAO();
                Fornecedor fornecedor = fornecedorDAO.getFornecedorById(res.getInt("id_fornecedor"));
                produto.setFornecedor(fornecedor);

                produtos.add(produto);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao obter todos os produtos!");
            e.printStackTrace();
        }
        return produtos;
    }

    public Produto getProdutoById(int id_produto) throws SQLException {
        Produto produto = new Produto();
        String query = "SELECT * FROM produtos WHERE id_produto = ?";
        
        try (Connection conn = DriverManager.getConnection(urlDatabase);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setQueryTimeout(30);
            stmt.setInt(1, id_produto);

            try (ResultSet res = stmt.executeQuery()) {
                if (res.next()) {
                    produto.setIdProduto(res.getInt("id_produto"));
                    produto.setNome(res.getString("nome"));
                    produto.setCategoria(res.getString("categoria"));
                    produto.setQuantidade(res.getInt("quantidade"));
                    produto.setPreco(res.getDouble("preco"));

                    FornecedorDAO fornecedorDAO = new FornecedorDAO();
                    Fornecedor fornecedor = fornecedorDAO.getFornecedorById(res.getInt("id_fornecedor"));
                    produto.setFornecedor(fornecedor);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao obter produto por id");
            e.printStackTrace();
        }
        return produto;
    }

    public void add(Produto produto) throws SQLException {
        String insert = "INSERT INTO produtos(nome, categoria, quantidade, preco, id_fornecedor) VALUES(?, ?, ?, ?, ?)";
        
        try (Connection con = DriverManager.getConnection(urlDatabase);
             PreparedStatement stmt = con.prepareStatement(insert)) {

            stmt.setQueryTimeout(30);
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getCategoria());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setDouble(4, produto.getPreco());
            stmt.setInt(5, produto.getFornecedor().getIdFornecedor());

            stmt.executeUpdate();
            System.out.println("Produto cadastrado com sucesso!");
        } catch (SQLException e) {
            System.out.println("ERRO AO CADASTRAR PRODUTO!");
            e.printStackTrace();
        }
    }

    public void update(Produto produto) throws SQLException {
        String update = "UPDATE produtos SET nome = ?, categoria = ?, quantidade = ?, preco = ?, id_fornecedor = ? WHERE id_produto = ?";
        
        try (Connection con = DriverManager.getConnection(urlDatabase);
             PreparedStatement stmt = con.prepareStatement(update)) {

            stmt.setQueryTimeout(30);
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getCategoria());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setDouble(4, produto.getPreco());
            stmt.setInt(5, produto.getFornecedor().getIdFornecedor());
            stmt.setInt(6, produto.getIdProduto());

            stmt.executeUpdate();
            System.out.println("Produto atualizado com sucesso!");
        } catch (SQLException e) {
            System.out.println("ERRO AO ATUALIZAR PRODUTO!");
            e.printStackTrace();
        }
    }

    public void delete(int idProduto) throws SQLException {
        String delete = "DELETE FROM produtos WHERE id_produto = ?";
        
        try (Connection con = DriverManager.getConnection(urlDatabase);
             PreparedStatement stmt = con.prepareStatement(delete)) {

            stmt.setQueryTimeout(30);
            stmt.setInt(1, idProduto);
            stmt.executeUpdate();
            System.out.println("Produto deletado com sucesso!");
        } catch (SQLException e) {
            System.out.println("ERRO AO DELETAR PRODUTO!");
            e.printStackTrace();
        }
    }
}
