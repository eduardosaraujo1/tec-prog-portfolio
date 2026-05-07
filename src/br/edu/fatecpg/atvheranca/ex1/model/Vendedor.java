package br.edu.fatecpg.atvheranca.ex1.model;

public class Vendedor implements IFuncionario {
    private String nome;
    private int salario;

    public Vendedor(String n, int s) {
        nome = n;
        salario = s;
    }

    public int getSalario() {
        return salario;
    }

    @Override
    public void baterPonto() {
        System.out.println("'" + nome + "' bateu o ponto");
    }

    @Override
    public void atenderCliente(String nomeCliente) {
        System.out.println("'" + nome + "' atendeu o cliente " + nomeCliente);
    }
}
