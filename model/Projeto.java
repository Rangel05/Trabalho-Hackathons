package model;

public class Projeto {
    private Profissional criador;
    private Equipe equipe;
    private int notaFinal;
    private String titulo;

    public Projeto(String titulo, Profissional criador, Equipe equipe) {
        this.titulo = titulo;
        this.criador = criador;
        this.equipe = equipe;
    }

    public void setNotaFinal(int notaFinal) {
        this.notaFinal = notaFinal;
    }

    public int getNotaFinal() {
        return notaFinal;
    }

    public String getTitulo() {
        return titulo;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public Profissional getCriador() {
        return criador;
    }
}
