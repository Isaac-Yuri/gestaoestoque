package com.isaac;

import java.sql.SQLException;
import java.util.List;

import com.isaac.data.FornecedorDAO;
import com.isaac.data.MovimentacaoDAO;
import com.isaac.models.Fornecedor;
import com.isaac.models.Movimentacao;
;

public class Main {
    public static void main(String[] args) throws SQLException {
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        
        List <Fornecedor> fornecedores = fornecedorDAO.getAll();
        

        for (Fornecedor fornecedor:fornecedores) {
            System.out.println(fornecedor.getNome());
            System.out.println(fornecedor.getContato());
            System.out.println(fornecedor.getEndereco());
            System.out.println("=====================");
        }
        

        //TESTE DE MOVIMENTAÇÕES!
        MovimentacaoDAO movimentacaoDAO = new MovimentacaoDAO();

        List <Movimentacao> movimentacoes = movimentacaoDAO.getAll();
        
        for (Movimentacao movimentacao:movimentacoes){
            System.out.println(movimentacao.getIdMovimentacao());
            System.out.println(movimentacao.getQuantidade());
            System.out.println(movimentacao.getTipo());
            System.out.println(movimentacao.getData());
            System.out.println("==========================");
        }
    
        
    }
}
