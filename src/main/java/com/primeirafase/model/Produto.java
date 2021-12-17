package com.primeirafase.model;

public class Produto {

    String valor;
    String descricao;
    String imagem;

    public Produto() {
    }

    public Produto(String valor, String descricao, String imagem) {
        this.valor = valor;
        this.descricao = descricao;
        this.imagem = imagem;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String retornaProduto() {
        return valor + " | " + descricao + " | " + imagem + ".\n";
    }
}
