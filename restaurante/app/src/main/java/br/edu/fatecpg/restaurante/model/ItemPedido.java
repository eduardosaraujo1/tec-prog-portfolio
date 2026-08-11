package br.edu.fatecpg.restaurante.model;

public class ItemPedido {

    private String nomeDoPrato;
    private int quantidade;
    private double precoUnitario;

    public ItemPedido(
        String nomeDoPrato,
        int quantidade,
        double precoUnitario
    ) {
        this.nomeDoPrato = nomeDoPrato;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    public String getNomeDoPrato() {
        return nomeDoPrato;
    }

    public void setNomeDoPrato(String nomeDoPrato) {
        this.nomeDoPrato = nomeDoPrato;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    // Calcula o subtotal deste item específico
    public double getSubtotal() {
        return quantidade * precoUnitario;
    }

    @Override
    public String toString() {
        return (
            "ItemPedido{" +
            "nomeDoPrato='" +
            nomeDoPrato +
            '\'' +
            ", quantidade=" +
            quantidade +
            ", precoUnitario=" +
            precoUnitario +
            '}'
        );
    }
}
