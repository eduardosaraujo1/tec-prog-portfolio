package br.edu.fatecpg;

import br.edu.fatecpg.model.Endereco;
import br.edu.fatecpg.model.HistoricoEndereco;
import br.edu.fatecpg.service.ApiEndereco;

public class Main {
    public static void main(String[] args) {
        var api = new ApiEndereco();
        var hist = new HistoricoEndereco();

        try {
            Endereco e1 = api.obterEndereco("11702020");
            Endereco e2 = api.obterEndereco("11746164");

            hist.addEndereco(e1);
            hist.addEndereco(e2);
            hist.exibirHistorico();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}