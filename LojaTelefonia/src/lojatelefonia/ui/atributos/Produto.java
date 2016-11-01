/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojatelefonia.ui.atributos;

/**
 *
 * @author Matheus
 */
public class Produto {

    private int id;
    private String nome;
    private String desc;
    private String marca;
    private String serie;
    private String fab;
    private int qtd;
    private Double valor;

    public Produto(int id, String nome, String desc, String marca, String serie, String fab, int qtd, Double valor) {
        this.id = id;
        this.nome = nome;
        this.desc = desc;
        this.marca = marca;
        this.serie = serie;
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

    public String getSerie() {
        return serie;
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
