package com.isaac.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.isaac.models.Movimentacao;

public class MovimentacaoDAO extends DAO {

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
