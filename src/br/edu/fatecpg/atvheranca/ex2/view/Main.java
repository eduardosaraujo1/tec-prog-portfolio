package br.edu.fatecpg.atvheranca.ex2.view;

import br.edu.fatecpg.atvheranca.ex2.model.*;

/*
 * [2]
 * Interface de Pagamentos
 * Crie uma interface chamada Pagamento com os seguintes métodos:
 * 
 * calcularPagamento(): Sem parâmetros, deve ser implementado para calcular o
 * valor do pagamento.
 * emitirRecibo(): Retorna um recibo detalhado da transação.
 * 
 * Agora, implemente essa interface em duas classes: PagamentoCartao e
 * PagamentoDinheiro.
 * 
 * A classe PagamentoCartao deve incluir uma taxa de 5% sobre o valor do
 * pagamento.
 * A classe PagamentoDinheiro deve aplicar um desconto de 10% sobre o valor do
 * pagamento.
 * 
 * No final, crie uma classe de teste que simule o pagamento de R$100,00 com as
 * duas formas de pagamento, calculando o valor final e emitindo um recibo.
 */
public class Main {
    public static void main(String[] args) {
        PagamentoCartao pc = new PagamentoCartao(100, "1234567891234567");
        PagamentoDinheiro pd = new PagamentoDinheiro(100);

        exibirPagamento(pc);
        exibirPagamento(pd);
    }

    private static void exibirPagamento(IPagamento pgto) {
        System.out.println("[PAGAMENTO EM CARTÃO]\n"
                + pgto.calcularPagamento() + "\n"
                + "[RECIBO]\n"
                + pgto.emitirRecibo());
        System.out.println("[PAGAMENTO EM DINHEIRO]\n"
                + pgto.calcularPagamento() + "\n"
                + "[RECIBO]"
                + pgto.emitirRecibo());

    }
}
