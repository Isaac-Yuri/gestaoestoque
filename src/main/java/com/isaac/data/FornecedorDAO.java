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
                    fornecedor.setIdFornecedor(res.getInt("id_fornecedor"));
                    fornecedor.setNome(res.getString("nome"));
                    fornecedor.setEndereco(res.getString("endereco"));
                    fornecedor.setContato(res.getString("contato"));

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

    public void add(Fornecedor fornecedor) throws SQLException {
        Connection con = null;
        try {
            con = DriverManager.getConnection(FornecedorDAO.urlDatabase);
            String insert = "INSERT INTO fornecedores(nome, contato, endereco) VALUES(?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(insert);
            stmt.setQueryTimeout(30);
            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getContato());
            stmt.setString(3, fornecedor.getEndereco());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERRO AO ADICIONAR FORNECEDOR!");
            e.printStackTrace();
        } finally {
            con.close();
        }
    }

    public void update(Fornecedor fornecedor) throws SQLException {
        Connection con = null;
        try{
            con = DriverManager.getConnection(urlDatabase);
            String update = "UPDATE fornecedores SET nome =  ?, contato = ?, endereco = ? WHERE id_fornecedor = ?";
            PreparedStatement stmt = con.prepareStatement(update);
            stmt.setQueryTimeout(30);
            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getContato());
            stmt.setString(3, fornecedor.getEndereco());
            stmt.setInt(4, fornecedor.getIdFornecedor());
            stmt.executeUpdate();
        } catch(SQLException e) {
            System.out.println("ERRO AO ATUALIZAR O FORNECEDOR!");
            e.printStackTrace();
        } finally {
            con.close();
        }
    }
    
    public void delete(int id_fornecedor) throws SQLException {
        Connection con = null;
        try{
            con = DriverManager.getConnection(urlDatabase);
            String delete = "DELETE FROM fornecedores WHERE id_fornecedor = ?";
            PreparedStatement stmt = con.prepareStatement(delete);
            stmt.setQueryTimeout(30);
            stmt.setInt(1, id_fornecedor);
            stmt.executeUpdate();
        } catch(SQLException e){
            System.out.println("ERRO AO DELETAR O FORNECEDOR!");
            e.printStackTrace();
        } finally{
            con.close();
        }
    }
}
