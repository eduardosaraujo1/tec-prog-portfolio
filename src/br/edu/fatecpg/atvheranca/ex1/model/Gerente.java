package br.edu.fatecpg.atvheranca.ex1.model;

public class Gerente implements IFuncionario {
    private String nome;
    private IFuncionario[] subordinados;

    public Gerente(String n, IFuncionario[] s) {
        nome = n;
        subordinados = s;
    }

    @Override
    public void baterPonto() {
        System.out.println("'" + nome + "' bateu o ponto.");
    }

    @Override
    public void atenderCliente(String nomeCliente) {
        System.out.println("'" + nome + "' atendeu os problemas do cliente.");
    }

    public void exibirSubordinados() {
        for (IFuncionario f : subordinados) {
            System.out.println(f);
        }
    }
}
