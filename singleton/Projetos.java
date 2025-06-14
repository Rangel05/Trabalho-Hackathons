package singleton;

import model.Projeto;
import java.util.ArrayList;
import java.util.List;

public class Projetos {
    private static Projetos instancia;
    private List<Projeto> lista = new ArrayList<>();

    private Projetos() {}

    public static Projetos getInstancia() {
        if (instancia == null) instancia = new Projetos();
        return instancia;
    }

    public void adicionar(Projeto p) {
        lista.add(p);
    }

    public List<Projeto> getLista() {
        return lista;
    }
}