package com.primeirafase.model;

import java.math.BigDecimal;

public class Produto {

    BigDecimal valor;
    String descricao;
    String imagem;

    public Produto(BigDecimal valor, String descricao, String imagem) {
        this.valor = valor;
        this.descricao = descricao;
        this.imagem = imagem;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
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
}
