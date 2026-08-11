package br.edu.fatecpg.restaurante.model;

import java.util.ArrayList;

public class Restaurante {

    private ArrayList<Pedido> pedidos;

    public Restaurante() {
        this.pedidos = new ArrayList<Pedido>();
    }

    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public void removerPedido(int numeroPedido) {
        Pedido pedidoARemover = buscarPedido(numeroPedido);
        if (pedidoARemover != null) {
            pedidos.remove(pedidoARemover);
        }
    }

    public Pedido buscarPedido(int numero) {
        for (Pedido pedido : pedidos) {
            if (pedido.getNumero() == numero) {
                return pedido;
            }
        }
        return null;
    }

    public void exibirPedidos() {
        for (Pedido pedido : pedidos) {
            System.out.println(pedido.toString());
        }
    }
}
