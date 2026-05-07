package br.edu.fatecpg.polimorfismo.ex4.model;

public class PagamentoBoleto extends Pagamento {
    @Override
    public void processarPagamento() {
        System.out.println("Processando pagamento via boleto bancário");
    }
}
