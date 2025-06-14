package model;

import java.time.LocalDateTime;

public class Apresentacao {
    private Projeto projeto;
    private Banca banca;
    private Sala sala;
    private LocalDateTime dataHora;

    public Apresentacao(Projeto projeto, Banca banca, Sala sala, LocalDateTime dataHora) {
        this.projeto = projeto;
        this.banca = banca;
        this.sala = sala;
        this.dataHora = dataHora;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public Banca getBanca() {
        return banca;
    }

    public Sala getSala() {
        return sala;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    /**
     * Avalia o projeto através da banca, calculando e atribuindo a nota final.
     */
    public void avaliar() {
        if (banca != null) {
            banca.calcularNotaFinal();
        }
    }

    @Override
    public String toString() {
        String titulo = (projeto != null && projeto.getTitulo() != null) ? projeto.getTitulo() : "Sem projeto";
        String localSala = (sala != null && sala.getLocal() != null) ? sala.getLocal() : "Sem sala";
        String nota = (projeto != null) ? String.valueOf(projeto.getNotaFinal()) : "Sem nota";
        return "Projeto: " + titulo +
                " | Sala: " + localSala +
                " | Data/Hora: " + dataHora +
                " | Nota Final: " + nota;
    }
}