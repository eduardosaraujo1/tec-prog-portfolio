package br.edu.fatecpg.empresa.model;

public class Funcionario {
	private String nome;
	private String cargo;
	private String setor;
	private double salario;

	public Funcionario(String nome, String cargo, String setor, double salario) {
		super();
		this.nome = nome;
		this.cargo = cargo;
		this.setor = setor;
		this.salario = salario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public double getSalario() {
		return this.salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Funcionario [nome=" + nome + ", cargo=" + cargo + ", setor=" + setor + "]";
	}

}
