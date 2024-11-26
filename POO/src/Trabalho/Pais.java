package Trabalho;

import java.util.ArrayList;
import java.util.List;

public class Pais {
    private String codigoISO;
    private String nome;
    private double populacao;
    private double dimensao;
    private List<Pais> vizinhos;

    // Construtor
    public Pais(String codigoISO, String nome, double dimensao) {
        this.codigoISO = codigoISO;
        this.nome = nome;
        this.dimensao = dimensao;
        this.vizinhos = new ArrayList<>();
    }

    // Getters e Setters
    public String getCodigoISO() {
        return codigoISO;
    }

    public void setCodigoISO(String codigoISO) {
        this.codigoISO = codigoISO;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPopulacao() {
        return populacao;
    }

    public void setPopulacao(double populacao) {
        this.populacao = populacao;
    }

    public double getDimensao() {
        return dimensao;
    }

    public void setDimensao(double dimensao) {
        this.dimensao = dimensao;
    }

    public List<Pais> getVizinhos() {
        return vizinhos;
    }

    // Método para adicionar vizinhos
    public void adicionarVizinho(Pais vizinho) {
        if (!vizinhos.contains(vizinho) && !vizinho.equals(this)) { // Verifica se o vizinho já foi adicionado ou se não é o próprio país
            vizinhos.add(vizinho);
        }
    }

    // Verifica se dois países são limítrofes
    public boolean eLimitrofe(Pais outro) {
        return vizinhos.contains(outro);
    }

    // Calcula a densidade populacional
    public double densidadePopulacional() {
        return populacao / dimensao;
    }

    // Sobrescrevendo o método toString para facilitar a exibição de informações
    @Override
    public String toString() {
        return "Pais{" +
                "codigoISO='" + codigoISO + '\'' +
                ", nome='" + nome + '\'' +
                ", populacao=" + populacao +
                ", dimensao=" + dimensao +
                ", vizinhos=" + listarNomesVizinhos() +
                '}';
    }

    // Método auxiliar para listar os nomes dos vizinhos
    private String listarNomesVizinhos() {
        List<String> nomes = new ArrayList<>();
        for (Pais vizinho : vizinhos) {
            nomes.add(vizinho.getNome());
        }
        return String.join(", ", nomes);
    }
}
