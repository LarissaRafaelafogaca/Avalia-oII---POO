package Trabalho;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criando o continente
        System.out.println("Digite o nome do continente:");
        String nomeContinente = scanner.nextLine();
        Continente continente = new Continente(nomeContinente);

        System.out.println("Quantos países você deseja adicionar ao continente?");
        int numeroPaises = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha após o número

        // Adicionando países ao continente
        for (int i = 0; i < numeroPaises; i++) {
            System.out.println("\n--- Dados do país " + (i + 1) + " ---");

            System.out.print("Digite o código ISO do país: ");
            String codigoISO = scanner.nextLine();

            System.out.print("Digite o nome do país: ");
            String nomePais = scanner.nextLine();

            System.out.print("Digite a dimensão territorial do país (em km²): ");
            double dimensao = scanner.nextDouble();

            System.out.print("Digite a população do país: ");
            double populacao = scanner.nextDouble();
            scanner.nextLine(); // Consumir a quebra de linha

            // Criando o país
            Pais pais = new Pais(codigoISO, nomePais, dimensao);
            pais.setPopulacao(populacao);

            // Adicionar vizinhos (opcional)
            System.out.println("O país possui vizinhos? (s/n)");
            String respostaVizinho = scanner.nextLine();

            if (respostaVizinho.equalsIgnoreCase("s")) {
                System.out.println("Quantos vizinhos o país possui?");
                int numeroVizinhos = scanner.nextInt();
                scanner.nextLine(); // Consumir a quebra de linha

                for (int j = 0; j < numeroVizinhos; j++) {
                    System.out.print("Digite o nome do vizinho " + (j + 1) + ": ");
                    String nomeVizinho = scanner.nextLine();

                    // Procurar o país vizinho no continente (caso já tenha sido adicionado)
                    Pais vizinho = buscarPaisPorNome(continente, nomeVizinho);

                    if (vizinho != null) {
                        pais.adicionarVizinho(vizinho);
                        vizinho.adicionarVizinho(pais); // Adiciona a relação de vizinhança nos dois lados
                    } else {
                        System.out.println("País vizinho " + nomeVizinho + " não encontrado no continente.");
                    }
                }
            }

            // Adicionar país ao continente
            continente.adicionarPais(pais);
        }

        // Exibir dados do continente
        System.out.println("\n--- Informações do continente ---");
        System.out.println("Nome do continente: " + continente.getNome());
        System.out.println("Dimensão total: " + continente.dimensaoTotal());
        System.out.println("População total: " + continente.populacaoTotal());
        System.out.println("Densidade populacional: " + continente.densidadePopulacional());

        scanner.close();
    }

    // Método para buscar um país pelo nome no continente
    public static Pais buscarPaisPorNome(Continente continente, String nomePais) {
        for (Pais pais : continente.getPaises()) {
            if (pais.getNome().equalsIgnoreCase(nomePais)) {
                return pais;
            }
        }
        return null;
    }
}