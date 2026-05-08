package br.edu.fatecpg.empresa.model;

public class Cliente {
	private String nome;
	private String email;
	private boolean mensalidadePaga=false;
	public Cliente(String nome, String email) {
		this.nome = nome;
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isMensalidadePaga() {
		return mensalidadePaga;
	}
	public void setMensalidadePaga(boolean mensalidadePaga) {
		this.mensalidadePaga = mensalidadePaga;
	}
	@Override
	public String toString() {
		return String.format("Cliente [nome=%s, email=%s, mensalidadePaga=%s]", this.nome, this.email, this.mensalidadePaga);
	}
	
}
