package br.edu.fatecpg.atvheranca.ex2.model;

public class PagamentoDinheiro implements IPagamento {
    private double valor;

    public PagamentoDinheiro(double v) {
        valor = v;
    }

    @Override
    public double calcularPagamento() {
        return valor * 0.9;
    }

    @Override
    public String emitirRecibo() {
        // formate o recibo por favor
        return String.format(
                "Forma de pagamento: Dinheiro\n"
                        + "Valor original: R$ %.2f\n"
                        + "Desconto aplicado: 10%%\n"
                        + "Valor final: R$ %.2f\n",
                valor,
                calcularPagamento());
    }
}
