package br.com.lojatelefonia.models;

public class Relatorio {

    private int idvenda;
    private double valorfinal;
    private int qtd;
    private String cliente;
    private String dataVenda;

    public Relatorio(int idvenda, double valorfinal, int qtd, String cliente, String dataVenda) {
        this.idvenda = idvenda;
        this.valorfinal = valorfinal;
        this.qtd = qtd;
        this.cliente = cliente;
        this.dataVenda = dataVenda;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public int getIdvenda() {
        return idvenda;
    }

    public double getValorfinal() {
        return valorfinal;
    }

    public int getQtd() {
        return qtd;
    }

    public String getCliente() {
        return cliente;
    }

}
