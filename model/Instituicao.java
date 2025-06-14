package model;

public abstract class Instituicao {
    protected String nome;

    public Instituicao(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
