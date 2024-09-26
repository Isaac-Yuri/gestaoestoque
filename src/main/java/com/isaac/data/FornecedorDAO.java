package com.isaac.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.isaac.models.Fornecedor;

public class FornecedorDAO implements DAO<Fornecedor> {

    public List<Fornecedor> getAll() throws SQLException {
        List<Fornecedor> fornecedores = new ArrayList<>();
        String query = "SELECT * FROM fornecedores";

        try (Connection conn = DriverManager.getConnection(urlDatabase);
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet res = stmt.executeQuery()) {

            System.out.println("Conexão bem sucedida!");

            while (res.next()) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setIdFornecedor(res.getInt("id_fornecedor"));
                fornecedor.setNome(res.getString("nome"));
                fornecedor.setEndereco(res.getString("endereco"));
                fornecedor.setContato(res.getString("contato"));

                fornecedores.add(fornecedor);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar fornecedores.");
            e.printStackTrace();
        }

        return fornecedores;
    }

    public Fornecedor getFornecedorById(int id_fornecedor) throws SQLException {
        Fornecedor fornecedor = new Fornecedor();
        String query = "SELECT * FROM fornecedores WHERE id_fornecedor = ?";

        try (Connection conn = DriverManager.getConnection(urlDatabase);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id_fornecedor);
            try (ResultSet res = stmt.executeQuery()) {

                if (res.next()) {
                    fornecedor.setIdFornecedor(res.getInt("id_fornecedor"));
                    fornecedor.setNome(res.getString("nome"));
                    fornecedor.setEndereco(res.getString("endereco"));
                    fornecedor.setContato(res.getString("contato"));
                } else {
                    System.out.println("Fornecedor com id " + id_fornecedor + " não encontrado.");
                }

            }
        } catch (SQLException e) {
            System.out.println("Erro ao obter fornecedor por id.");
            e.printStackTrace();
        }

        return fornecedor;
    }

    public void add(Fornecedor fornecedor) throws SQLException {
        String insert = "INSERT INTO fornecedores(nome, contato, endereco) VALUES(?, ?, ?)";

        try (Connection con = DriverManager.getConnection(urlDatabase);
             PreparedStatement stmt = con.prepareStatement(insert)) {

            stmt.setQueryTimeout(30);
            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getContato());
            stmt.setString(3, fornecedor.getEndereco());
            stmt.executeUpdate();

            System.out.println("Fornecedor adicionado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao adicionar fornecedor.");
            e.printStackTrace();
        }
    }

    public void update(Fornecedor fornecedor) throws SQLException {
        String update = "UPDATE fornecedores SET nome = ?, contato = ?, endereco = ? WHERE id_fornecedor = ?";

        try (Connection con = DriverManager.getConnection(urlDatabase);
             PreparedStatement stmt = con.prepareStatement(update)) {

            stmt.setQueryTimeout(30);
            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getContato());
            stmt.setString(3, fornecedor.getEndereco());
            stmt.setInt(4, fornecedor.getIdFornecedor());
            stmt.executeUpdate();

            System.out.println("Fornecedor atualizado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar fornecedor com id " + fornecedor.getIdFornecedor());
            e.printStackTrace();
        }
    }

    public void delete(int id_fornecedor) throws SQLException {
        String delete = "DELETE FROM fornecedores WHERE id_fornecedor = ?";

        try (Connection con = DriverManager.getConnection(urlDatabase);
             PreparedStatement stmt = con.prepareStatement(delete)) {

            stmt.setQueryTimeout(30);
            stmt.setInt(1, id_fornecedor);
            stmt.executeUpdate();

            System.out.println("Fornecedor deletado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao deletar fornecedor com id " + id_fornecedor);
            e.printStackTrace();
        }
    }
}
