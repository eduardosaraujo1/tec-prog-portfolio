package br.edu.fatecpg.restaurante.model;

import java.util.ArrayList;

public class Pedido {

    private int numero;
    private ArrayList<ItemPedido> itens;
    private double taxaEntrega;
    private int numeroMesa;

    public Pedido(int numero, double taxaEntrega) {
        this.numero = numero;
        this.taxaEntrega = taxaEntrega;
        this.itens = new ArrayList<ItemPedido>();
        this.numeroMesa = 0;
    }

    public int getNumero() {
        return numero;
    }

    public double getTaxaEntrega() {
        return taxaEntrega;
    }

    public void adicionarItem(ItemPedido item) {
        itens.add(item);
    }

    public void removerItem(ItemPedido item) {
        itens.remove(item);
    }

    public void reservarMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public double calcularTotalPedido() {
        double total = 0.0;
        for (ItemPedido item : itens) {
            total += item.getSubtotal();
        }
        return total + taxaEntrega;
    }

    @Override
    public String toString() {
        return (
            "Pedido{" +
            "numero=" +
            numero +
            ", itens=" +
            itens +
            ", taxaEntrega=" +
            taxaEntrega +
            ", numeroMesa=" +
            numeroMesa +
            '}'
        );
    }
}
