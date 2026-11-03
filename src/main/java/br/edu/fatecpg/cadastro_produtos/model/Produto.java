package br.edu.fatecpg.cadastro_produtos.model;

import java.util.UUID;

public class Produto {

	private final String id = UUID.randomUUID().toString();
	private String nome;
	private double preco;
	private String categoria;
	private int estoque;

	public Produto() {
	}

	public String getId() {
		return id;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}
