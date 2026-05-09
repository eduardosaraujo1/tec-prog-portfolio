package br.edu.fatecpg.empresa.view;

import br.edu.fatecpg.empresa.model.*;

public class Main {

	public static void main(String[] args) {
		Cliente cliente = new Cliente("Ale", "ale@fatec.br");
		Funcionario func = new Funcionario("Maria", "Gerente", "Vendas", 4200);
		Empresa emp = new Empresa("Fatec", "Educação", "13:10 - 18:30");
		System.out.println(emp);

		emp.registrarCliente(0, cliente);
		emp.registrarCliente(2, cliente);
		emp.registrarCliente(4, cliente);
		emp.registrarFuncionario(0, func);

		System.out.println(emp.apresentarClientes());
		emp.calcularExibirFolhaSalarial();
	}

}
