package com.isaac;

import java.sql.SQLException;
import java.util.List;

import com.isaac.data.FornecedorDAO;
import com.isaac.models.Fornecedor;
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
        fornecedorDAO.update(4, "Fornecedor D", "contato@fornecedord.com", "Rua Olinda, 721");
    }
}
