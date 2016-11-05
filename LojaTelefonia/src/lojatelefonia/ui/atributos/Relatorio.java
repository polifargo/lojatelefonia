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
public class Relatorio {

    private int idvenda;
    private double valorfinal;
    private int qtd;
    private String cliente;

    public Relatorio(int idvenda, double valorfinal, int qtd, String cliente) {
        this.idvenda = idvenda;
        this.valorfinal = valorfinal;
        this.qtd = qtd;
        this.cliente = cliente;
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
