package lojatelefonia.ui.atributos;

public class Cliente {

    private int id;
    private String nome;
    private String nasc;
    private String telefone;
    private String cpf;

    public Cliente(int id, String nome, String nasc, String telefone, String cpf) {
        this.id = id;
        this.nome = nome;
        this.nasc = nasc;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getNasc() {
        return nasc;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCpf() {
        return cpf;
    }

}
