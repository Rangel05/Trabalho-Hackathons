package singleton;

import model.Apresentacao;
import java.util.ArrayList;
import java.util.List;

public class Apresentacoes {
    private static Apresentacoes instancia;
    private List<Apresentacao> lista = new ArrayList<>();

    private Apresentacoes() {}

    public static Apresentacoes getInstancia() {
        if (instancia == null) instancia = new Apresentacoes();
        return instancia;
    }

    public void adicionar(Apresentacao a) {
        lista.add(a);
    }

    public List<Apresentacao> getLista() {
        return lista;
    }
}