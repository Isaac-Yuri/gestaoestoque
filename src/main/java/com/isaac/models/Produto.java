package com.isaac.models;

public class Produto {
    private int idProduto;
    private int quantidade;
    private double preco;
    private String nome;
    private String categoria;
    private Fornecedor fornecedor;

    public Produto(int idProduto, String nome, int quantidade, Fornecedor fornecedor, String categoria, double preco) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.quantidade = quantidade;
        this.fornecedor = fornecedor;
        this.categoria = categoria;
        this.preco = preco;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

}