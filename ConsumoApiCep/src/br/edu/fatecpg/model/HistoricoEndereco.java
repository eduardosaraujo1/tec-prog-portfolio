package br.edu.fatecpg.model;

import java.util.ArrayList;

public class HistoricoEndereco {
    private ArrayList<Endereco> historico;

    public HistoricoEndereco() {
        historico = new ArrayList<>();
    }

    public void addEndereco(Endereco e) {
        historico.add(e);
    }

    public void exibirHistorico() {
        if (historico.isEmpty()) {
            System.out.println("Não há nenhum cep consultado.");
            return;
        }
        for (Endereco e : historico) {
            System.out.println(e);
        }
    }

    public void limpar() {
        historico.clear();
    }

}
