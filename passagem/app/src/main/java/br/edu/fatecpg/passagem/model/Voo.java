package br.edu.fatecpg.passagem.model;

class Voo {

    private String numeroVoo;
    private String origem;
    private String destino;
    private int assentosDisponiveis;

    public Voo(
        String numeroVoo,
        String origem,
        String destino,
        int assentosDisponiveis
    ) {
        this.numeroVoo = numeroVoo;
        this.origem = origem;
        this.destino = destino;
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

    // realizarReserva(int quantidadeAssentos): método que realiza a reserva de uma
    // determinada quantidade de assentos.
    //  verificarDisponibilidade(int quantidadeAssentos): método que verifica se há assentos
    // disponíveis.
    //  realizarPagamento(String tipoViagem, boolean pontosTuristicos): método que realiza
    // o pagamento da passagem, considerando se é somente ida, ida e volta, e se inclui
    // pontos turísticos (taxa adicional).
    //  imprimirPassagem(): método que imprime os detalhes da passagem.
}
