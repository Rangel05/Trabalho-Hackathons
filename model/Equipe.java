package model;

import java.util.ArrayList;
import java.util.List;

public class Equipe {
    private List<Estudante> membros = new ArrayList<>();

    public void adicionarMembro(Estudante estudante) {
        membros.add(estudante);
    }

    public List<Estudante> getMembros() {
        return membros;
    }
}