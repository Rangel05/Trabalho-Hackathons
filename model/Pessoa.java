package model;

public abstract class Pessoa {
    protected String nome;
    protected Instituicao instituicao;

    public Pessoa(String nome, Instituicao instituicao) {
        this.nome = nome;
        this.instituicao = instituicao;
    }

    public String getNome() {
        return nome;
    }
}