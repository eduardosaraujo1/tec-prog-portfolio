package br.edu.fatecpg.polimorfismo.ex3.model;

public class Produto {
    private String nome;
    private Double preco;
    private Integer qtdeEstoque;

    public Produto(String nome) {
        this.nome = nome;
    }

    public Produto(String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public Produto(String nome, Double preco, Integer qtdeEstoque) {
        this.nome = nome;
        this.preco = preco;
        this.qtdeEstoque = qtdeEstoque;
    }

    @Override
    public String toString() {
        return "Produto [nome=" + nome + ", preco=" + preco + ", qtdeEstoque=" + qtdeEstoque + "]";
    }
}
