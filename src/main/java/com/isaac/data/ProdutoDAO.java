package com.isaac.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.sqlite.SQLiteException;

import com.isaac.models.Fornecedor;
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
                    Fornecedor fornecedor = new Fornecedor();
                    FornecedorDAO fornecedorDAO = new FornecedorDAO();
                    fornecedor = fornecedorDAO.getFornecedorById(res.getInt("id_fornecedor"));
                    produto.setFornecedor(fornecedor);

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

    public Produto getProdutoById(int id_produto) throws SQLException {
        Connection conn = null;
        Produto produto = new Produto();
        try {
            String query = "SELECT * FROM produtos WHERE id_produto = ?";
            conn = DriverManager.getConnection(urlDatabase);
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setQueryTimeout(30);
            stmt.setInt(1, id_produto);
            ResultSet res = stmt.executeQuery();

            while(res.next()) {
                produto.setIdProduto(res.getInt("id_produto"));
                produto.setNome(res.getString("nome"));
                produto.setCategoria(res.getString("categoria"));
                produto.setQuantidade(res.getInt("quantidade"));
                produto.setPreco(res.getDouble("preco"));
                FornecedorDAO fornecedorDAO = new FornecedorDAO();
                Fornecedor fornecedor = fornecedorDAO.getFornecedorById(res.getInt("id_fornecedor"));
                produto.setFornecedor(fornecedor);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao obter produto por id");
            e.printStackTrace();
        } finally {
            conn.close();
        }
        return produto;
    }

    public void add(Produto produto) throws SQLException {
        Connection con = null;
        try {
            con = DriverManager.getConnection(urlDatabase);
            String insert = "INSERT INTO produtos(nome, categoria, quantidade, preco, id_fornecedor) VALUES(?, ?, ?, ?, ?)";
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
            System.out.println("Produto atualizado com sucesso!");
        } catch (SQLException e) {
            System.out.println("ERRO AO ATUALIZAR PRODUTOS!");
            e.printStackTrace();
        } finally {
            con.close();
        }
    }

    public void delete(int idProduto) throws SQLException {
        Connection con = null;
        try {
            con = DriverManager.getConnection(urlDatabase);
            String delete = "DELETE FROM produtos WHERE id_produto = ?";
            PreparedStatement stmt = con.prepareStatement(delete);
            stmt.setQueryTimeout(30);
            stmt.setInt(1, idProduto);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERRO AO DELETAR O PRODUTO!");
            e.printStackTrace();
        } finally {
            con.close();
        }
    }
}
