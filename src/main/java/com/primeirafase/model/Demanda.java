package com.primeirafase.model;

import java.util.LinkedList;
import java.util.List;

public class Demanda {

    String qtdeItens;
    String busca;
    List<Produto> produtos = new LinkedList<>();

    public Demanda() {
    }

    public String getQtdeItens() {
        return qtdeItens;
    }

    public void setQtdeItens(String qtdeItens) {
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

    public void adicionaProduto(Produto produto){
        this.produtos.add(produto);
    }

    public String retornarBusca() {

        StringBuilder retorno = new StringBuilder("Você buscou pelo conteúdo '" + busca +
                "' retornando " + qtdeItens +
                "(s). \n" +
                "A pesquisa apresentou os seguintes itens: \n");

        for (Produto p : produtos) {
            retorno.append(p.retornaProduto());
        }

        return retorno.toString();
    }
}
