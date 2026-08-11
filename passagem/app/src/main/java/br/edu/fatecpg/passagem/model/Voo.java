package br.edu.fatecpg.passagem.model;

public class Voo {

    private static final double TAXA_TURISMO = 5;
    private static final double PC_DESC_VOLTA = 5;

    private String numeroVoo;
    private String origem;
    private String destino;
    private double valorPassagem;
    private int assentosDisponiveis;

    public Voo(
        String numeroVoo,
        String origem,
        String destino,
        double valorPassagem,
        int assentosDisponiveis
    ) {
        this.numeroVoo = numeroVoo;
        this.origem = origem;
        this.destino = destino;
        this.valorPassagem = valorPassagem;
        this.assentosDisponiveis = assentosDisponiveis;
    }

    public String getNumeroVoo() {
        return numeroVoo;
    }

    public void setNumeroVoo(String numeroVoo) {
        this.numeroVoo = numeroVoo;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getAssentosDisponiveis() {
        return assentosDisponiveis;
    }

    public void setAssentosDisponiveis(int assentosDisponiveis) {
        this.assentosDisponiveis = assentosDisponiveis;
    }

    public boolean realizarReserva(int quantidadeAssentos) {
        if (verificarDisponibilidade(quantidadeAssentos)) {
            assentosDisponiveis -= quantidadeAssentos;
            return true;
        }

        return false;
    }

    public boolean verificarDisponibilidade(int quantidadeAssentos) {
        return assentosDisponiveis >= quantidadeAssentos;
    }

    // realizarPagamento(String tipoViagem, boolean pontosTuristicos): método que realiza
    // o pagamento da passagem, considerando se é somente ida, ida e volta, e se inclui
    // pontos turísticos (taxa adicional).assentosDisponiveis >= quantidadeAssentos
    public double realizarPagamento(
        String tipoViagem,
        boolean hasPontosTuristicos
    ) {
        double valor = hasPontosTuristicos ? TAXA_TURISMO : 0;

        if (tipoViagem == "ida") {
            valor += this.valorPassagem;
        } else if (tipoViagem == "volta") {
            valor += (this.valorPassagem * PC_DESC_VOLTA) / 100;
        } else {
            valor += this.valorPassagem * (1 + PC_DESC_VOLTA / 100);
        }

        return valor;
    }

    // imprimirPassagem(): método que imprime os detalhes da passagem.
    public void imprimirPassagem() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return (
            "Voo{" +
            "numeroVoo='" +
            numeroVoo +
            '\'' +
            ", origem='" +
            origem +
            '\'' +
            ", destino='" +
            destino +
            '\'' +
            ", valorPassagem=" +
            valorPassagem +
            ", assentosDisponiveis=" +
            assentosDisponiveis +
            '}'
        );
    }
}
