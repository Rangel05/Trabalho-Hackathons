package singleton;

import model.Equipe;
import java.util.ArrayList;
import java.util.List;

public class Equipes {
    private static Equipes instancia;
    private List<Equipe> lista = new ArrayList<>();

    private Equipes() {}

    public static Equipes getInstancia() {
        if (instancia == null) instancia = new Equipes();
        return instancia;
    }

    public void adicionar(Equipe e) {
        lista.add(e);
    }

    public List<Equipe> getLista() {
        return lista;
    }
}