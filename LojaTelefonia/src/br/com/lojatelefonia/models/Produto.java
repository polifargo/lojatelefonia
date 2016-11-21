package br.com.lojatelefonia.models;

public class Produto {

    private int id;
    private String nome;
    private String desc;
    private String marca;
    private String num;
    private String fab;
    private int qtd;
    private Double valor;

    public Produto(int id, String nome, String desc, String marca, String num, String fab, int qtd, Double valor) {
        this.id = id;
        this.nome = nome;
        this.desc = desc;
        this.marca = marca;
        this.num = num;
        this.fab = fab;
        this.qtd = qtd;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDesc() {
        return desc;
    }

    public String getMarca() {
        return marca;
    }

    public String getNum() {
        return num;
    }

    public String getFab() {
        return fab;
    }

    public int getQtd() {
        return qtd;
    }

    public Double getValor() {
        return valor;
    }

}
