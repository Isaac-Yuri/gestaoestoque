package com.isaac.models;

public class Movimentacao {
    private int idMovimentacao;
    private int quantidade;
    private String tipo;
    private String data;
    private Produto produto;

    public Movimentacao() {}

    public int getIdMovimentacao() {
        return idMovimentacao;
    }

    public void setIdMovimentacao(int idMovimentacao) {
        this.idMovimentacao = idMovimentacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Produto getIdProduto() {
        return produto;
    }

    public void setIdProduto(Produto idProduto) {
        this.produto = idProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
