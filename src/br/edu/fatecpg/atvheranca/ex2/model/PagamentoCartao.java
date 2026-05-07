package br.edu.fatecpg.atvheranca.ex2.model;

public class PagamentoCartao implements IPagamento {
    // Simplificando regra de negócio, incluir apenas esses atributos
    private double valor;
    private String numeroCartao;

    public PagamentoCartao(double v, String n) {
        valor = v;
        numeroCartao = n;
    }

    @Override
    public double calcularPagamento() {
        // taxa de 5% sobre pagamentos em cartão
        return valor * 1.05;
    }

    @Override
    public String emitirRecibo() {
        return String.format(
                "Forma de pagamento: Cartão de Crédito\n"
                        + "Número do cartão: ****%s\n"
                        + "Valor original: R$ %.2f\n"
                        + "Taxa de 5%% aplicada\n"
                        + "Valor final: R$ %.2f\n",
                numeroCartao.substring(numeroCartao.length() - 4),
                valor,
                calcularPagamento());
    }
}
