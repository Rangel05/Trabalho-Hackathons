package model;

import java.util.HashMap;
import java.util.Map;

public class Banca implements Avaliavel {
    private Projeto projetoAvaliado;
    private Map<Jurado, Integer> jurados = new HashMap<>();

    public Banca(Projeto projetoAvaliado) {
        this.projetoAvaliado = projetoAvaliado;
    }

    public void adicionarNota(Jurado jurado, int nota) {
        jurados.put(jurado, nota);
    }

    @Override
    public void calcularNotaFinal() {
        if (jurados.isEmpty()) {
            projetoAvaliado.setNotaFinal(0);
            return;
        }
        int soma = jurados.values().stream().mapToInt(Integer::intValue).sum();
        int media = soma / jurados.size();
        projetoAvaliado.setNotaFinal(media);
    }
}