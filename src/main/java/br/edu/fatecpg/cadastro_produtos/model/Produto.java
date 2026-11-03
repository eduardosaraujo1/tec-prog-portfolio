package br.edu.fatecpg.cadastro_produtos.model;

import java.util.UUID;
import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Produto {

	@Id
	@Column(length = 36, updatable = false)
	private String id = UUID.randomUUID().toString();

	// Preserva a ordem de cadastro sem depender da ordenação dos UUIDs no banco.
	@Column(nullable = false, updatable = false)
	private Instant criadoEm = Instant.now();

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
