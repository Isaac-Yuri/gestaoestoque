package com.isaac.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.isaac.models.Movimentacao;

public class MovimentacaoDAO implements DAO<Movimentacao> {

    public List<Movimentacao> getAll() throws SQLException {
        List<Movimentacao> movimentacoes = new ArrayList<>();
        String query = "SELECT * FROM movimentacoes";

        try (Connection conn = DriverManager.getConnection(urlDatabase);
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet res = stmt.executeQuery()) {

            System.out.println("Conexão bem sucedida!");

            while (res.next()) {
                Movimentacao movimentacao = new Movimentacao();
                movimentacao.setIdMovimentacao(res.getInt("id_movimentacao"));
                movimentacao.setTipo(res.getString("tipo"));
                movimentacao.setQuantidade(res.getInt("quantidade"));
                movimentacao.setData(res.getString("data"));

                movimentacoes.add(movimentacao);
            }
        } catch (SQLException e) {
            System.out.println("Erro na Conexão");
            e.printStackTrace();
        }
        return movimentacoes;
    }

    public void add(Movimentacao movimentacao) throws SQLException {
        String insert = "INSERT INTO movimentacoes(quantidade, tipo, data) VALUES(?, ?, ?)";

        try (Connection con = DriverManager.getConnection(urlDatabase);
             PreparedStatement stmt = con.prepareStatement(insert)) {

            stmt.setQueryTimeout(30);
            stmt.setInt(1, movimentacao.getQuantidade());
            stmt.setString(2, movimentacao.getTipo());
            stmt.setString(3, movimentacao.getData());

            stmt.executeUpdate();
            System.out.println("Movimentação cadastrada com sucesso!");
        } catch (SQLException e) {
            System.out.println("ERRO AO CADASTRAR MOVIMENTAÇÃO!");
            e.printStackTrace();
        }
    }

    public void update(Movimentacao movimentacao) throws SQLException {
        String update = "UPDATE movimentacoes SET quantidade = ?, tipo = ?, data = ? WHERE id_movimentacao = ?";

        try (Connection con = DriverManager.getConnection(urlDatabase);
             PreparedStatement stmt = con.prepareStatement(update)) {

            stmt.setQueryTimeout(30);
            stmt.setInt(1, movimentacao.getQuantidade());
            stmt.setString(2, movimentacao.getTipo());
            stmt.setString(3, movimentacao.getData());
            stmt.setInt(4, movimentacao.getIdMovimentacao());

            stmt.executeUpdate();
            System.out.println("Movimentação atualizada com sucesso!");
        } catch (SQLException e) {
            System.out.println("ERRO AO ATUALIZAR MOVIMENTAÇÃO!");
            e.printStackTrace();
        }
    }

    public void delete(int id_movimentacao) throws SQLException {
        String delete = "DELETE FROM movimentacoes WHERE id_movimentacao = ?";

        try (Connection con = DriverManager.getConnection(urlDatabase);
             PreparedStatement stmt = con.prepareStatement(delete)) {

            stmt.setQueryTimeout(30);
            stmt.setInt(1, id_movimentacao);

            stmt.executeUpdate();
            System.out.println("Movimentação deletada com sucesso!");
        } catch (SQLException e) {
            System.out.println("ERRO AO DELETAR A MOVIMENTAÇÃO!");
            e.printStackTrace();
        }
    }

    public void setIdMovimentacao(int parseInt) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
