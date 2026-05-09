package br.edu.fatecpg.empresa.model;

public class Empresa {
	private String nome;
	private String ramo;
	private String horarioAtendimento;
	private Cliente[] cliente;
	private Funcionario[] func;

	public Empresa(String nome, String ramo, String horarioAtendimento) {
		super();
		this.nome = nome;
		this.ramo = ramo;
		this.horarioAtendimento = horarioAtendimento;
		this.cliente = new Cliente[10];
		this.func = new Funcionario[5];
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRamo() {
		return ramo;
	}

	public void setRamo(String ramo) {
		this.ramo = ramo;
	}

	public String getHorarioAtendimento() {
		return horarioAtendimento;
	}

	public void setHorarioAtendimento(String horarioAtendimento) {
		this.horarioAtendimento = horarioAtendimento;
	}

	public void registrarCliente(int i, Cliente cliente) {
		this.cliente[i] = cliente;
	}

	public Cliente buscarCliente(int i) {
		return this.cliente[i];
	}

	public String apresentarClientes() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			sb.append(this.cliente[i] != null ? this.cliente[i].toString() : "-");
			sb.append("\n");
		}
		return sb.toString();
	}

	public String apresentarFuncionarios() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			sb.append(this.func[i] != null ? this.func[i].toString() : "-");
			sb.append("\n");
		}
		return sb.toString();
	}

	public void registrarFuncionario(int i, Funcionario func) {
		this.func[i] = func;
	}

	public Funcionario buscarFunc(int i) {
		return this.func[i];
	}

	public double calcularExibirFolhaSalarial() {
		double acc = 0;

		for (Funcionario f : func) {
			if (f != null) {
				acc += f.getSalario();
			}
		}

		System.out.printf("Folha salárial da empresa %s: %.2f\n", this.nome, acc);

		return acc;
	}

	@Override
	public String toString() {
		return "Empresa [nome=" + nome + ", ramo=" + ramo + ", horarioAtendimento=" + horarioAtendimento + "]";
	}

}
