package com.isaac;

import java.sql.SQLException;
import java.util.List;

import com.isaac.data.FornecedorDAO;
import com.isaac.models.Fornecedor;

public class Main {
    public static void main(String[] args) throws SQLException {
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        Fornecedor fornecedor1 = new Fornecedor();
        fornecedor1.setNome("FornecedorD");
        fornecedor1.setContato("contato@fornecedord.com");
        fornecedor1.setEndereco("Rua das Índias, 540");
        fornecedorDAO.add(fornecedor1);

        List <Fornecedor> fornecedores = fornecedorDAO.getAll();

        for (Fornecedor fornecedor:fornecedores) {
            System.out.println(fornecedor.getNome());
            System.out.println(fornecedor.getContato());
            System.out.println(fornecedor.getEndereco());
            System.out.println("=====================");
        }
    }
}
