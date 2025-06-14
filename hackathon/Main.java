package hackathon;
import model.*;
import singleton.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Instituições
        Universidade puc = new Universidade("PUC Minas");
        Empresa google = new Empresa("Google");

        // Equipes
        Equipe equipe1 = criarEquipe(Arrays.asList("Ana", "Bruno", "Carla", "Daniel", "Eva"), puc);
        Equipe equipe2 = criarEquipe(Arrays.asList("Fábio", "Gabriela", "Hugo", "Isabela", "João"), puc);
        Equipes.getInstancia().adicionar(equipe1);
        Equipes.getInstancia().adicionar(equipe2);

        // Projetos
        Projeto projeto1 = criarProjeto("EcoTech", "João Mentor", equipe1, google);
        Projeto projeto2 = criarProjeto("HealthApp", "Maria Mentora", equipe2, google);
        Projetos.getInstancia().adicionar(projeto1);
        Projetos.getInstancia().adicionar(projeto2);

        // Jurados
        List<Jurado> jurados = criarJurados(
                Arrays.asList("Jurado A", "Jurado B", "Jurado C", "Jurado D",
                              "Jurado E", "Jurado F", "Jurado G", "Jurado H"), google);

        // Bancas e apresentações
        criarApresentacao(projeto1, jurados.subList(0, 4), Arrays.asList(8, 9, 7, 8), "Sala 101");
        criarApresentacao(projeto2, jurados.subList(4, 8), Arrays.asList(6, 7, 8, 7), "Sala 102");

        // Listar projetos aprovados (nota final >= 7)
        System.out.println("Projetos aprovados (nota >= 7):");
        List<Apresentacao> aprovados = Apresentacoes.getInstancia().getLista().stream()
                .filter(ap -> ap.getProjeto().getNotaFinal() >= 7)
                .collect(Collectors.toList());
        if (aprovados.isEmpty()) {
            System.out.println("Nenhum projeto aprovado.");
        } else {
            aprovados.forEach(ap -> System.out.println(ap));
        }
    }

    // Cria uma equipe com estudantes
    private static Equipe criarEquipe(List<String> nomesAlunos, Universidade universidade) {
        Equipe equipe = new Equipe();
        nomesAlunos.forEach(nome -> equipe.adicionarMembro(new Estudante(nome, universidade)));
        return equipe;
    }

    // Cria um projeto com mentor
    private static Projeto criarProjeto(String titulo, String nomeMentor, Equipe equipe, Empresa empresa) {
        Profissional mentor = new Profissional(nomeMentor, empresa);
        return new Projeto(titulo, mentor, equipe);
    }

    // Cria lista de jurados
    private static List<Jurado> criarJurados(List<String> nomes, Empresa empresa) {
        return nomes.stream().map(nome -> new Jurado(nome, empresa)).collect(Collectors.toList());
    }

    // Cria apresentação, avalia e adiciona ao singleton
    private static void criarApresentacao(Projeto projeto, List<Jurado> jurados, List<Integer> notas, String localSala) {
        Banca banca = new Banca(projeto);
        for (int i = 0; i < jurados.size(); i++) {
            banca.adicionarNota(jurados.get(i), notas.get(i));
        }
        Sala sala = new Sala(localSala);
        Apresentacao apresentacao = new Apresentacao(projeto, banca, sala, LocalDateTime.now());
        apresentacao.avaliar();
        Apresentacoes.getInstancia().adicionar(apresentacao);
    }
}