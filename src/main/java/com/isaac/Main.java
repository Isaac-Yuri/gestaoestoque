package com.isaac;

import java.sql.SQLException;
import java.util.List;

import com.isaac.data.FornecedorDAO;
import com.isaac.data.ProdutoDAO;
import com.isaac.models.Produto;

public class Main {
    public static void main(String[] args) throws SQLException {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        FornecedorDAO fornecedorDAO = new FornecedorDAO();

        Produto notebookUpdate = produtoDAO.getProdutoById(3);
        System.out.println(notebookUpdate.getNome());

        notebookUpdate.setFornecedor(fornecedorDAO.getFornecedorById(2));

        produtoDAO.update(notebookUpdate);
        produtoDAO.delete(7);

        List<Produto> produtos = produtoDAO.getAll();
        
        for(Produto produto: produtos) {
            System.out.println("Nome: " + produto.getNome());
            System.out.println("Preço: " + produto.getPreco());
            System.out.println("Fornecedor: " + produto.getFornecedor().getNome());
            System.out.println("======================");
        }
    }
}
