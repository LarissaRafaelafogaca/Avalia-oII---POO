package Trabalho;

import java.util.ArrayList;
import java.util.List;

public class Continente {
    private String nome;
    private List<Pais> paises;

    public Continente(String nome) {
        this.nome = nome;
        this.paises = new ArrayList<>();
    }

    public void adicionarPais(Pais pais) {
        paises.add(pais);
    }

    public List<Pais> getPaises() {
        return paises;
    }

    public String getNome() {
        return nome;
    }

    public double dimensaoTotal() {
        double total = 0;
        for (Pais pais : paises) {
            total += pais.getDimensao();
        }
        return total;
    }

    public double populacaoTotal() {
        double total = 0;
        for (Pais pais : paises) {
            total += pais.getPopulacao();
        }
        return total;
    }

    public double densidadePopulacional() {
        return populacaoTotal() / dimensaoTotal();
    }
}
