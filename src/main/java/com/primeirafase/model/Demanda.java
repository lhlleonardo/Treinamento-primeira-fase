package com.primeirafase.model;

import java.util.LinkedList;
import java.util.List;

public class Demanda {

    Long qtdeItens;
    String busca;
    List<Produto> produtos = new LinkedList<>();

    public Demanda(Long qtdeItens, String busca, List<Produto> produtos) {
        this.qtdeItens = qtdeItens;
        this.busca = busca;
        this.produtos = produtos;
    }

    public Long getQtdeItens() {
        return qtdeItens;
    }

    public void setQtdeItens(Long qtdeItens) {
        this.qtdeItens = qtdeItens;
    }

    public String getBusca() {
        return busca;
    }

    public void setBusca(String busca) {
        this.busca = busca;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public String buscarDemanda(String palavra){

        palavra = "Kindle";

        return palavra;
    }
}
