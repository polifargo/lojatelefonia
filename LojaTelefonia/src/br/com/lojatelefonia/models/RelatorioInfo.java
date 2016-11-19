package br.com.lojatelefonia.models;

public class RelatorioInfo {

    private int idvenda;
    private String produto;
    private int qtd;
    private double valor;

    public RelatorioInfo(int idvenda, String produto, int qtd, double valor) {
        this.idvenda = idvenda;
        this.produto = produto;
        this.qtd = qtd;
        this.valor = valor;
    }

    public int getIdvenda() {
        return idvenda;
    }

    public String getProduto() {
        return produto;
    }

    public int getQtd() {
        return qtd;
    }

    public double getValor() {
        return valor;
    }
}
