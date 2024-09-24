package com.isaac.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.isaac.models.Movimentacao;

public class MovimentacaoDAO implements DAO<Movimentacao>{

    @Override
    public List<Movimentacao> getAll() throws SQLException {
        List<Movimentacao> movimentacoes = new ArrayList<>();
        Connection conn = null;
        try {
            String query = "SELECT * FROM movimentacoes";
            conn = DriverManager.getConnection(urlDatabase);

            if (conn != null) {
                System.out.println("Conexão bem sucedida!");
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet res = stmt.executeQuery();

                while (res.next()) {
                    Movimentacao movimentacao = new Movimentacao();
                    movimentacao.setTipo(res.getString("tipo"));
                    movimentacao.setQuantidade(res.getInt("quantidade"));
                    movimentacao.setData(res.getString("data"));

                    movimentacoes.add(movimentacao);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro na Conexão");
            e.printStackTrace();
        } finally {
            conn.close();
            System.out.println("Conexão Encerrada!");
        }
        return movimentacoes;
    }

   public void add(Movimentacao movimentacao) throws SQLException {
        Connection con = null;
        try {
            con = DriverManager.getConnection(urlDatabase);
            String insert = "INSERT INTO movimentacao(quantidade, tipo, data) VALUES(?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(insert);
            stmt.setQueryTimeout(30);
            stmt.setInt(1, movimentacao.getIdMovimentacao());
            stmt.setInt(2, movimentacao.getQuantidade());
            stmt.setString(3, movimentacao.getTipo());
            stmt.setString(4, movimentacao.getData());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERRO AO CADASTRAR MOVIMENTACAO!");
            e.printStackTrace();
        } finally {
            con.close();
        }
    }

    public void update(Movimentacao movimentacao) throws SQLException {
        Connection con = null;
        try {
            con = DriverManager.getConnection(urlDatabase);
            String update = "UPDATE movimentacoes SET quantidade = ?, tipo = ?, data = ? WHERE idMovimentacao = ?";
            PreparedStatement stmt = con.prepareStatement(update);
            stmt.setQueryTimeout(30);
            stmt.setInt(1, movimentacao.getQuantidade());
            stmt.setString(2, movimentacao.getTipo());
            stmt.setString(3, movimentacao.getData());
            stmt.setInt(4, movimentacao.getIdMovimentacao());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERRO AO ATUALIZAR MOVIMENTACAO!");
            e.printStackTrace();
        } finally {
            con.close();
        }    
    }

    public void delete(int id_movimentacao) throws SQLException {
        Connection con = null;
        try{
            con = DriverManager.getConnection(urlDatabase);
            String delete = "DELETE FROM movimentacoes WHERE id_movimentacao = ?";
            PreparedStatement stmt = con.prepareStatement(delete);
            stmt.setQueryTimeout(30);
            stmt.setInt(1, id_movimentacao);
            stmt.executeUpdate();
        } catch(SQLException e){
            System.out.println("ERRO AO DELETAR O FORNECEDOR!");
            e.printStackTrace();
        } finally{
            con.close();
        }
    }
}
