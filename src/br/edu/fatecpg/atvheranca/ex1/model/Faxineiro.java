package br.edu.fatecpg.atvheranca.ex1.model;

public class Faxineiro implements IFuncionario {
    private String nome;

    public Faxineiro(String n) {
        nome = n;
    }

    @Override
    public void baterPonto() {
        System.out.println("'" + nome + "' bateu o ponto e está pronto para limpar");
    }

    @Override
    public void atenderCliente(String nomeCliente) {
        System.out.println("'" + nome + "' está auxiliando o cliente realizando uma limpeza.");
    }

    public void limparMesa(int idMesa) {
        System.out.println("'" + nome + "' está limpando a mesa " + idMesa);
    }

}
